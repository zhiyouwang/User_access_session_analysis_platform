package com.wang.sparkproject.dao.impl;

import java.sql.ResultSet;

import com.wang.sparkproject.dao.ITaskDAO;
import com.wang.sparkproject.domain.Task;
import com.wang.sparkproject.jdbc.JDBCHelper;

/**
 * 任务管理DAO实现类
 * 
 * @author boyWang
 *
 */
public class TaskDAOImpl implements ITaskDAO {

	/**
	 * 根据主键查询任务
	 * 
	 * @param taskid 主键
	 * @return 任务
	 *
	 */
	@Override
	public Task findById(long taskid) {
		
		final Task task = new Task();

		String sql = "select * from task where task_id=?";
		Object[] params = new Object[] { taskid };

		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeQuery(sql, params, new JDBCHelper.QueryCallback() {

			@Override
			public void process(ResultSet rs) throws Exception {
				
				if (rs.next()) {
					Long taskid = rs.getLong(1);
					String taskName = rs.getString(2);
					String createTime = rs.getString(3);
					String startTime = rs.getString(4);
					String finishTime = rs.getString(5);
					String taskType = rs.getString(6);
					String taskStatus = rs.getString(7);
					String taskParam = rs.getString(8);

					task.setTaskid(taskid);
					task.setTaskName(taskName);
					task.setCreateTime(createTime);
					task.setStartTime(startTime);
					task.setFinishTime(finishTime);
					task.setTaskType(taskType);
					task.setTaskStatus(taskStatus);
					task.setTaskParam(taskParam);
				}
			}
		});
		return task;
	}

}
