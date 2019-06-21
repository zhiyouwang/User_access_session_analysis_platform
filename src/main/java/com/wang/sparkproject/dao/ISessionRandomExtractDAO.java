package com.wang.sparkproject.dao;

import com.wang.sparkproject.domain.SessionRandomExtract;

/**
 * session随机抽取模块DAO接口
 * @author boyWang
 *
 */
public interface ISessionRandomExtractDAO {

	/**
	 * 插入session随机抽取
	 * @param sessionAggrStat
	 */
	void insert(SessionRandomExtract sessionRandomExtract);
}
