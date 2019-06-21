package com.wang.sparkproject.dao.factory;

import com.wang.sparkproject.dao.ISessionAggrStatDAO;
import com.wang.sparkproject.dao.ISessionDetailDAO;
import com.wang.sparkproject.dao.ISessionRandomExtractDAO;
import com.wang.sparkproject.dao.ITaskDAO;
import com.wang.sparkproject.dao.ITop10CategoryDAO;
import com.wang.sparkproject.dao.ITop10CategorySessionDAO;
import com.wang.sparkproject.dao.impl.SessionAggrStatDAOImpl;
import com.wang.sparkproject.dao.impl.SessionDetailDAOImpl;
import com.wang.sparkproject.dao.impl.SessionRandomExtractDAOImpl;
import com.wang.sparkproject.dao.impl.TaskDAOImpl;
import com.wang.sparkproject.dao.impl.Top10CategoryDAOImpl;
import com.wang.sparkproject.dao.impl.Top10CategorySessionDAOImpl;

/**
 * DAO工厂类
 * 
 * @author boyWang
 *
 */
public class DAOFactory {

	/**
	 * 获取任务管理DAO
	 * 
	 * @return DAO
	 */
	public static ITaskDAO getTaskDAO() {
		return new TaskDAOImpl();
	}

	public static ISessionAggrStatDAO getSessionAggrStatDAO() {
		
		return new SessionAggrStatDAOImpl();
	}
	
	public static ISessionRandomExtractDAO getSessionExtractDAO() {
		return new SessionRandomExtractDAOImpl();
	}
	
	public static ISessionDetailDAO getSessionDetailDAO() {
		return new SessionDetailDAOImpl();
	}
	
	public static ITop10CategoryDAO getTop10CategoryDAO() {
		return new Top10CategoryDAOImpl();
	}
	
	public static ITop10CategorySessionDAO getTopITop10CategorySessionDAO() {
		return new Top10CategorySessionDAOImpl();
	}
	
}
