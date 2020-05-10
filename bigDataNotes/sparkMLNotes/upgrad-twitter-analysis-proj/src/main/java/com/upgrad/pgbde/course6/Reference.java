package com.upgrad.pgbde.course6;

import static org.apache.spark.sql.functions.col;
import java.util.Arrays;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
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

//https://stackoverflow.com/questions/46064099/failed-to-load-implementation-nativesystemblas-hibench/49811375

public class Reference {

	static Dataset<Row> originalDS = null;

	static Dataset<Row> selectedFeaturesDS = null;
	static Dataset<Row> finalFeaturesDS = null;

	static Dataset<Row> trainingDS = null;
	static Dataset<Row> testingDS = null;

	static Dataset<Row> trainingNBDS = null;
	static Dataset<Row> testingNBDS = null;

	static Dataset<Row> trainingDTCDS = null;
	static Dataset<Row> testingDTCDS = null;

	static Dataset<Row> trainingRFCDS = null;
	static Dataset<Row> testingRFCDS = null;

	static SparkSession sparkSession = null;

	static String[] labels = null;

	public static void initializeSpark() {

		try {

			Logger.getLogger("org").setLevel(Level.ERROR);
			Logger.getLogger("akka").setLevel(Level.ERROR);

			sparkSession = SparkSession.builder().appName("TwitterGenderClassification").master("local[*]")
					.getOrCreate();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	public static void loadAndPrepareDataSet(String inputPath) {

		String[] unwantedColumns = new String[20];

		try {

//To read the CSV file                           
			originalDS = sparkSession.read().option("header", true).csv(inputPath);
//To remove all unwanted columns                                                         
			unwantedColumns[0] = "_unit_id";
			unwantedColumns[1] = "_golden";
			unwantedColumns[2] = "_last_judgment_at";
			unwantedColumns[3] = "profile_yn";
			unwantedColumns[4] = "profile_yn:confidence";
			unwantedColumns[5] = "created";
			unwantedColumns[6] = "fav_number";
			unwantedColumns[7] = "gender_gold";
			unwantedColumns[8] = "link_color";
			unwantedColumns[9] = "name";
			unwantedColumns[10] = "profile_yn_gold";
			unwantedColumns[11] = "profileimage";
			unwantedColumns[12] = "retweet_count";
			unwantedColumns[13] = "sidebar_color";
			unwantedColumns[14] = "tweet_coord";
			unwantedColumns[15] = "tweet_count";
			unwantedColumns[16] = "tweet_created";
			unwantedColumns[17] = "tweet_id";
			unwantedColumns[18] = "tweet_location";
			unwantedColumns[19] = "user_timezone";

			for (String col : unwantedColumns) {

				originalDS = originalDS.drop(col);

			}

//to remove rows with null                            
			originalDS = originalDS.na().drop();
//to remove rows where gender is unknown                              
			originalDS = originalDS.filter(col("gender").notEqual("unknown")).filter(col("gender").notEqual(""));

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

//function for processing and encoding       
	public static void featureEngineeringAndEncoding() {

		Dataset<Row> featuresDS = null;

		/** HashingTF is a Transformer which takes sets of terms and converts those sets into fixed-length feature vectors */
		HashingTF descriptionHTF = null;

		HashingTF textHTF = null;

		/** IDF (Inverse document frequency) is an Estimator which is fit on a dataset and produces an IDFModel. The IDFModel takes feature vectors (generally created 
		 * from HashingTF or CountVectorizer) and scales each feature. Intuitively, it down-weights features which appear frequently in a corpus.*/
		IDF descriptionIDF = null;

		IDF textIDF = null;

		/** One-hot encoding maps a categorical feature, represented as a label index, to a binary vector with at most a single one-value 
		 * indicating the presence of a specific feature value from among the set of all feature values. This encoding allows algorithms which expect continuous features, 
		 * such as Logistic Regression, to use categorical features. For string type input data, it is common to encode categorical features using StringIndexer first.

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
		 * For example, a learning algorithm such as LogisticRegression is an Estimator, and calling fit() trains a LogisticRegressionModel, 
		 * which is a Model and hence a Transformer.
		 */
		OneHotEncoderEstimator ohee = null;

		OneHotEncoderModel oheeModel = null;

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
		StringIndexerModel labelIndexer = null;

		StringIndexerModel trustedJudgementsIndexer = null;

		StringIndexerModel unitStateIndexer = null;

		StringIndexerModel genderConfidenceIndexer = null;

		StopWordsRemover removerDescription = null;

		StopWordsRemover removerText = null;

		Tokenizer descriptionTokenizer = null;

		Tokenizer textTokenizer = null;

		try {

			labelIndexer = new StringIndexer().setInputCol("gender").setOutputCol("label").fit(originalDS);

			trustedJudgementsIndexer = new StringIndexer().setInputCol("_trusted_judgments")
					.setOutputCol("_trusted_judgments_index").fit(originalDS);

			unitStateIndexer = new StringIndexer().setInputCol("_unit_state").setOutputCol("_unit_state_index")
					.fit(originalDS);

			genderConfidenceIndexer = new StringIndexer().setInputCol("gender:confidence")
					.setOutputCol("gender:confidence_index").fit(originalDS);

			textTokenizer = new Tokenizer().setInputCol("text").setOutputCol("textWords");

			removerText = new StopWordsRemover().setInputCol(textTokenizer.getOutputCol()).setOutputCol("filteredText");

			textHTF = new HashingTF().setNumFeatures(1000).setInputCol(removerText.getOutputCol())
					.setOutputCol("numTextFeatures");

			textIDF = new IDF().setInputCol(textHTF.getOutputCol()).setOutputCol("textFeatures");

			descriptionTokenizer = new Tokenizer().setInputCol("description").setOutputCol("descriptionWords");

			removerDescription = new StopWordsRemover().setInputCol(descriptionTokenizer.getOutputCol())
					.setOutputCol("filteredDescription");

			descriptionHTF = new HashingTF().setNumFeatures(1000).setInputCol(removerDescription.getOutputCol())
					.setOutputCol("numDescriptionFeatures");

			descriptionIDF = new IDF().setInputCol(descriptionHTF.getOutputCol()).setOutputCol("descriptionFeatures");

			featurePipeline = new Pipeline().setStages(new PipelineStage[] { labelIndexer, trustedJudgementsIndexer,
					unitStateIndexer, genderConfidenceIndexer, textTokenizer, removerText, textHTF, textIDF,
					descriptionTokenizer, removerDescription, descriptionHTF, descriptionIDF });

			featurePipelineModel = featurePipeline.fit(originalDS);

			featuresDS = featurePipelineModel.transform(originalDS);

			ohee = new OneHotEncoderEstimator()
					.setInputCols(
							new String[] { "_trusted_judgments_index", "_unit_state_index", "gender:confidence_index" })
					.setOutputCols(new String[] { "categoryVec1", "categoryVec2", "categoryVec3" });

			oheeModel = ohee.fit(featuresDS);

			labels = new String[labelIndexer.labels().length];

			labels = Arrays.copyOf(labelIndexer.labels(), labelIndexer.labels().length);

			selectedFeaturesDS = oheeModel.transform(featuresDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//to assemble and selection data       
	public static void featureAssemblingAndSelection() {

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
		VectorAssembler assembler = null;

		try {

			assembler = new VectorAssembler().setInputCols(new String[] { "categoryVec1", "categoryVec2",
					"categoryVec3", "textFeatures", "descriptionFeatures" }).setOutputCol("features");

			finalFeaturesDS = assembler.transform(selectedFeaturesDS).select("label", "features", "gender");

			selector = new ChiSqSelector();

			selector.setNumTopFeatures(1000);
			selector.setLabelCol("label");
			selector.setFeaturesCol("features");
			selector.setOutputCol("finalFeatures");

			finalFeaturesDS = selector.fit(finalFeaturesDS).transform(finalFeaturesDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//to create training and testing DS    
	public static void splitDS() {

		Dataset<Row>[] splits = null;

		try {

			splits = finalFeaturesDS.randomSplit(new double[] { 0.8, 0.2 }, 1L);

			trainingDS = splits[0];
			testingDS = splits[1];

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//Naive Bayes Algo          
	public static void modelOnNaiveBayesAlgo() {

		IndexToString labelConverter = null;
		NaiveBayes nb = null;
		NaiveBayesModel nbModel = null;

		try {
			nb = new NaiveBayes().setLabelCol("label").setFeaturesCol("finalFeatures");

			nbModel = nb.fit(trainingDS);

			trainingNBDS = nbModel.transform(trainingDS);

			testingNBDS = nbModel.transform(testingDS);

			labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel")
					.setLabels(labels);

			testingNBDS = labelConverter.transform(testingNBDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//Decision Tree Algo       
	public static void modelOnDecisionTreeAlgo() {

		DecisionTreeClassifier dtc = null;
		DecisionTreeClassificationModel dtcModel = null;

		IndexToString labelConverter = null;

		try {

			dtc = new DecisionTreeClassifier().setLabelCol("label").setFeaturesCol("finalFeatures").setMaxDepth(30);

			dtcModel = dtc.fit(trainingDS);

			trainingDTCDS = dtcModel.transform(trainingDS);

			testingDTCDS = dtcModel.transform(testingDS);

			labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel")
					.setLabels(labels);

			testingDTCDS = labelConverter.transform(testingDTCDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//Random Forest Algo    
	public static void modelOnRandomForrestAlgo() {

		IndexToString labelConverter = null;

		RandomForestClassifier rfc = null;
		RandomForestClassificationModel rfcModel = null;

		try {

			rfc = new RandomForestClassifier().setImpurity("gini").setMaxDepth(30).setFeatureSubsetStrategy("auto")
					.setLabelCol("label").setFeaturesCol("finalFeatures");

			rfcModel = rfc.fit(trainingDS);

			trainingRFCDS = rfcModel.transform(trainingDS);

			testingRFCDS = rfcModel.transform(testingDS);

			labelConverter = new IndexToString().setInputCol("prediction").setOutputCol("predictedLabel")
					.setLabels(labels);

			testingRFCDS = labelConverter.transform(testingRFCDS);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//to evaluate all three models 
	public static void evaluateModelOnNaiveBayesAlgo() {

		double accuracyNBTrain;
		double accuracyNBTest;
		double weightedPrecisionNBTest;
		double weightedRecallNBTest;
		double f1ScorelNBTest;

		MulticlassClassificationEvaluator evaluator = null;

		try {

			evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction");
//to calculate accuracy, weighted precision and other parameters
			accuracyNBTrain = evaluator.setMetricName("accuracy").evaluate(trainingNBDS);
			accuracyNBTest = evaluator.setMetricName("accuracy").evaluate(testingNBDS);
			weightedPrecisionNBTest = evaluator.setMetricName("weightedPrecision").evaluate(testingNBDS);
			weightedRecallNBTest = evaluator.setMetricName("weightedRecall").evaluate(testingNBDS);
			f1ScorelNBTest = evaluator.setMetricName("f1").evaluate(testingNBDS);
//to calculate all parameters                          
			System.out.println("Naive Bayes Classifier:");
			System.out.println("-----------------------");
			System.out.println("");

			System.out.println("Test Accuracy = " + Math.round(accuracyNBTest * 100) + " %");
			System.out.println("");

			System.out.println("Training Accuracy = " + Math.round(accuracyNBTrain * 100) + " %");
			System.out.println("");

			System.out.println("Weighted Precision  = " + Math.round(weightedPrecisionNBTest * 100) + " %");
			System.out.println("");

			System.out.println("Weighted Recall = " + Math.round(weightedRecallNBTest * 100) + " %");
			System.out.println("");

			System.out.println("F1 Score = " + Math.round(f1ScorelNBTest * 100) + " %");
			System.out.println("");

			System.out.println("Confusion Matrix:");
			testingNBDS.groupBy(col("gender"), col("predictedLabel")).count().show();
			System.out.println("");
			System.out.println("");
			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//to evaluate models on decision tree algo 
	public static void evaluateModelOnDecisionTreeAlgo() {

		double accuracyDTCTrain;
		double accuracyDTCTest;
		double weightedPrecisionDTCTest;
		double weightedRecallDTCTest;
		double f1ScorelDTCTest;

		MulticlassClassificationEvaluator evaluator = null;

		try {

			evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction");

			accuracyDTCTrain = evaluator.setMetricName("accuracy").evaluate(trainingDTCDS);
			accuracyDTCTest = evaluator.setMetricName("accuracy").evaluate(testingDTCDS);
			weightedPrecisionDTCTest = evaluator.setMetricName("weightedPrecision").evaluate(testingDTCDS);
			weightedRecallDTCTest = evaluator.setMetricName("weightedRecall").evaluate(testingDTCDS);
			f1ScorelDTCTest = evaluator.setMetricName("f1").evaluate(testingDTCDS);

			System.out.println("Decision Tree Classifier:");
			System.out.println("-------------------------");
			System.out.println("");

			/*
			 * System.out.println("Training Data Accuracy = " + Math.round(accuracyDTCTrain
			 * * 100) + " %"); System.out.println("");
			 */

			System.out.println("Test Accuracy = " + Math.round(accuracyDTCTest * 100) + " %");
			System.out.println("");

			System.out.println("Training Accuracy = " + Math.round(accuracyDTCTrain * 100) + " %");
			System.out.println("");

			System.out.println("Weighted Precision  = " + Math.round(weightedPrecisionDTCTest * 100) + " %");
			System.out.println("");

			System.out.println("Weighted Recall = " + Math.round(weightedRecallDTCTest * 100) + " %");
			System.out.println("");

			System.out.println("F1 Score = " + Math.round(f1ScorelDTCTest * 100) + " %");
			System.out.println("");

			System.out.println("Confusion Matrix:");
			testingDTCDS.groupBy(col("gender"), col("predictedLabel")).count().show();
			System.out.println("");
			System.out.println("");
			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//to evaluate models on Random forest algo        
	public static void evaluateModelOnRandomForrestAlgo() {

		double accuracyRFCTrain;
		double accuracyRFCTest;
		double weightedPrecisionRFCTest;
		double weightedRecallRFCTest;
		double f1ScorelRFCTest;

		MulticlassClassificationEvaluator evaluator = null;

		try {

			evaluator = new MulticlassClassificationEvaluator().setLabelCol("label").setPredictionCol("prediction");

			accuracyRFCTrain = evaluator.setMetricName("accuracy").evaluate(trainingRFCDS);
			accuracyRFCTest = evaluator.setMetricName("accuracy").evaluate(testingRFCDS);
			weightedPrecisionRFCTest = evaluator.setMetricName("weightedPrecision").evaluate(testingRFCDS);
			weightedRecallRFCTest = evaluator.setMetricName("weightedRecall").evaluate(testingRFCDS);
			f1ScorelRFCTest = evaluator.setMetricName("f1").evaluate(testingRFCDS);

			System.out.println("Random Forrest Classifier:");
			System.out.println("--------------------------");
			System.out.println("");

			/*
			 * System.out.println("Training Data Accuracy = " + Math.round(accuracyRFCTrain
			 * * 100) + " %"); System.out.println("");
			 */

			System.out.println("Test Accuracy = " + Math.round(accuracyRFCTest * 100) + " %");
			System.out.println("");

			System.out.println("Training Accuracy = " + Math.round(accuracyRFCTrain * 100) + " %");
			System.out.println("");

			System.out.println("Weighted Precision  = " + Math.round(weightedPrecisionRFCTest * 100) + " %");
			System.out.println("");

			System.out.println("Weighted Recall = " + Math.round(weightedRecallRFCTest * 100) + " %");
			System.out.println("");

			System.out.println("F1 Score = " + Math.round(f1ScorelRFCTest * 100) + " %");
			System.out.println("");

			System.out.println("Confusion Matrix:");
			testingRFCDS.groupBy(col("gender"), col("predictedLabel")).count().show();
			System.out.println("");
			System.out.println("");
			System.out.println("");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		System.setProperty("hadoop.home.dir", "C:\\winutils");

		String inputPath = "";
		if (args.length < 1) {
			inputPath = "gender.csv";
			inputPath = "gender-classifier-DFE-791531.csv";
		} else {
			inputPath = args[0];
		}

		try {
//calling all the functions                                
			initializeSpark();

			loadAndPrepareDataSet(inputPath);

			featureEngineeringAndEncoding();

			featureAssemblingAndSelection();

			splitDS();

			modelOnNaiveBayesAlgo();

			modelOnDecisionTreeAlgo();

			modelOnRandomForrestAlgo();

			evaluateModelOnNaiveBayesAlgo();

			evaluateModelOnDecisionTreeAlgo();

			evaluateModelOnRandomForrestAlgo();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (sparkSession != null) {
					sparkSession.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
