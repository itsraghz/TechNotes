package com.upgrad.pgbde.course6;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.sql.DataFrameReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * <p>
 * A class to contain all the configurations
 * </p>
 * @author raghs
 *
 */
public class Config {
	
	public static double RATIO_TRAINING_DATASET = 0.7;
	
	public static double RATIO_TEST_DATASET = 0.3;
	
	public static long SEED = 1L;
	
	public static final boolean EXTRA_OPTIONS_FOR_READING_FLAG  = true;
	
	public static final String FILE_NAME = "gender-classifier-DFE-791531.csv";
	
	public static final String APP_NAME  = "TwitterGenderClassification";
	
	public static final String ENV_NAME = "local[*]";
			
	public static SparkSession sparkSession = null;
	
	public static DataFrameReader getOptionsForDFRead(SparkSession sparkSession) {
		DataFrameReader dfr = sparkSession.read().option("header", true).option("inferSchema", true);
		
		if(EXTRA_OPTIONS_FOR_READING_FLAG) {
			dfr = dfr
					.option("mode", "DROPMALFORMED")
					//.option("charset", "ASCII")
					.option("charset", "UTF-8") 
					.option("encoding", "UTF-8") 
					.option("multiLine", "true")
					.option("escape", "\"")
					.option("timestampFormat", "MM/dd/yy HH:mm");
		}
		
		return dfr;
	}
	
	public static Dataset<Row> getDataset(String fileName) {
		Dataset<Row> df = null;
		
		String fileToRead = FILE_NAME;
		
		if(fileName!=null && fileName.trim().length()>0) {
			fileToRead = fileName;
		}
		
		df = getOptionsForDFRead(sparkSession).csv(fileToRead);
		
		return df;
	}
	
	static {
	
		Logger.getLogger("org").setLevel(Level.ERROR);

		sparkSession = SparkSession.builder()
					.appName(APP_NAME)
					.master(ENV_NAME)
					.getOrCreate();
		
		System.out.println("Spark Session Intialized with the App Name : [" + APP_NAME + "] on the Environment [" + ENV_NAME + "]");
	}


	/* Not Used */
	public static String[] ALL_COLS = new String[] {
			"_unit_id","_golden","_unit_state","_trusted_judgments","_last_judgment_at","gender","gender:confidence",
			"profile_yn","profile_yn:confidence","created","description","fav_number","gender_gold","link_color","name","profile_yn_gold",
			"profileimage","retweet_count","sidebar_color","text","tweet_coord","tweet_count","tweet_created","tweet_id","tweet_location",
			"user_timezone"
	};
	
	public static String[] COLS_TO_BE_DROPPED = new String[] {
			"_unit_id","_golden","_last_judgment_at", "profile_yn","profile_yn:confidence",
			"created", "fav_number","gender_gold","link_color","name","profile_yn_gold",
			"profileimage","retweet_count","sidebar_color","tweet_coord","tweet_count",
			"tweet_created","tweet_id","tweet_location", "user_timezone"
	};
}
