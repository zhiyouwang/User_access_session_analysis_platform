package com.wang.sparkproject.test;

import com.wang.sparkproject.conf.ConfigurationManager;

/**
 * 配置管理组件测试类
 * @author boyWang
 *
 */
public class ConfigurationManagerTest {

	public static void main(String[] args) {
		String testkey1 = ConfigurationManager.getProperties("testkey1");
		String testkey2 = ConfigurationManager.getProperties("testkey2");
		System.out.println(testkey1);
		System.out.println(testkey2);
	}
}
