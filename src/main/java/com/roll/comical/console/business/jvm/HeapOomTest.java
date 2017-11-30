package com.roll.comical.console.business.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/11/8
 *
 * @author zongqiang.hao
 */
public class HeapOomTest {
	private static class OobObject{

	}
	public static void main(String[] args){
		List<OobObject> objectList = new ArrayList<>();
		while(true){
			objectList.add(new OobObject());
		}
	}
}
