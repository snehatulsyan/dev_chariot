package com.agiliztech.service;


import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agiliztech.model.DataPoint;
import com.agiliztech.model.InitialMinuteReading;
import com.agiliztech.model.InitialReading;
import com.agiliztech.model.NewEvent;
import com.agiliztech.model.NewEventPerMinute;
import com.agiliztech.repository.NewEventRepository;
import com.agiliztech.utility.CheckParameterType;
import com.agiliztech.utility.DataOperations;
import com.agiliztech.utility.TimeseriesUtility;

@Service
public class SaveEventService {
	
	@Autowired
	NewEventRepository newEventRepo;
		
	@Autowired
	CalculationService calculationService;
	
	@Autowired
	CheckParameterType checkParameterType;
	@Autowired
	DataOperations dataOperation;
	
	public List<NewEvent> findAllEvents(){
		
		return newEventRepo.findAll();
		
	}


	public String saveEvent(InitialReading inr) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dayToday =  LocalDateTime.parse(inr.getTs(),formatter);
		int min = dayToday.getMinute();
		System.out.println("minute: "+min);
		List<NewEvent> existingData = calculationService.checkTimestampExists(inr);
		System.out.println("existingData: "+existingData);
		if(!existingData.isEmpty()) {
			for(NewEvent newEvent : existingData) {
				System.out.println(newEvent.getType());
				double value=checkParameterType.getTypeValue(inr.getData(), newEvent.getType());
				System.out.println("value: "+value);
				HashMap<String,NewEventPerMinute> valueMap=newEvent.getValues();
				try {
					NewEventPerMinute model=valueMap.get(Integer.toString(min));
					System.out.println("model: "+model.toString());
					int num_samples=model.getNum_samples();
					DataPoint sum=model.getSum();
					DataPoint max=model.getMax();
					model.setNum_samples(num_samples+1);
					DataPoint newSum=dataOperation.sum(sum, value);
					model.setSum(newSum);
					System.out.println("newSum: "+newSum.toString());
					DataPoint newAvg=dataOperation.avg(model, value);
					System.out.println("newAvg: "+newAvg.toString());
					DataPoint newMax=dataOperation.max(max, value);
					System.out.println("newMax: "+newMax.toString());
					
					model.setAvg(newAvg);
					model.setMax(newMax);
					System.out.println("resultModel: "+model);
					valueMap.put(Integer.toString(min), model);
					newEvent.setValues(valueMap);
					newEvent.setTotal_samples(newEvent.getTotal_samples()+1);
					newEventRepo.save(newEvent);
				
				}catch(NullPointerException e) {
					System.out.println("in catch of ValueMap");
					NewEventPerMinute model = new NewEventPerMinute();
					model.setNum_samples(1);
					DataPoint sum = new DataPoint();
					sum.setRaw(value);
					sum.setConverted(value);
					DataPoint avg = new DataPoint();
					avg.setRaw(value);
					avg.setConverted(value);
					DataPoint max= new DataPoint();
					max.setRaw(value);
					max.setConverted(value);
					model.setSum(sum);
					model.setAvg(avg);
					model.setMax(max);
					valueMap.put(Integer.toString(min), model);
					newEvent.setValues(valueMap);
					newEvent.setTotal_samples(newEvent.getTotal_samples()+1);
					newEventRepo.save(newEvent);
				}
				
			}
			return "{\"response\":\"Minute Value Updated\"}";
		}else {
			InitialMinuteReading initialMinuteReading=inr.getData();
			Field fields[]=initialMinuteReading.getClass().getDeclaredFields();
			for (Field field : fields) {
				NewEvent newEvent=initialize(inr, field.getName());
				newEventRepo.save(newEvent);
			}
			return "{\"response\":\"Hour Value Inserted\"}";
		}
		
	
	}
	
	public NewEvent initialize(InitialReading inr,String type) {
		NewEvent newEvent = new NewEvent();
		newEvent.setDeviceid(inr.getDeviceId());
		newEvent.setTotal_samples(1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dayToday = LocalDateTime.parse(inr.getTs(),formatter);
		newEvent.setTimestampHour(TimeseriesUtility.timeModification(dayToday));
		newEvent.setType(type);
		double value=checkParameterType.getTypeValue(inr.getData(), type);
		int min = dayToday.getMinute();
		HashMap<String,NewEventPerMinute> valueMap = new HashMap<>();
		NewEventPerMinute model = new NewEventPerMinute();
		model.setNum_samples(1);
		DataPoint sum = new DataPoint();
		sum.setRaw(value);
		sum.setConverted(value);
		DataPoint avg = new DataPoint();
		avg.setRaw(value);
		avg.setConverted(value);
		DataPoint max= new DataPoint();
		max.setRaw(value);
		max.setConverted(value);
		model.setSum(sum);
		model.setAvg(avg);
		model.setMax(max);
		valueMap.put(Integer.toString(min), model);
		newEvent.setValues(valueMap);
		return newEvent;
		
	}
	
}
