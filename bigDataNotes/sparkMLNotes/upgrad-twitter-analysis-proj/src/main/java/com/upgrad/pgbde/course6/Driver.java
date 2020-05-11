package com.upgrad.pgbde.course6;

import static org.apache.spark.sql.functions.col;

import java.io.PrintStream;
import java.util.Arrays;

import org.apache.spark.ml.Pipeline;
import org.apache.spark.ml.PipelineModel;
import org.apache.spark.ml.PipelineStage;
import org.apache.spark.ml.classification.DecisionTreeClassificationModel;
import org.apache.spark.ml.classification.DecisionTreeClassifier;
import org.apache.spark.ml.classification.NaiveBayes;
import org.apache.spark.ml.classification.NaiveBayesModel;
import org.apache.spark.ml.classification.RandomForestClassificationModel;
import org.apache.spark.ml.classification.RandomForestClassifier;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;
import org.apache.spark.ml.feature.ChiSqSelector;
import org.apache.spark.ml.feature.HashingTF;
import org.apache.spark.ml.feature.IDF;
import org.apache.spark.ml.feature.IndexToString;
import org.apache.spark.ml.feature.OneHotEncoderEstimator;
import org.apache.spark.ml.feature.OneHotEncoderModel;
import org.apache.spark.ml.feature.StopWordsRemover;
import org.apache.spark.ml.feature.StringIndexer;
import org.apache.spark.ml.feature.StringIndexerModel;
import org.apache.spark.ml.feature.Tokenizer;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Driver {

	static Dataset<Row> originalDF = null;

	static Dataset<Row> selectedFeaturesDS = null;
	static Dataset<Row> finalFeatureDF = null;

	static Dataset<Row> trainingDF = null;
	static Dataset<Row> testingDF = null;

	static Dataset<Row> trainingNaiveBayesDF = null;
	static Dataset<Row> testingNaiveBayesDF = null;

	static Dataset<Row> trainingDecisionTreeDF = null;
	static Dataset<Row> testingDecisionTreeDF = null;

	static Dataset<Row> trainingRandomForestDF = null;
	static Dataset<Row> testingRandomForestDF = null;

	static SparkSession sparkSession = null;

	static String[] labels = null;

	public static void preprocess(String fileName) {

		try {

			originalDF = Config.getDataset(fileName);

			//"_unit_state","_trusted_judgments", "gender","gender:confidence", ""description", "text", 
			
			System.out.println("Columns to be dropped : " + Arrays.asList(Config.COLS_TO_BE_DROPPED));
		
			for (String col : Config.COLS_TO_BE_DROPPED) {
				originalDF = originalDF.drop(col);
			}

			System.out.println("Number of records in the dataset : "+ originalDF.count());
			
			System.out.println("Schema Inferred from the dataset : ");
			originalDF.printSchema();
			
			//Remove the rows whichever has a null value in any of the columns                     
			originalDF = originalDF.na().drop();
			
			System.out.println("Number of records in the dataset - after drop : "+ originalDF.count());
			
			//Remove the rows where `gender`  colum has the value `unknown`                             
			originalDF = originalDF.filter(col("gender").notEqual("unknown")).filter(col("gender").notEqual(""));
			
			System.out.println("Number of records in the dataset - after filtering out gender : "+ originalDF.count());

		} catch (Exception exception) {
			System.out.println("Exception occurred while loading and preparing data : "+exception.getMessage());
			exception.printStackTrace();
		}

	}

	public static void featureExtract() {

		Dataset<Row> featureDF = null;

		/** HashingTF is a Transformer which takes sets of terms and converts those sets into fixed-length feature vectors */
		HashingTF hashingTFForDesc = null;
		HashingTF hashingTFForText = null;

		/** IDF (Inverse document frequency) is an Estimator which is fit on a dataset and produces an IDFModel. The IDFModel takes feature vectors (generally created 
		 * from HashingTF or CountVectorizer) and scales each feature. Intuitively, it down-weights features which appear frequently in a corpus.*/
		IDF idfForDesc = null;
		IDF idfForText = null;

		/** One-hot encoding maps a categorical feature, represented as a label index, to a binary vector with at most a single one-value 
		 * indicating the presence of a specific feature value from among the set of all feature values. This encoding allows algorithms which expect continuous features, 
		 * such as System.out.printlnistic Regression, to use categorical features. For string type input data, it is common to encode categorical features using StringIndexer first.

			OneHotEncoderEstimator can transform multiple columns, returning an one-hot-encoded output vector column for each input column. It is common to 
			merge these vectors into a single feature vector using VectorAssembler.

			OneHotEncoderEstimator supports the handleInvalid parameter to choose how to handle invalid input during transforming data. Available options 
			include ‘keep’ (any invalid inputs are assigned to an extra categorical index) and ‘error’ (throw an error).
			
			Wikipedia on One-hot:
			---------------------
			In digital circuits and machine learning, a one-hot is a group of bits among which the legal combinations of values are only 
			those with a single high (1) bit and all the others low (0). A similar implementation in which all bits are '1' except 
			one '0' is sometimes called one-cold.
			
			One-hot encoding is often used for indicating the state of a state machine. When using binary or Gray code, a decoder is needed to 
			determine the state. A one-hot state machine, however, does not need a decoder as the state machine is in the nth state 
			if and only if the nth bit is high. 
		 */
		/**
		 * 	An Estimator is an algorithm which can be fit on a DataFrame to produce a Transformer. 
			E.g., a learning algorithm is an Estimator which trains on a DataFrame and produces a model.
		 */
		/**
		 * An Estimator abstracts the concept of a learning algorithm or any algorithm that fits or trains on data. 
		 * Technically, an Estimator implements a method fit(), which accepts a DataFrame and produces a Model, which is a Transformer. 
		 * For example, a learning algorithm such as System.out.printlnisticRegression is an Estimator, and calling fit() trains a System.out.printlnisticRegressionModel, 
		 * which is a Model and hence a Transformer.
		 */
		OneHotEncoderEstimator oneHotEncoderEstimator = null;

		OneHotEncoderModel oneHotEncoderModel = null;

		/**
		 * ML Pipelines provide a uniform set of high-level APIs built on top of DataFrames that help users create and tune practical machine learning pipelines.
		 * 
		 * A Pipeline chains multiple Transformers and Estimators together to specify an ML workflow.
		 */
		/**
		 * A Pipeline is specified as a sequence of stages, and each stage is either a Transformer or an Estimator. 
		 * These stages are run in order, and the input DataFrame is transformed as it passes through each stage. 
		 * For Transformer stages, the transform() method is called on the DataFrame. 
		 * For Estimator stages, the fit() method is called to produce a Transformer (which becomes part of the PipelineModel, or fitted Pipeline), 
		 * and that Transformer’s transform() method is called on the DataFrame.
		 */
		/**
		 * The ML Pipelines is a High-Level API for MLlib that lives under the “spark.ml” package. A pipeline consists of a sequence of stages. 
		 * There are two basic types of pipeline stages: Transformer and Estimator. 
		 * A Transformer takes a dataset as input and produces an augmented dataset as output. 
		 * E.g., a tokenizer is a Transformer that transforms a dataset with text into an dataset with tokenized words. 
		 * An Estimator must be first fit on the input dataset to produce a model, which is a Transformer that transforms the input dataset. 
		 * E.g., logistic regression is an Estimator that trains on a dataset with labels and features and produces a logistic regression model.
		 */
		/**
		 * Typically when running machine learning algorithms, it involves a sequence of tasks including 
		 * 	pre-processing, 
		 * 	feature extraction, 
		 * 	model fitting, and 
		 * 	validation stages. 
		 * For example, when classifying text documents might involve text segmentation and cleaning, extracting features, 
		 * and training a classification model with cross-validation. 
		 */
		Pipeline featurePipeline = null;

		PipelineModel featurePipelineModel = null;

		/**
		 * StringIndexer encodes a string column of labels to a column of label indices. The indices are in [0, numLabels), 
		 * and four ordering options are supported: 
		 * “frequencyDesc”: descending order by label frequency (most frequent label assigned 0), 
		 * “frequencyAsc”: ascending order by label frequency (least frequent label assigned 0), 
		 * “alphabetDesc”: descending alphabetical order, and 
		 * “alphabetAsc”: ascending alphabetical order (default = “frequencyDesc”). 
		 * 
		 * The unseen labels will be put at index numLabels if user chooses to keep them. 
		 * If the input column is numeric, we cast it to string and index the string values. 
		 * When downstream pipeline components such as Estimator or Transformer make use of this string-indexed label, 
		 * you must set the input column of the component to this string-indexed column name. 
		 * 
		 * In many cases, you can set the input column with setInputCol.
		 */
		/**
		 * During transformation, if the input column does not exist, StringIndexerModel. transform would return the input dataset unmodified. 
		 * This is a temporary fix for the case when target labels do not exist during prediction
		 */
		StringIndexerModel stringIndexerForLabel = null;
		StringIndexerModel stringIndexerForTrustedJudgements = null;
		StringIndexerModel stringIndexerForUnitState = null;
		StringIndexerModel stringIndexerForGenderConfidence = null;
		
		StopWordsRemover stopWordsRemoverForDesc = null;
		StopWordsRemover stopWordsRemoverForText = null;
		
		Tokenizer descriptionTokenizer = null;
		Tokenizer textTokenizer = null;

		try {

			stringIndexerForLabel = new StringIndexer().setInputCol("gender").setOutputCol("label").fit(originalDF);

			stringIndexerForTrustedJudgements = new StringIndexer().setInputCol("_trusted_judgments")
					.setOutputCol("_trusted_judgments_index").fit(originalDF);

			stringIndexerForUnitState = new StringIndexer().setInputCol("_unit_state").setOutputCol("_unit_state_index")
					.fit(originalDF);

			stringIndexerForGenderConfidence = new StringIndexer().setInputCol("gender:confidence")
					.setOutputCol("gender:confidence_index").fit(originalDF);

			textTokenizer = new Tokenizer().setInputCol("text").setOutputCol("textWords");

			stopWordsRemoverForText = new StopWordsRemover().setInputCol(textTokenizer.getOutputCol()).setOutputCol("filteredText");

			hashingTFForText = new HashingTF().setNumFeatures(1000).setInputCol(stopWordsRemoverForText.getOutputCol())
					.setOutputCol("numTextFeatures");

			idfForText = new IDF().setInputCol(hashingTFForText.getOutputCol()).setOutputCol("textFeatures");

			descriptionTokenizer = new Tokenizer().setInputCol("description").setOutputCol("descriptionWords");

			stopWordsRemoverForDesc = new StopWordsRemover().setInputCol(descriptionTokenizer.getOutputCol())
					.setOutputCol("filteredDescription");

			hashingTFForDesc = new HashingTF().setNumFeatures(1000).setInputCol(stopWordsRemoverForDesc.getOutputCol())
					.setOutputCol("numDescriptionFeatures");

			idfForDesc = new IDF().setInputCol(hashingTFForDesc.getOutputCol()).setOutputCol("descriptionFeatures");

			featurePipeline = new Pipeline().setStages(new PipelineStage[] { stringIndexerForLabel, stringIndexerForTrustedJudgements,
					stringIndexerForUnitState, stringIndexerForGenderConfidence, textTokenizer, stopWordsRemoverForText, hashingTFForText, idfForText,
					descriptionTokenizer, stopWordsRemoverForDesc, hashingTFForDesc, idfForDesc });

			featurePipelineModel = featurePipeline.fit(originalDF);

			featureDF = featurePipelineModel.transform(originalDF);

			oneHotEncoderEstimator = new OneHotEncoderEstimator()
					.setInputCols(
							new String[] { "_trusted_judgments_index", "_unit_state_index", "gender:confidence_index" })
					.setOutputCols(new String[] { "categoryVector1", "categoryVector2", "categoryVector3" });

			oneHotEncoderModel = oneHotEncoderEstimator.fit(featureDF);

			labels = new String[stringIndexerForLabel.labels().length];

			labels = Arrays.copyOf(stringIndexerForLabel.labels(), stringIndexerForLabel.labels().length);

			selectedFeaturesDS = oneHotEncoderModel.transform(featureDF);

		} catch (Exception exception) {
			System.out.println("Exception occurred while during the feature engineering : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void featureSelect() {

		/**
		 * Creates a ChiSquared feature selector. 
		 * The selector supports different selection methods: numTopFeatures, percentile, fpr. 
		 * - numTopFeatures chooses a fixed number of 
		 * top features according to a chi-squared test. - percentile is similar but chooses a fraction of all features instead of a fixed number. 
		 * - fpr chooses all features whose p-value is below a threshold, thus controlling the false positive rate of selection. 
		 * By default, the selection method is numTopFeatures, with the default number of top features set to 50.
		 */
		/**
		 * Chi-Squared feature selection, which selects categorical features to use for predicting a categorical label. 
		 */
		ChiSqSelector selector = null;
		VectorAssembler vectorAssembler = null;

		try {

			vectorAssembler = new VectorAssembler().setInputCols(new String[] { "categoryVector1", "categoryVector2",
					"categoryVector3", "textFeatures", "descriptionFeatures" }).setOutputCol("features");

			finalFeatureDF = vectorAssembler.transform(selectedFeaturesDS).select("label", "features", "gender");

			selector = new ChiSqSelector();

			selector.setNumTopFeatures(1000);
			selector.setLabelCol("label");
			selector.setFeaturesCol("features");
			selector.setOutputCol("finalFeatures");

			finalFeatureDF = selector.fit(finalFeatureDF).transform(finalFeatureDF);

		} catch (Exception exception) {
			System.out.println("Exception occurred while during the feature assembling : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void splitDataset() {

		Dataset<Row>[] split = null;

		try {

			split = finalFeatureDF.randomSplit(new double[] { Config.RATIO_TRAINING_DATASET, Config.RATIO_TEST_DATASET }, Config.SEED);
			
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.println("Splitting the dataset ......");
			System.out.println("=============================");
			System.out.println("Training Dataset Ratio : " + Config.RATIO_TRAINING_DATASET);
			System.out.println("Testing Dataset Ratio : " + Config.RATIO_TEST_DATASET);
			System.out.println("Seed : " + Config.SEED);

			trainingDF = split[0];
			testingDF = split[1];
			
			System.out.println("Training data frame count : " + trainingDF.count());
			System.out.println("Testing data frame count : " + testingDF.count());
			System.out.println("---------------------------------------------------------------");
			System.out.println();

		} catch (Exception exception) {
			System.out.println("Exception occurred while splitting the Dataset : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void modelForNaiveBayes() {

		IndexToString labelConverter = null;
		NaiveBayes naiveBayes = null;
		NaiveBayesModel naiveBayesModel = null;

		try {
			naiveBayes = new NaiveBayes().setLabelCol("label").setFeaturesCol("finalFeatures");

			naiveBayesModel = naiveBayes.fit(trainingDF);

			trainingNaiveBayesDF = naiveBayesModel.transform(trainingDF);

			testingNaiveBayesDF = naiveBayesModel.transform(testingDF);

			labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel")
					.setLabels(labels);

			testingNaiveBayesDF = labelConverter.transform(testingNaiveBayesDF);

		} catch (Exception exception) {
			System.out.println("Exception occurred while preparing the Naive Bayes (NB) Model : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void modelForDecisionTree() {

		DecisionTreeClassifier decisionTreeClassifier = null;
		DecisionTreeClassificationModel decisionTreeClassificationModel = null;

		IndexToString labelConverter = null;

		try {

			decisionTreeClassifier = new DecisionTreeClassifier().setLabelCol("label").setFeaturesCol("finalFeatures").setMaxDepth(30);

			decisionTreeClassificationModel = decisionTreeClassifier.fit(trainingDF);

			trainingDecisionTreeDF = decisionTreeClassificationModel.transform(trainingDF);

			testingDecisionTreeDF = decisionTreeClassificationModel.transform(testingDF);

			labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel")
					.setLabels(labels);

			testingDecisionTreeDF = labelConverter.transform(testingDecisionTreeDF);

		} catch (Exception exception) {
			System.out.println("Exception occurred while preparing the Decision Tree (DT) Model : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void modelForRandomForrest() {

		IndexToString labelConverter = null;

		RandomForestClassifier randomForestClassifier = null;
		RandomForestClassificationModel randomForestClassificationModel = null;

		try {

			randomForestClassifier = new RandomForestClassifier().setImpurity("gini").setMaxDepth(30).setFeatureSubsetStrategy("auto")
					.setLabelCol("label").setFeaturesCol("finalFeatures");

			randomForestClassificationModel = randomForestClassifier.fit(trainingDF);

			trainingRandomForestDF = randomForestClassificationModel.transform(trainingDF);

			testingRandomForestDF = randomForestClassificationModel.transform(testingDF);

			labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel")
					.setLabels(labels);

			testingRandomForestDF = labelConverter.transform(testingRandomForestDF);

		} catch (Exception exception) {
			System.out.println("Exception occurred while preparing the Random Forest (RF) Model : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void evaluateModelForNaiveBayes() {

		double naiveBayesTrainingAccuracy;
		double navieBayesTestAccuracy;
		double naiveBayesWeightedPrecisionTest;
		double navieBayesWeightedRecallTest;
		double naiveBayesF1Score;

		MulticlassClassificationEvaluator evaluator = null;

		try {

			evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction");
			
			/** Calculate accuracy, weighted precision and other parameters */
			naiveBayesTrainingAccuracy = evaluator.setMetricName("accuracy").evaluate(trainingNaiveBayesDF);
			navieBayesTestAccuracy = evaluator.setMetricName("accuracy").evaluate(testingNaiveBayesDF);
			naiveBayesWeightedPrecisionTest = evaluator.setMetricName("weightedPrecision").evaluate(testingNaiveBayesDF);
			navieBayesWeightedRecallTest = evaluator.setMetricName("weightedRecall").evaluate(testingNaiveBayesDF);
			naiveBayesF1Score = evaluator.setMetricName("f1").evaluate(testingNaiveBayesDF);
			
			System.out.println("----------------------------");
			System.out.println("## Naive Bayes Classifier ##");
			System.out.println("----------------------------");
			System.out.println("Test Accuracy = " + Math.round(navieBayesTestAccuracy * 100) + " %");
			System.out.println("Training Accuracy = " + Math.round(naiveBayesTrainingAccuracy * 100) + " %");
			System.out.println("Weighted Precision  = " + Math.round(naiveBayesWeightedPrecisionTest * 100) + " %");
			System.out.println("Weighted Recall = " + Math.round(navieBayesWeightedRecallTest * 100) + " %");
			System.out.println("F1 Score = " + Math.round(naiveBayesF1Score * 100) + " %");
			System.out.println("");
			System.out.println("Confusion Matrix :");
			testingNaiveBayesDF.groupBy(col("gender"), col("predictedLabel")).count().show();
			System.out.println("");

		} catch (Exception exception) {
			System.out.println("Exception occurred while during the Naive Bayes (NB) evaluation : "+exception.getMessage());
			exception.printStackTrace();
		}

	}

	public static void evaluateModelForDecisionTree() 
	{
		double decisionTreeTrainingAccuracy;
		double decisionTreeTestAccuracy;
		double decisionTreeWeightPrecisionTest;
		double decisionTreeWeightedRecallTest;
		double decisionTreeF1Score;

		MulticlassClassificationEvaluator evaluator = null;

		try {

			evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction");

			decisionTreeTrainingAccuracy = evaluator.setMetricName("accuracy").evaluate(trainingDecisionTreeDF);
			decisionTreeTestAccuracy = evaluator.setMetricName("accuracy").evaluate(testingDecisionTreeDF);
			decisionTreeWeightPrecisionTest = evaluator.setMetricName("weightedPrecision").evaluate(testingDecisionTreeDF);
			decisionTreeWeightedRecallTest = evaluator.setMetricName("weightedRecall").evaluate(testingDecisionTreeDF);
			decisionTreeF1Score = evaluator.setMetricName("f1").evaluate(testingDecisionTreeDF);

			System.out.println("------------------------------");
			System.out.println("## Decision Tree Classifier ##");
			System.out.println("------------------------------");

			System.out.println("Test Accuracy = " + Math.round(decisionTreeTestAccuracy * 100) + " %");
			System.out.println("Training Accuracy = " + Math.round(decisionTreeTrainingAccuracy * 100) + " %");
			System.out.println("Weighted Precision  = " + Math.round(decisionTreeWeightPrecisionTest * 100) + " %");
			System.out.println("Weighted Recall = " + Math.round(decisionTreeWeightedRecallTest * 100) + " %");
			System.out.println("F1 Score = " + Math.round(decisionTreeF1Score * 100) + " %");
			System.out.println("");
			System.out.println("Confusion Matrix:");
			testingDecisionTreeDF.groupBy(col("gender"), col("predictedLabel")).count().show();
			System.out.println("");

		} catch (Exception exception) {
			System.out.println("Exception occurred while during the Decision Tree (DT) evaluation : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void evaluateModelForRandomForrest() {

		double randomForestTrainingAccuracy;
		double randomForestTestAccuracy;
		double randomForestWeightedPrecision;
		double randomForestWeightedRecall;
		double randomForestF1Score;

		MulticlassClassificationEvaluator evaluator = null;

		try {

			evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction");

			randomForestTrainingAccuracy = evaluator.setMetricName("accuracy").evaluate(trainingRandomForestDF);
			randomForestTestAccuracy = evaluator.setMetricName("accuracy").evaluate(testingRandomForestDF);
			randomForestWeightedPrecision = evaluator.setMetricName("weightedPrecision").evaluate(testingRandomForestDF);
			randomForestWeightedRecall = evaluator.setMetricName("weightedRecall").evaluate(testingRandomForestDF);
			randomForestF1Score = evaluator.setMetricName("f1").evaluate(testingRandomForestDF);

			System.out.println("-----------------------------------------");
			System.out.println("## Random Forest Classifier Evaluation ##");
			System.out.println("-----------------------------------------");
			System.out.println("Test Accuracy = " + Math.round(randomForestTestAccuracy * 100) + " %");
			System.out.println("Training Accuracy = " + Math.round(randomForestTrainingAccuracy * 100) + " %");
			System.out.println("Weighted Precision  = " + Math.round(randomForestWeightedPrecision * 100) + " %");
			System.out.println("Weighted Recall = " + Math.round(randomForestWeightedRecall * 100) + " %");
			System.out.println("F1 Score = " + Math.round(randomForestF1Score * 100) + " %");
			System.out.println("");
			System.out.println("Confusion Matrix:");
			testingRandomForestDF.groupBy(col("gender"), col("predictedLabel")).count().show();
			System.out.println("");

		}  catch (Exception exception) {
			System.out.println("Exception occurred while during the Random Forest (RF) evaluation : "+exception.getMessage());
			exception.printStackTrace();
		}
	}

	public static void model() {
		modelForNaiveBayes();
		modelForDecisionTree();
		modelForRandomForrest();
	}
	
	public static void evaluate() {
		evaluateModelForNaiveBayes();
		evaluateModelForDecisionTree();
		evaluateModelForRandomForrest();
	}
	
	public static void main(String[] args) {
		
		System.out.println("===========  Execution Started =============");
		
		System.setProperty("hadoop.home.dir", "C:\\winutils");

		String fileName = "";
		if (args.length < 1) {
			fileName = Config.FILE_NAME;
		} else {
			fileName = args[0];
		}

		try {
			preprocess(fileName);
			featureExtract();
			featureSelect();
			splitDataset();
			model();
			evaluate();
		} catch (Exception exception) {
			System.out.println("Exception occurred while during the main flow : "+exception.getMessage());
			exception.printStackTrace();
		} finally {
			try {
				if (sparkSession != null) {
					sparkSession.close();
				}
			}  catch (Exception exception) {
				System.out.println("Exception occurred while closing the Spark Session Instance : "+exception.getMessage());
				exception.printStackTrace();
			}
		}
		
		System.out.println("===========  Execution Completed =============");
		
	}
	
	static PrintStream console  = System.out;
}
