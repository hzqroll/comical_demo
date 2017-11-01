package com.roll.comical.console.business.ask;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午3:28
 *
 * @author zongqiang.hao
 * 中毒问题
 */
public class Solution {
	public static void main(String args[]) {
		int[] a = {1, 2, 3, 4, 5, 6, 10};
		System.out.println(1);
	}

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 *
	 * @param array
	 */
	private static void reOrderArray(int[] array) {
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		int length = array.length;

		for (int i = 0; i < length; i++) {
			if (array[i] % 2 == 0) {
				even.add(i);
				ArrayUtils.remove(array, i);
			}
			if (i % 2 != 0) {
				odd.add(i);
				ArrayUtils.remove(array, i);
			}
		}
		int[] nullArray = {};
		array = nullArray;

		for (int i = 0; i < length; i++) {
			array[i] =1;
		}
	}
}
