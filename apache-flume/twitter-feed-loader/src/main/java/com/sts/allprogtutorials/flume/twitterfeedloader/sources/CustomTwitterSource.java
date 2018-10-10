package com.sts.allprogtutorials.flume.twitterfeedloader.sources;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.flume.Context;
import org.apache.flume.source.twitter.TwitterSource;

import twitter4j.TwitterStreamFactory;
import twitter4j.auth.AccessToken;

public class CustomTwitterSource extends TwitterSource{

	  @Override
	  public void configure(Context context) {
	    String consumerKey = context.getString("consumerKey");
	    String consumerSecret = context.getString("consumerSecret");
	    String accessToken = context.getString("accessToken");
	    String accessTokenSecret = context.getString("accessTokenSecret");

	    LOGGER.info("Consumer Key:        '" + consumerKey + "'");
	    LOGGER.info("Consumer Secret:     '" + consumerSecret + "'");
	    LOGGER.info("Access Token:        '" + accessToken + "'");
	    LOGGER.info("Access Token Secret: '" + accessTokenSecret + "'");

	    twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.setOAuthConsumer(consumerKey, consumerSecret);
	    twitterStream.setOAuthAccessToken(new AccessToken(accessToken,
	                                                      accessTokenSecret));
	    twitterStream.addListener(this);
	    avroSchema = createAvroSchema();
	    dataFileWriter = new DataFileWriter<GenericRecord>(
	        new GenericDatumWriter<GenericRecord>(avroSchema));

	    maxBatchSize = context.getInteger("maxBatchSize", maxBatchSize);
	    maxBatchDurationMillis = context.getInteger("maxBatchDurationMillis",
	                                                maxBatchDurationMillis);
	  }
}
