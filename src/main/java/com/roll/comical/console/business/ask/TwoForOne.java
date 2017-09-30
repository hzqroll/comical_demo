package com.roll.comical.console.business.ask;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2017/9/9
 *
 * @author zongqiang.hao
 */
public class TwoForOne {
	public static void main(String args[]) throws Exception {

		int[] array = new int[]{1, 2, 3, 4, 5};
		System.out.println(Power(5.0, -3));
	}

	public int NumberOf1(int n) {
		int count = 0;
		int b = 1;
		while (b != 0) {
			if ((n & b) != 0) {
				count++;
			}
			b = b << 1;
		}
		return count;
	}

	public static double Power(double base, int exponent) throws Exception {
		//base的exponent次方
		double result = 1.0;
		if (exponent == 0) {
			return 1;
		} else if (exponent >= 0) {
			for (int i = 0; i < exponent; i++) {
				result *= base;
			}
		} else {
			if (base == 0) {
				return 0;
			}
			for (int i = 0; i < -exponent; i++) {
				result *= base;
			}
		}

		return exponent > 0 ? result : (1 / result);
	}

	/**
	 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
	 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 *
	 * @param array 传入数组
	 */
	public void reOrderArray(int[] array) {
		List<Integer> newarray = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				array[i] = array[i+1];
			}
		}
	}
}
