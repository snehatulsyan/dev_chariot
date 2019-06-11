package com.agiliztech.model;


public class NewEventPerMinute {

	@Override
	public String toString() {
		return "NewEventPerMinute [num_samples=" + num_samples + ", sum=" + sum + ", avg=" + avg + ", max=" + max + "]";
	}
	private int num_samples;
	private DataPoint sum;
	private DataPoint avg;
	private DataPoint max;
	
	public int getNum_samples() {
		return num_samples;
	}
	public void setNum_samples(int num_samples) {
		this.num_samples = num_samples;
	}
	

	public DataPoint getSum() {
		return sum;
	}
	public void setSum(DataPoint sum) {
		this.sum = sum;
	}
	public DataPoint getAvg() {
		return avg;
	}
	public void setAvg(DataPoint avg) {
		this.avg = avg;
	}
	public DataPoint getMax() {
		return max;
	}
	public void setMax(DataPoint max) {
		this.max = max;
	}	
	
}
