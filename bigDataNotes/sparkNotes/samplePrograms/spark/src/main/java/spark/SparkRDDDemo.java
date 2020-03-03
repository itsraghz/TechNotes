/**
 * 
 */
package spark;

import java.util.Arrays;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

/**
 * @author raghs
 *
 */
public class SparkRDDDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SparkConf sparkConf = new SparkConf().setAppName("Spark Learing").setMaster("local[2]");
		JavaSparkContext jsc = new JavaSparkContext(sparkConf);
		
		JavaRDD<Integer> integerRDD = jsc.parallelize(Arrays.asList(1, 2, 3, 4, 50, 61, 72, 8, 9, 19, 31, 42, 53, 6, 7, 23));
		JavaRDD<Integer> filteredRDD = integerRDD.filter((x) -> (x > 10 ? false : true));
		JavaRDD<Integer> transformedRDD = filteredRDD.map((x) -> (x * x));
		int sumTransformed = transformedRDD.reduce((x,y) -> (x + y));
		
		System.out.println("Sum Transformed : " + sumTransformed);
		
	}

}
