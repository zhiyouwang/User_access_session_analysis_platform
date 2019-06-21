package com.wang.sparkproject.test;

import com.wang.sparkproject.dao.ITaskDAO;
import com.wang.sparkproject.dao.factory.DAOFactory;
import com.wang.sparkproject.domain.Task;

/**
 * 任务管理DAO测试类
 * 
 * @author boyWang
 *
 */
public class TaskDAOTest {
	
	public static void main(String[] args) {
		ITaskDAO taskDAO = DAOFactory.getTaskDAO();
		Task task = taskDAO.findById(1);
		System.out.println(task.getTaskName());
	}

}
