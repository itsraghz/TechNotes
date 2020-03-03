package spark.website;

//package com.aksain.spark.basics.rdds;

import java.util.Arrays;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

import scala.Tuple2;

/**
 * @author Amit Kumar
 * 
 * Demonstrates the usage of JavaPairRDD with a use case of counting the words in list of sentences.
 * 
 */
public class JavaPairRDDDemo {

	public static void main(String[] args) {
		// Prepare the spark configuration by setting application name and master node "local" i.e. embedded mode
		final SparkConf sparkConf = new SparkConf().setAppName("Java Pair RDD Demo").setMaster("local");
		
		// Create the Java Spark Context by passing spark config.
		try(final JavaSparkContext jSC = new JavaSparkContext(sparkConf)) {
			// Create Java RDD of type String with list of sentences
			final JavaRDD<String> sentenceRDD = jSC.parallelize(Arrays.asList(
						"Java RDD Like Demo",
						"Abstract Java RDD Like Demo",
						"Java RDD Demo",
						"Java Double RDD Demo",
						"Java Pair RDD Demo",
						"Java Hadoop RDD Demo",
						"java New Hadoop RDD Demo"
					));
			// Create a new Java RDD for words by splitting the sentences into words from sentence RDD
			final JavaRDD<String> wordsRDD = null;//sentenceRDD.flatMap( (x) -> Arrays.asList(x.split(" ")) );
			// Convert Java RDD to Java Pair RDD with key as word and value as 1
			final JavaPairRDD<String, Integer> individualWordsCountRDD =  wordsRDD.mapToPair( (x) -> new Tuple2<String, Integer>(x, 1));
			// Count all the occurrences of a word and get the results into Map with key as word and value as no of occurrences.
			final Map<String, Object> wordsCount = null;// individualWordsCountRDD.countByKey();
			
			System.out.println(wordsCount);
		}
	}
}
