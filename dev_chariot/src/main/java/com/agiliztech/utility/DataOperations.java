package com.agiliztech.utility;

import org.springframework.stereotype.Service;

import com.agiliztech.model.DataPoint;
import com.agiliztech.model.NewEventPerMinute;

@Service
public class DataOperations {
	
	
	public DataPoint sum(DataPoint dataPoint,double newValue) {
		double raw=dataPoint.getRaw();
		raw=raw+newValue;
		dataPoint.setRaw(raw);
		
		
		
		dataPoint.setConverted(raw);
		return dataPoint;
		
	}
	public DataPoint avg(NewEventPerMinute newEventPerMinute ,double newValue) {
		double sum=newEventPerMinute.getSum().getRaw();
		System.out.println("previousSum://"+sum);
		System.out.println("sum://"+sum);
		double avg = sum/newEventPerMinute.getNum_samples();
		System.out.println("avg://"+avg);
		DataPoint dataPoint = new DataPoint();
		dataPoint.setRaw(avg);
		dataPoint.setConverted(avg);
		return dataPoint;
		
	}
	public DataPoint max(DataPoint dataPoint,double newValue) {
		if(dataPoint.getRaw()>newValue) {
			dataPoint.setConverted(dataPoint.getRaw());
			return dataPoint;
		}else {
			dataPoint.setRaw(newValue);
			dataPoint.setConverted(newValue);
			return dataPoint;
		}
		
	}

}
