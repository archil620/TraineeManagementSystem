package com.igate.tms.bean;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

public class Trainee {
	
	
	private int traineeId;
	private String traineeName;
	private String traineeDomain;
	private String traineeLocation;
	private String[] location;
	
	
	public String[] getLocation() {
		return location;
	}
	public void setLocation(String[] location) {
		this.location = location;
	}
	//@NotEmpty(message="TraineeId is empty")
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
		this.traineeId = traineeId;
	}
	
	@NotEmpty(message="TraineeName is empty")
	@Pattern(regexp="^[a-z\\sA-Z]+$",message="Please Enter Alphabets Only!")
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	
	@NotEmpty(message="TraineeDomain is empty")
	public String getTraineeDomain() {
		return traineeDomain;
	}
	public void setTraineeDomain(String traineeDomain) {
		this.traineeDomain = traineeDomain;
	}
	
	@NotEmpty(message="TraineeLocation is empty")
	public String getTraineeLocation() {
		return traineeLocation;
	}
	public void setTraineeLocation(String traineeLocation) {
		this.traineeLocation = traineeLocation;
	}
	@Override
	public String toString() {
		return "Trainee [traineeId=" + traineeId + ", traineeName="
				+ traineeName + ", traineeDomain=" + traineeDomain
				+ ", traineeLocation=" + traineeLocation + "]";
	}
	
	
	
}
