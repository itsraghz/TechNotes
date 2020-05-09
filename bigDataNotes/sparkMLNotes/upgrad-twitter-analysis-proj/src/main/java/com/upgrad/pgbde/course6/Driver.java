/**
 * 
 */
package com.upgrad.pgbde.course6;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
//import static org.apache.spark.sql.functions.*;
//import static org.apache.spark.sql.DataFrameNaFunctions.*;

/**
 * @author raghs
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//firstTry();
		latest();
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
		
		System.out.println();
		System.out.println("=================================================");
		System.out.println("Total # of rows in the dataset :: " + df.count());
		
		df = df.na().drop();
		System.out.println("Total # of rows in the dataset - after dropping null :: " + df.count());
		
		//df = df.withColumn("gender", when(col("gender").equalTo("brand"), null).otherwise(col("gender")));
		//System.out.println("Total # of rows in the dataset - [gender] after dropping 'brand' :: " + df.na().drop().count());
		df = df.na().drop();
		/*df = df.withColumn("gender", when(col("gender").equalTo("unknown"), null).otherwise(col("gender")));
		df= df.na().drop();
		System.out.println("Total # of rows in the dataset - [gender] after dropping 'unknown' :: " + df.count());
		df = df.withColumn("gender", when(col("gender").equalTo("0"), null).otherwise(col("gender")));
		df= df.na().drop();
		System.out.println("Total # of rows in the dataset - [gender] after dropping '0' :: " + df.count());
		df = df.withColumn("gender", when(col("gender").equalTo(""), null).otherwise(col("gender")));
		df= df.na().drop();
		System.out.println("Total # of rows in the dataset - [gender] after dropping 'blank' :: " + df.count());*/
		System.out.println("=================================================");
		System.out.println();
		
		df.show(5);

		spark.close();
	}
	
	/** 
	 * References
	 * ===========
	 * https:stackoverflow.com/questions/56005857/fill-null-values-with-empty-string-in-datasetrow-using-apache-spark-in-java?noredirect=1&lq=1
	 * https:stackoverflow.com/questions/44671597/how-to-replace-null-values-with-a-specific-value-in-dataframe-using-spark-in-jav/44671923 (Direct Link : https:stackoverflow.com/a/44671923/1001242)
	 * https:spark.apache.org/docs/latest/api/java/index.html
	 * https:spark.apache.org/docs/latest/api/java/org/apache/spark/sql/DataFrameNaFunctions.html#fill-java.lang.String-java.lang.String:A-
	 * https:github.com/eBay/Spark/blob/master/examples/src/main/java/org/apache/spark/examples/ml/JavaDecisionTreeClassificationExample.java
	 * [Excellent] https:towardsdatascience.com/apache-spark-mllib-tutorial-7aba8a1dce6e 
	 * https://spark.apache.org/docs/1.6.1/ml-guide.html#estimators
	 * https://spark.apache.org/docs/1.6.1/ml-guide.html#transformers
	 * https://stackoverflow.com/questions/17910290/clustering-sparse-vector-and-dense-vector/26706528#26706528
	 * 
	 * https://examples.javacodegeeks.com/apache-spark-machine-learning-tutorial/
	 * https://www.javacodegeeks.com/2016/02/apache-spark-machine-learning-tutorial.html
	 * 
	 */
	public static void latest() {
		// https://stackoverflow.com/questions/35652665/java-io-ioexception-could-not-locate-executable-null-bin-winutils-exe-in-the-ha
		System.setProperty("hadoop.home.dir", "C:\\winutils");
		SparkSession spark = SparkSession.builder().master("local").appName("GenderIdentificationFromTweet").getOrCreate();
		
		spark.sparkContext().setLogLevel("ERROR");
		
		Dataset<Row> df = spark.read().option("header", true).option("inferSchema", true).csv("gender-classifier-DFE-791531.csv");
		
		System.out.println("*********************************");
		//df.filter(df(colName).isNull || df(colName) === "" || df(colName).isNaN).count()
		
		String colName = "gender";
		if(df.col(colName)==null || df.col(colName).equals("") || df.col(colName).equals("blank") || df.col(colName).equals("unknown") || df.col(colName).equals("0")) 
			System.out.println("Count of missing gender : " + df.filter(df.col("gender")).count());
		
		long genderNullCount = df.filter(df.col("gender").isNull()).count();
		System.out.println("genderNullCount : " + genderNullCount);
		
		long genderBlankCount = df.filter(df.col("gender").contains(" ")).count();
		System.out.println("genderBlankCount : " + genderBlankCount);
		
		long genderBrandCount = df.filter(df.col("gender").$eq$eq$eq("brand")).count();
		System.out.println("genderBrandCount : " + genderBrandCount);	
		
		long genderBrandTripeEqualsCount = df.filter(df.col("gender").contains("brand")).count();
		System.out.println("genderBrandTripeEqualsCount : " + genderBrandTripeEqualsCount);	
		
		System.out.println("*********************************");
		
		//df.select("_unit_state","_trusted_judgments","gender","gender:confidence","profile_yn:confidence","gender_gold","link_color","name","profile_yn_gold","tweet_count","tweet_created","tweet_id","tweet_location","user_timezone");
		df = df.select("gender","gender:confidence","profile_yn:confidence","gender_gold","link_color","name","profile_yn_gold","tweet_count","tweet_id","tweet_location","user_timezone");
		
		df.show(15);
		df.printSchema();
		//df.describe().show();
		df.show();
		
		System.out.println();
		System.out.println("=================================================");
		System.out.println("Total # of rows in the dataset :: " + df.count());
		
		String[] colNames = {"user_timezone"};
		df = df.na().fill("missing_utc", colNames);
		df = df.na().drop();
		
		System.out.println("Total # of rows in the dataset after dropping nulls :: " + df.count());
		System.out.println("=================================================");
		System.out.println();
		
		df.show();

		spark.close();
	}

}
