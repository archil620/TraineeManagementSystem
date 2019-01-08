package com.igate.tms.dao;

import java.util.List;

import com.igate.tms.bean.IdTrainee;
import com.igate.tms.bean.Trainee;
import com.igate.tms.bean.User;

public interface ITraineeDao {

	public boolean validateUser(User u);
	public int addTrainee(Trainee t);
	public int delTrainee(Trainee t);
	public Trainee showTrainee(IdTrainee t);
	public int modifyTrainee(Trainee t);
	public List<Trainee> retrieveAll();
}
