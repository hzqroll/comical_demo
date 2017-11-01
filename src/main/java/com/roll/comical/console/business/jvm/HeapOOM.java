package com.roll.comical.console.business.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/11/1
 *
 * @author zongqiang.hao
 */
public class HeapOOM {
	static class OOMObject {
	}

	public static void main(String[] args) {
		List<OOMObject> lists = new ArrayList<>();
		while (true) {
			lists.add(new OOMObject());
		}
	}
}
