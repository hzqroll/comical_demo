package com.roll.comical.console.business.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Date: 2017/8/27
 *
 * @author zongqiang.hao
 */
public class FastJson {
	/**
	 * 把json数据转换成类
	 *
	 * @param json
	 * @param clazz
	 * @param <T>
	 * @return
	 */
	public static <T> T fromJson(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}


	/**
	 * po类转换成json String
	 *
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
//String result = JSON.toJSONString(obj);
		String result = JSON.toJSONString(obj, SerializerFeature.WriteMapNullValue);
		return result;
	}
}

