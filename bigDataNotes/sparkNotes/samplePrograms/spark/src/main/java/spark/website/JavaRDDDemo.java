package spark.website;

//package com.aksain.spark.basics.rdds;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author Amit Kumar
 * 
 * Demonstrates the usage of JavaRDD with a use case involving following steps -
 * 		- Filter out the numbers greater than 10
 * 		- Transform the numbers by calculating their squares
 * 		- Find out sum of all the transformed numbers
 * 
 */
public class JavaRDDDemo {
	
	public static void main(String[] args) {
		// Prepare the spark configuration by setting application name and master node "local" i.e. embedded mode
		final SparkConf sparkConf = new SparkConf().setAppName("Java RDD Demo").setMaster("local");
		
		// Create the Java Spark Context by passing spark config.
		try(final JavaSparkContext jSC = new JavaSparkContext(sparkConf)) {
			//Create Java RDD of type integer with list of integers
			final JavaRDD<Integer> intRDD = jSC.parallelize(Arrays.asList(1, 2, 3, 4, 50, 61, 72, 8, 9, 19, 31, 42, 53, 6, 7, 23));
			// Create a new Java RDD by removing numbers greater than 10 from integer RDD
			final JavaRDD<Integer> filteredRDD = intRDD.filter((x) -> (x > 10 ? false : true));
			// Create a new transformed RDD by transforming the numbers to their squares
			final JavaRDD<Integer> transformedRDD = filteredRDD.map((x) -> (x * x) );
			// Calculate the sum of all transformed integers. Since reduce is a value function, it will trigger actual execution
			final int sumTransformed = transformedRDD.reduce( (x, y) -> (x + y) );
			
			System.out.println(sumTransformed);
		}
	}
}
