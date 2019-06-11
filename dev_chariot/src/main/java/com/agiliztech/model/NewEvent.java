package com.agiliztech.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "NewEvent")
public class NewEvent {

	@Id
	public String _id;
	
	@Indexed
	private String timestampHour;
	
	private String deviceid;
	private String type;
	private int total_samples;
	private HashMap<String,NewEventPerMinute> values;
	
	
	public HashMap<String, NewEventPerMinute> getValues() {
		return values;
	}
	public void setValues(HashMap<String, NewEventPerMinute> values) {
		this.values = values;
	}
	
	
	
	public String getTimestampHour() {
		return timestampHour;
	}
	public void setTimestampHour(String timestampHour) {
		this.timestampHour = timestampHour;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getTotal_samples() {
		return total_samples;
	}
	public void setTotal_samples(int total_samples) {
		this.total_samples = total_samples;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	@Override
	public String toString() {
		return "NewEvent [_id=" + _id + ", timestampHour=" + timestampHour + ", deviceid=" + deviceid + ", type=" + type
				+ ", total_samples=" + total_samples + ", values=" + values + "]";
	}
	

}
