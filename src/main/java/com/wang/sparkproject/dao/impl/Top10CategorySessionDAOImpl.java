package com.wang.sparkproject.dao.impl;

import com.wang.sparkproject.dao.ITop10CategorySessionDAO;
import com.wang.sparkproject.domain.Top10CategorySession;
import com.wang.sparkproject.jdbc.JDBCHelper;

/**
 * top10品类session接口实现
 * @author boyWang
 *
 */
public class Top10CategorySessionDAOImpl implements ITop10CategorySessionDAO{

	@Override
	public void insert(Top10CategorySession top10CategorySession) {
		String sql = "insert into top10_category_session values(?,?,?,?)";
		
		Object[] params = new Object[] {
				top10CategorySession.getTaskid(),
				top10CategorySession.getCategoryId(),
				top10CategorySession.getSessionId(),
				top10CategorySession.getClickCount()
		};
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeUpdate(sql, params);
	}

}
