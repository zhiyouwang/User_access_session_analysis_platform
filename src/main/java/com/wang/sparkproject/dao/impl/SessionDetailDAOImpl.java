package com.wang.sparkproject.dao.impl;

import com.wang.sparkproject.dao.ISessionDetailDAO;
import com.wang.sparkproject.domain.SessionDetail;
import com.wang.sparkproject.jdbc.JDBCHelper;

/**
 * session明细DAO接口实现类
 * @author boyWang
 *
 */
public class SessionDetailDAOImpl implements ISessionDetailDAO{

	@Override
	public void insert(SessionDetail sessionDetail) {
		String sql = "insert into session_detail values(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Object[] params = new Object[] {sessionDetail.getTaskid(),
				sessionDetail.getUserid(),
				sessionDetail.getSessionid(),
				sessionDetail.getPageid(),
				sessionDetail.getActionTime(),
				sessionDetail.getSearchKeyWord(),
				sessionDetail.getClickCategoryId(),
				sessionDetail.getClickProductId(),
				sessionDetail.getOrderCategoryIds(),
				sessionDetail.getOrderProductIds(),
				sessionDetail.getPayCategoryIds(),
				sessionDetail.getPayProductIds()};
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeUpdate(sql, params);
		
	}
	

}
