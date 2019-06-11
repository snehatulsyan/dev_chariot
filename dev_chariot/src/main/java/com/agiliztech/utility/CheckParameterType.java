package com.agiliztech.utility;

import org.springframework.stereotype.Service;

import com.agiliztech.model.InitialMinuteReading;

@Service
public class CheckParameterType {
	
	
	public double getTypeValue(InitialMinuteReading initialMinuteReading,String type) {
		double response=0.00;
		switch (type) {
		  case "cycle":
			  response=initialMinuteReading.getCycle();
		   break;
		  case "model_auto":
			    response= initialMinuteReading.getModel_auto();
			    break;
		  case "model_manual":
			    response= initialMinuteReading.getModel_manual();
			    break;
		  case "operation_running":
			    response= initialMinuteReading.getOperation_running();
			    break;
		  case "operation_breakdown":
			    response= initialMinuteReading.getOperation_breakdown();
			    break;
		  case "operation_stop":
			    response= initialMinuteReading.getOperation_stop();
			    break;
		  case "part_count":
			    response= initialMinuteReading.getPart_count();
			    break;
		  case "fault":
			    response= initialMinuteReading.getFault();
			    break;
		  case "energy":
			    response= initialMinuteReading.getEnergy();
			    break;
		  case "pressure":
			    response= initialMinuteReading.getPressure();
			    break;
		  
		}
			
return response;
}
}
