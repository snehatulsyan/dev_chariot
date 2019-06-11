package com.agiliztech.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.agiliztech.model.InitialReading;
import com.agiliztech.model.NewEvent;
import com.agiliztech.utility.TimeseriesUtility;

@Service
public class CalculationService {

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<NewEvent> checkTimestampExists(InitialReading inr)
	{
		//LocalDateTime dayToday = inr;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dayToday = LocalDateTime.parse(inr.getTs(),formatter);
		String finalTimestamp = TimeseriesUtility.timeModification(dayToday);
		List<NewEvent> matchedEvents = mongoTemplate.find(new Query(Criteria.where("timestampHour").is(finalTimestamp)), NewEvent.class);
		return matchedEvents;
	}
}
