package com.igate.tms.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.igate.tms.bean.IdTrainee;
import com.igate.tms.bean.Trainee;
import com.igate.tms.bean.User;


@Repository
public class TraineeDao extends JdbcDaoSupport implements ITraineeDao {


	@Autowired
	public void setMyDataSource(DataSource myDataSource) {
		setDataSource(myDataSource);
	}

	
	/**
	 Method Name : validateUser
	Return Type : boolean
	Parameters  : u
	Package Name: com.igate.tms.dao
	Author      : av836011
	*/
	@Override
	public boolean validateUser(User u) {
		// TODO Auto-generated method stub
		boolean userPresent=false;
		
		String sql = "SELECT count(*) from Login where username=? AND password=?";
		int count=getJdbcTemplate().queryForInt(sql,u.getUsername(),u.getPassword());
		if(count==1)
		  userPresent=true;
		else
	      userPresent=false;		
			
		return userPresent;
	}

	/**
	 Method Name : addTrainee
	Return Type : int
	Parameters  : t
	Package Name: com.igate.tms.dao
	Author      : av836011
	*/
	@Override
	public int addTrainee(Trainee t) {
		// TODO Auto-generated method stub
		int rowCount = 0;
		
		String donorSequence = "SELECT donorid_seq.NEXTVAL from dual";
		int seq = getJdbcTemplate().queryForInt(donorSequence);
		
		String sql="INSERT INTO Trainee VALUES (?,?,?,?)";
		Object[] params = new Object[]{seq,t.getTraineeName(),t.getTraineeLocation(),t.getTraineeDomain()};
		rowCount = getJdbcTemplate().update(sql, params);
		
		return seq;
	}

	/**
	*************************************************
	Method Name : delTrainee
	Return Type : int
	Parameters  : t
	Package Name: com.igate.tms.dao
	Author      : av836011
	*************************************************
	*/
	@Override
	public int delTrainee(Trainee t) {
		// TODO Auto-generated method stub
		int rowCount = 0;
		
		String sql = "DELETE FROM Trainee WHERE trainee_id=?";
		Object[] params = new Object[]{t.getTraineeId()};
		rowCount=getJdbcTemplate().update(sql, params);
		
		return rowCount;
	}

	@Override
	public Trainee showTrainee(IdTrainee t) {
		// TODO Auto-generated method stub
	
		//List<Trainee> traineeList = new ArrayList<Trainee>();
		Trainee t1 = new Trainee();
		String sql = "SELECT * FROM trainee WHERE trainee_id=?";
		Object[] params = new Object[] { t.getTraineeId() };
		t1 = getJdbcTemplate().queryForObject(sql, params,new TraineeRowMapper());

		return t1;
	}

	@Override
	public int modifyTrainee(Trainee t) {
		// TODO Auto-generated method stub
		
		String sql = "UPDATE trainee SET Trainee_Name=?,trainee_location=?,"
				+ "trainee_domain=? WHERE trainee_id=?";
		
		Object[] params = new Object[]{t.getTraineeName(),t.getTraineeLocation(),
				t.getTraineeDomain(),t.getTraineeId()};
		int count = getJdbcTemplate().update(sql, params);
		
		return count;
	}

	@Override
	public List<Trainee> retrieveAll() {
		// TODO Auto-generated method stub
		
		String sql = "SELECT * FROM Trainee";
		
		return getJdbcTemplate().query(sql, new TraineeRowMapper());
	}

	
	
	
}
