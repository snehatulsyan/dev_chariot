package com.agiliztech.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agiliztech.model.InitialReading;
import com.agiliztech.model.NewEvent;
import com.agiliztech.repository.NewEventRepository;
import com.agiliztech.service.CalculationService;
import com.agiliztech.service.SaveEventService;

@RestController
@RequestMapping("/api/v1")
public class EventReportController {

	@Autowired
	NewEventRepository eventRepo;
	
	@Autowired
	SaveEventService eventService;
	
	@Autowired
	CalculationService calculationService;
	@Autowired
	SaveEventService saveEventService;
	
	@GetMapping("/findAll")
	public List<NewEvent> fetchAllData(){
		System.out.println("Going in findALll");
		return eventService.findAllEvents();
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody InitialReading inr){
		String response=saveEventService.saveEvent(inr);
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
//	@GetMapping("/{date}")
//	public NewEvent getEvent(@PathVariable String date) {
//		LocalDateTime localDate=LocalDateTime.parse(date);
//		return calculationService.checkTimestampExists(LocalDateTime.parse(date));
//	}

}
