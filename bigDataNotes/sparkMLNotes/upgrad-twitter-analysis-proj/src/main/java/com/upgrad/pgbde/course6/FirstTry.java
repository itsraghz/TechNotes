/**
 * 
 */
package com.upgrad.pgbde.course6;

import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.when;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
//import static org.apache.spark.sql.DataFrameNaFunctions.*;

/**
 * @author raghs
 *
 */
public class FirstTry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//firstTry();
		latest();
		//log("Test message to be written to a log file");
		
		
		/** Write the messages to a file, finally */
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void firstTry() {
		// https://stackoverflow.com/questions/35652665/java-io-ioexception-could-not-locate-executable-null-bin-winutils-exe-in-the-ha
		System.setProperty("hadoop.home.dir", "C:\\winutils");
		SparkSession spark = SparkSession.builder().master("local").appName("GenderIdentificationFromTweet").getOrCreate();
		
		spark.sparkContext().setLogLevel("ERROR");
		
		Dataset<Row> df = spark.read().option("header", true).option("inferSchema", true).csv("gender-classifier-DFE-791531.csv");
		
		df.show(15);
		df.printSchema();
		df.describe().show();
		df.show();
		
		log();
		log("=================================================");
		log("Total # of rows in the dataset :: " + df.count());
		
		df = df.na().drop();
		log("Total # of rows in the dataset - after dropping null :: " + df.count());
		
		//df = df.withColumn("gender", when(col("gender").equalTo("brand"), null).otherwise(col("gender")));
		//log("Total # of rows in the dataset - [gender] after dropping 'brand' :: " + df.na().drop().count());
		df = df.na().drop();
		/*df = df.withColumn("gender", when(col("gender").equalTo("unknown"), null).otherwise(col("gender")));
		df= df.na().drop();
		log("Total # of rows in the dataset - [gender] after dropping 'unknown' :: " + df.count());
		df = df.withColumn("gender", when(col("gender").equalTo("0"), null).otherwise(col("gender")));
		df= df.na().drop();
		log("Total # of rows in the dataset - [gender] after dropping '0' :: " + df.count());
		df = df.withColumn("gender", when(col("gender").equalTo(""), null).otherwise(col("gender")));
		df= df.na().drop();
		log("Total # of rows in the dataset - [gender] after dropping 'blank' :: " + df.count());*/
		log("=================================================");
		log();
		
		df.show(5);

		spark.close();
	}
	
	
	private static void checkFilteredCount(Dataset<Row> df, String colName, String condition) 
	{
		long genderNullCount = df.filter(df.col(colName).isNull()).count();
		log("genderNullCount : " + genderNullCount);
	}
	
	private static void getStats(Dataset<Row> df) {
		log("*********************************");
		log("   >>> getStats()   >>>>>> ");
		log("*********************************");
		
		//df.filter(df(colName).isNull || df(colName) === "" || df(colName).isNaN).count()
		
		String colName = "gender";
		if(df.col(colName)==null || df.col(colName).equals("") || df.col(colName).equals("blank") || df.col(colName).equals("unknown") || df.col(colName).equals("0")) 
			log("Count of missing gender : " + df.filter(df.col("gender")).count());
		
		long genderNullCount = df.filter(df.col("gender").isNull()).count();
		log("genderNullCount : " + genderNullCount);
		
		long genderEmptyCount = df.filter(df.col("gender").contains(" ")).count();
		log("genderEmptyCount : " + genderEmptyCount);
		
		long genderBrandCount = df.filter(df.col("gender").contains("brand")).count();
		log("genderBrandCount : " + genderBrandCount);	
		
		long genderBrandTripeEqualsCount = df.filter(df.col("gender").$eq$eq$eq("brand")).count();
		log("genderBrandTripeEqualsCount : " + genderBrandTripeEqualsCount);	
		
		log("*********************************");
		log("   <<<<< getStats()   <<<<<< ");
		log("*********************************");
	}
	
	/** 
	 * References
	 * ===========
	 * https://stackoverflow.com/questions/56005857/fill-null-values-with-empty-string-in-datasetrow-using-apache-spark-in-java?noredirect=1&lq=1
	 * https://stackoverflow.com/questions/44671597/how-to-replace-null-values-with-a-specific-value-in-dataframe-using-spark-in-jav/44671923 (Direct Link : https:stackoverflow.com/a/44671923/1001242)
	 * https://spark.apache.org/docs/latest/api/java/index.html
	 * https://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/DataFrameNaFunctions.html#fill-java.lang.String-java.lang.String:A-
	 * https://github.com/eBay/Spark/blob/master/examples/src/main/java/org/apache/spark/examples/ml/JavaDecisionTreeClassificationExample.java
	 * [Excellent] https:towardsdatascience.com/apache-spark-mllib-tutorial-7aba8a1dce6e 
	 * https://spark.apache.org/docs/1.6.1/ml-guide.html#estimators
	 * https://spark.apache.org/docs/1.6.1/ml-guide.html#transformers
	 * https://stackoverflow.com/questions/17910290/clustering-sparse-vector-and-dense-vector/26706528#26706528
	 * 
	 * [Good One] https://spark.apache.org/docs/latest/ml-features
	 * https://en.wikipedia.org/wiki/One-hot
	 * https://spark.apache.org/docs/latest/ml-features#onehotencoderestimator
	 * https://spark.apache.org/docs/latest/ml-features.html#stringindexer
	 * https://spark.apache.org/docs/latest/ml-pipeline.html
	 * https://spark.apache.org/docs/latest/ml-tuning.html
	 * https://databricks.com/glossary/what-are-ml-pipelines
	 * https://spark.apache.org/docs/2.3.0/api/java/org/apache/spark/ml/feature/StringIndexerModel.html
	 * https://spark.apache.org/docs/2.1.2/api/java/org/apache/spark/mllib/feature/ChiSqSelector.html
	 * https://spark.apache.org/docs/latest/api/java/org/apache/spark/ml/feature/ChiSqSelector.html
	 * https://spark.apache.org/docs/latest/mllib-feature-extraction.html#chisqselector
	 * 
	 * https://stackoverflow.com/questions/46064099/failed-to-load-implementation-nativesystemblas-hibench/49811375
	 * https://www.quora.com/What-is-more-preferable-in-machine-learning-the-accuracy-of-model-A-is-50-on-training-data-and-97-on-test-data-or-is-model-B-with-80-accuracy-on-train-data-and-75-accuracy-on-test-data-more-detail-in-comment-below-thank-you
	 * https://medium.com/machine-learning-intuition/overfitting-what-they-are-regularization-e950c2d66d50
	 * 
	 * https://examples.javacodegeeks.com/apache-spark-machine-learning-tutorial/
	 * https://www.javacodegeeks.com/2016/02/apache-spark-machine-learning-tutorial.html
	 * https://datascience.stackexchange.com/questions/9159/when-to-choose-linear-regression-or-decision-tree-or-random-forest-regression?newreg=5fdc4aecdeef46f98afb29ac141b50fd
	 * 
	 * https://sparkbyexamples.com/spark/spark-read-csv-file-into-dataframe/
	 * https://medium.com/@ManningBooks/ingesting-data-from-files-with-spark-part-1-csv-21b00e3cd270
	 * https://www.programcreek.com/java-api-examples/?class=org.apache.spark.sql.Dataset&method=show
	 * https://spark.apache.org/docs/latest/api/java/org/apache/spark/sql/DataFrameReader.html
	 * https://spark.apache.org/docs/latest/sql-programming-guide.html
	 * https://spark.apache.org/docs/latest/rdd-programming-guide.html
	 * https://www.analyticsvidhya.com/blog/2019/11/build-machine-learning-pipelines-pyspark/
	 * 
	 */
	public static void latest() {
		// https://stackoverflow.com/questions/35652665/java-io-ioexception-could-not-locate-executable-null-bin-winutils-exe-in-the-ha
		System.setProperty("hadoop.home.dir", "C:\\winutils");
		
		SparkSession spark = SparkSession.builder().master("local").appName("GenderIdentificationFromTweet").getOrCreate();
		
		spark.sparkContext().setLogLevel("ERROR");
		
		Dataset<Row> df = spark.read()
				.option("header", true)
				.option("inferSchema", true)
				.option("mode", "DROPMALFORMED")
				//.option("charset", "ASCII")
				.option("charset", "UTF-8") 
				.option("encoding", "UTF-8") 
				.option("multiLine", "true")
				.option("escape", "\"")
				.option("timestampFormat", "MM/dd/yy HH:mm")
				.csv("gender-classifier-DFE-791531.csv");
		
		getStats(df);
		
		df.show(15);
		df.printSchema();
		//df.describe().show();
		//df.show();
		
		log("================================================================");
		log("===============   AFTER  COLUMN SELECTION ======================");
		log("================================================================");
		
		//"gender:confidence", "profile_yn","profile_yn:confidence","created","description","fav_number","gender_gold","link_color","name","profile_yn_gold","profileimage","retweet_count","sidebar_color","text","tweet_coord","tweet_count","tweet_created","tweet_id","tweet_location","user_timezone"
		//df.select("_unit_state","_trusted_judgments","gender","gender:confidence","profile_yn:confidence","gender_gold","link_color","name","profile_yn_gold","tweet_count","tweet_created","tweet_id","tweet_location","user_timezone");
		

		/** All columns in the CSV File */
		//df  = df.select("_unit_id","_golden","_unit_state","_trusted_judgments","_last_judgment_at","gender","gender:confidence","profile_yn","profile_yn:confidence","created","description","fav_number","gender_gold","link_color","name","profile_yn_gold","profileimage","retweet_count","sidebar_color","text","tweet_coord","tweet_count","tweet_created","tweet_id","tweet_location","user_timezone");
		
		//df = df.select("gender","gender:confidence","profile_yn:confidence","gender_gold","link_color","name","profile_yn_gold","tweet_count","tweet_id","tweet_location","user_timezone");
		df  = df.select("gender","gender:confidence","profile_yn:confidence","description","name","profile_yn_gold","link_color", "tweet_location","user_timezone");
		
		df.show(15);
		df.printSchema();
		//df.describe().show();
		//df.show();
		
		log("");
		log("=================================================");
		log("Total # of rows in the dataset :: " + df.count());
		
		String[] colNames = {"user_timezone"};
		df = df.na().fill("missing_utc", colNames);
		colNames = new String[]{"gender:confidence"};
		df = df.na().fill("missing_gc", colNames);
		//colNames = new String[]{"text"};
		//df = df.na().fill("missing_text", colNames);
		colNames = new String[]{"description"};
		df = df.na().fill("missing_desc", colNames);
		
		
		//df = df.withColumn("gender", when(col("gender").equalTo("brand"), null).otherwise(col("gender")));
		//log("Total # of rows in the dataset - [gender] after dropping 'brand' :: " + df.na().drop().count());
		df = df.withColumn("gender", when(col("gender").equalTo("unknown"), null).otherwise(col("gender")));
		//log("Total # of rows in the dataset - [gender] after dropping 'unknown' :: " + df.count());
		df = df.withColumn("gender", when(col("gender").equalTo("0"), null).otherwise(col("gender")));
		//log("Total # of rows in the dataset - [gender] after dropping '0' :: " + df.count());
		df = df.withColumn("gender", when(col("gender").equalTo(""), null).otherwise(col("gender")));
		log("Total # of rows in the dataset - [gender] after dropping 'blank' :: " + df.count());
		
		df= df.na().drop();
		
		log("Total # of rows in the dataset after dropping nulls :: " + df.count());
		log("=================================================");
		log("");
		
		df.show();

		spark.close();
	}
	
	public static String getNow() {
		return getNow(null);
	}
	
	public static String getNow(String pattern) {
		if(Objects.isNull(pattern))
			pattern = "YYYY-MM-dd_HH-mm-ss_a_z";
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String now = sdf.format(new Date());
		
		//System.out.println("Current Date and Time is : " + now);
		
		return now;
	}
	
	private static String fileName = getNow() + "_ConsoleOutput-TwitterGenderAnalysis" + ".txt";
	
	private static StringBuilder outputMsgBfr = new StringBuilder();
	
	private static String NEW_LINE = System.getProperty("line.separator");
	
	public static void log(String msg)  {
		outputMsgBfr
			.append("[" + getNow() + "] - ")
			.append(msg)
			.append(NEW_LINE);
	}
	
	public static void log()  {
		outputMsgBfr.append("");
	}


	public static void writeToFile() throws Exception {
		FileWriter writer = new FileWriter(fileName, true);
		writer.write(outputMsgBfr.toString());
		writer.flush();
		writer.close();
		
		System.out.println("Output is written to the file -> [" + fileName + "]");
		
		System.out.println();
		
		System.out.println(outputMsgBfr.toString());
	}
}
