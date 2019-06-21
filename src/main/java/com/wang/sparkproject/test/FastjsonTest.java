package com.wang.sparkproject.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * fastjson测试类
 * @author boyWang
 *
 */
public class FastjsonTest {

	public static void main(String[] args) {
		String json = "[{'学生':'张三'},{'学生':'李四'}]";
		
		JSONArray jsonArray = JSONArray.parseArray(json);
		JSONObject jsonObject = jsonArray.getJSONObject(0);
		System.out.println(jsonObject.getString("学生"));
	}
}
