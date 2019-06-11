package com.agiliztech.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class TimeseriesUtility {

	public static String timeModification(LocalDateTime date) {
		LocalDateTime ZeroMinutesDate = date.withMinute(00).withSecond(00);
		String response=ZeroMinutesDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		return response;
	}
	
	
	
}
