package com.agiliztech.model;

public class InitialMinuteReading {

	private double cycle;
	private double model_auto;
	private double model_manual;
	private double operation_running;
	private double operation_breakdown;
	private double operation_stop;
	private double part_count;
	private double fault;
	private double energy;
	private double pressure;
	public double getCycle() {
		return cycle;
	}
	@Override
	public String toString() {
		return "InitialMinuteReading [cycle=" + cycle + ", model_auto=" + model_auto + ", model_manual=" + model_manual
				+ ", operation_running=" + operation_running + ", operation_breakdown=" + operation_breakdown
				+ ", operation_stop=" + operation_stop + ", part_count=" + part_count + ", fault=" + fault + ", energy="
				+ energy + ", pressure=" + pressure + "]";
	}
	public void setCycle(double cycle) {
		this.cycle = cycle;
	}
	public double getModel_auto() {
		return model_auto;
	}
	public void setModel_auto(double model_auto) {
		this.model_auto = model_auto;
	}
	public double getModel_manual() {
		return model_manual;
	}
	public void setModel_manual(double model_manual) {
		this.model_manual = model_manual;
	}
	public double getOperation_running() {
		return operation_running;
	}
	public void setOperation_running(double operation_running) {
		this.operation_running = operation_running;
	}
	public double getOperation_breakdown() {
		return operation_breakdown;
	}
	public void setOperation_breakdown(double operation_breakdown) {
		this.operation_breakdown = operation_breakdown;
	}
	public double getOperation_stop() {
		return operation_stop;
	}
	public void setOperation_stop(double operation_stop) {
		this.operation_stop = operation_stop;
	}
	public double getPart_count() {
		return part_count;
	}
	public void setPart_count(double part_count) {
		this.part_count = part_count;
	}
	public double getFault() {
		return fault;
	}
	public void setFault(double fault) {
		this.fault = fault;
	}
	public double getEnergy() {
		return energy;
	}
	public void setEnergy(double energy) {
		this.energy = energy;
	}
	public double getPressure() {
		return pressure;
	}
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}
	
	
	
	
}
