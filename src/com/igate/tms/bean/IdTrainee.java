package com.igate.tms.bean;

import org.hibernate.validator.constraints.NotEmpty;

public class IdTrainee {
	
	@NotEmpty(message="Please Enter ID")
	private String traineeId;

	public String getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(String traineeId) {
		this.traineeId = traineeId;
	}
	
	
}
