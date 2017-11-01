package com.roll.comical.console.business.json;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeWriter;
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

	public static void main(String[] args) {
		JsonPOJO jsonPOJO = new JsonPOJO();
		jsonPOJO.setId(1);
		SerializeWriter out = new SerializeWriter();
		//Write Obj to File
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
			oos.writeObject(jsonPOJO);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//IOUtils.closeQuietly(oos);
		}

		//Read Obj from File
		File file = new File("tempFile");
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			JsonPOJO newUser = (JsonPOJO) ois.readObject();
			System.out.println(newUser);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {

		}
	}
}

