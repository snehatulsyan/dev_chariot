package com.agiliztech.model;

public class DataPoint {

	@Override
	public String toString() {
		return "DataPoint [raw=" + raw + ", converted=" + converted + "]";
	}
	private double raw;
	
	public double getRaw() {
		return raw;
	}
	public void setRaw(double raw) {
		this.raw = raw;
	}
	private double converted;
	public double getConverted() {
		return converted;
	}
	public void setConverted(double converted) {
		this.converted = converted;
	}
	
}
