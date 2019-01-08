package com.igate.tms.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.igate.tms.bean.Trainee;

public class TraineeRowMapper implements RowMapper {

	@Override
	public Object mapRow(ResultSet rs, int index) throws SQLException {
		// TODO Auto-generated method stub
		
		Trainee trainee = new Trainee();
		trainee.setTraineeId(rs.getInt(1));
		trainee.setTraineeName(rs.getString(2));
		trainee.setTraineeLocation(rs.getString(3));
		trainee.setTraineeDomain(rs.getString(4));
		
		
		return trainee;
	}

}
