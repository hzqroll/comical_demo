package com.roll.comical.console.business.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User: roll
 * Date: 2017/2/7
 * Time: 上午10:54
 *
 * @author zongqiang.hao
 */
public class TestListSearch {
	public int search(){
		List<Integer> list = new ArrayList<Integer>(){{add(1);add(2);add(10);add(5);}};
		Integer a = Collections.binarySearch(list,new Integer(12));
		return 1;
	}
}
