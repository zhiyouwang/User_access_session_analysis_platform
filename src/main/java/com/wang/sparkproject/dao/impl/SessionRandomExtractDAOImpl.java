package com.wang.sparkproject.dao.impl;

import com.wang.sparkproject.dao.ISessionRandomExtractDAO;
import com.wang.sparkproject.domain.SessionRandomExtract;
import com.wang.sparkproject.jdbc.JDBCHelper;

/**
 * 随机抽取session的DAO实现
 * @author boyWang
 *
 */
public class SessionRandomExtractDAOImpl implements ISessionRandomExtractDAO{

	
	/**
	 * 插入session随机抽取
	 * @param sessionAggrStat
	 */
	public void insert(SessionRandomExtract sessionRandomExtract) {
		String sql = "insert into session_random_extract values(?,?,?,?,?)";
		
		Object[] params = new Object[] {sessionRandomExtract.getTaskid(),
				sessionRandomExtract.getSessionid(),
				sessionRandomExtract.getStartTime(),
				sessionRandomExtract.getSearchKeyWords(),
				sessionRandomExtract.getClickCategoryIds()};
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeUpdate(sql, params);
		
	}

	
}
