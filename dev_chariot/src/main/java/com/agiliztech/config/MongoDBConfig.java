package com.agiliztech.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;

@Configuration
//@EnableMongoRepositories(basePackages = "com.agiliztech.repository", mongoTemplateRef = "chariot.dev.db")
public class MongoDBConfig {

	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port:27017}")
	private int mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String databaseName;

//	@Value("${spring.data.mongodb.username}")
//	private String username;
//
//	@Value("${spring.data.mongodb.password}")
//	private String password;

//	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
//		MongoCredential credential = MongoCredential.createMongoCRCredential(username, databaseName,
//				password.toCharArray());
//
//		List<ServerAddress> serverAddresses = new ArrayList<ServerAddress>();
//
//		List<String> hosts = Arrays.asList(mongoHost.split(","));
//		System.out.println("hosts :" + hosts);
//
//		for (String host : hosts)
//			serverAddresses.add(new ServerAddress(host, mongoPort));
//
//		System.out.println("password=" + password);
//
//		MongoClient mongoClient = new MongoClient(serverAddresses, Arrays.asList(credential));

//		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, databaseName);
		@SuppressWarnings("deprecation")
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(new Mongo(), databaseName);
		return simpleMongoDbFactory;

	}

//	@Bean
//	public MongoTemplate mongoTemplate() throws Exception {
//		@SuppressWarnings("deprecation")
//		MappingMongoConverter converter = 
//				new MappingMongoConverter(mongoDbFactory(), new MongoMappingContext());
//			converter.setTypeMapper(new DefaultMongoTypeMapper(null));
//		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(),converter);
//		return mongoTemplate;
//	}
	
	 @Bean
		public MongoTemplate mongoTemplate() throws Exception {
			return new MongoTemplate(mongoDbFactory());
		}
}
