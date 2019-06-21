package com.wang.sparkproject.dao.impl;

import com.wang.sparkproject.dao.ITop10CategoryDAO;
import com.wang.sparkproject.domain.Top10Category;
import com.wang.sparkproject.jdbc.JDBCHelper;

/**
 * top10品类DAO接口实现
 * @author boyWang
 *
 */
public class Top10CategoryDAOImpl implements ITop10CategoryDAO{

	@Override
	public void insert(Top10Category category) {
		String sql = "insert into top10_category values(?,?,?,?,?)";
		
		Object[] params = new Object[] {category.getTaskid(),
				category.getCategoryId(),
				category.getClickCount(),
				category.getOrderCount(),
				category.getPayCount()};
		
		JDBCHelper jdbcHelper = JDBCHelper.getInstance();
		jdbcHelper.executeUpdate(sql, params);
	}

}
