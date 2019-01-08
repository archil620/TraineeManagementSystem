package com.igate.tms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igate.tms.bean.IdTrainee;
import com.igate.tms.bean.Trainee;
import com.igate.tms.bean.User;
import com.igate.tms.dao.TraineeDao;

@Service("service")
public class TraineeService implements ITraineeService {

	@Autowired
	TraineeDao dao;

	@Override
	public boolean validateUser(User u) {
		// TODO Auto-generated method stub
		return dao.validateUser(u);
	}

	@Override
	public int addTrainee(Trainee t) {
		// TODO Auto-generated method stub
		return dao.addTrainee(t);
	}

	@Override
	public int delTrainee(Trainee t) {
		// TODO Auto-generated method stub
		return dao.delTrainee(t);
	}

	@Override
	public Trainee showTrainee(IdTrainee t) {
		// TODO Auto-generated method stub
		return dao.showTrainee(t);
	}

	@Override
	public int modifyTrainee(Trainee t) {
		// TODO Auto-generated method stub
		return dao.modifyTrainee(t);
	}

	@Override
	public List<Trainee> retrieveAll() {
		// TODO Auto-generated method stub
		return dao.retrieveAll();
	}
}
