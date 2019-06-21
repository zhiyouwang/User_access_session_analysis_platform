package com.wang.sparkproject.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC增删改查
 * 
 * @author boyWang
 * 
 */
@SuppressWarnings("unused")
public class JdbcCRUD {

	public static void main(String[] args) {
		// insert();
		// update();
		// delete();
		//select();
	}

	/**
	 * 数据库插入操作
	 */
	@SuppressWarnings("unused")
	private static void insert() {
		// TODO Auto-generated method stub
		// 定义数据库连接对象
		Connection conn = null;

		// 定义SQL语句执行句柄：Statement对象
		Statement stmt = null;

		try {
			// 第一步，加载数据库的驱动，我们都是面向java.sql包下的接口在编程，所以要想让JDBC代码能够真正操作数据库，那么就必须第一步先加载进来你要操作的数据库的驱动类
			// 使用Class.forName（）方式来加载数据库的驱动类，Class.forName（）是Java提供的一种基于反射的方式，直接根据类的全限定名（包+类）从类所在的磁盘文件
			// （.class）中加载类对应的内容，并创建对应的Class对象
			Class.forName("com.mysql.jdbc.Driver");

			// 获取数据库的连接
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sparkproject?useUnicode=true&characterEncoding=utf8", "root",
					"123456");

			// 基于数据库连接Connection对象，创建SQL语句执行句柄，Statement对象
			// Statement对象，就是用来基于底层的Connection代表的数据库连接，允许我们通过Java程序，通过Statement对象，向MySQL数据库发送SQL语句
			// 从而实现通过发送的SQL语句来执行增删改查等逻辑
			stmt = conn.createStatement();

			// 然后就可以基于Statement对象，来执行SQL语句了
			// Statement.executeUpdate()方法，返回值是一个int值，也就是SQL语句影响的行数
			String sql = "insert into test_user(name,age) values('张三',25)";
			int rtn = stmt.executeUpdate(sql);

			System.out.println(rtn + "行");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// 释放数据库连接
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 数据库更新操作
	 */
	private static void update() {

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sparkproject?useUnicode=true&characterEncoding=utf8", "root",
					"123456");

			stmt = conn.createStatement();
			String sql = "update test_user set age=24 where name='张三'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 数据库删除操作
	 */
	private static void delete() {

		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sparkproject?useUnicode=true&characterEncoding=utf8", "root",
					"123456");

			stmt = conn.createStatement();
			String sql = "delete from test_user where age='25'";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}

	/**
	 * 数据库查找操作
	 */
	private static void select() {
		Connection conn = null;
		Statement stmt = null;

		// 对于select查询语句，需要定义ResultSet
		// ResultSet就代表了，select语句查询出来的数据，来遍历查询出来的每一行数据
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sparkproject?useUnicode=true&characterEncoding=utf8", "root",
					"123456");

			stmt = conn.createStatement();

			String sql = "select * from test_user";
			rs = stmt.executeQuery(sql);

			// 获取到ResultSet以后，就需要对其进行遍历，然后获取查询出来的每一条数据
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt(3);
				System.out.println(id + "," + name + "," + age);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
