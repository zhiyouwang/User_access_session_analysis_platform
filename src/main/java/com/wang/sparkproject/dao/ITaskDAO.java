package com.wang.sparkproject.dao;

import com.wang.sparkproject.domain.Task;

/**
 * 任务管理DAO接口
 * 
 * @author boyWang
 *
 */
public interface ITaskDAO {

	/**
	 * 根据主键查询任务
	 * 
	 * @param taskId
	 * @return 任务
	 */
	Task findById(long taskid);
}
