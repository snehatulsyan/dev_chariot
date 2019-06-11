package com.agiliztech.model;

import java.util.Date;
import java.util.List;

public class InitialReading {

	private String name;
	private String source;
	private InitialMinuteReading data;
	private String deviceId;
	private String ts;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	@Override
	public String toString() {
		return "InitialReading [name=" + name + ", source=" + source + ", data=" + data + ", deviceId=" + deviceId
				+ ", ts=" + ts + "]";
	}
	public void setSource(String source) {
		this.source = source;
	}
	
	public InitialMinuteReading getData() {
		return data;
	}
	public void setData(InitialMinuteReading data) {
		this.data = data;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getTs() {
		return ts;
	}
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	
	
}
