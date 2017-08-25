package com.roll.comical.console.business.ask;

/**
 * User: roll
 * Date: 2017/2/4
 * Time: 下午3:28
 *
 * @author zongqiang.hao
 *         中毒问题
 */
public class Solution {
	private static int findPosisonedDuration(int[] timeSeries, int duration) {
		if (timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
		int result = 0, start = timeSeries[0], end = timeSeries[0] + duration;
		for (int i = 1; i < timeSeries.length; i++) {
			if (timeSeries[i] > end) {
				result += end - start;
				start = timeSeries[i];
			}
			end = timeSeries[i] + duration;
		}
		result += end - start;

		return result;
	}

	public int findPosisonedDuration2(int[] timeSeries, int duration) {

		int total_poisoned_time = 0,
				next_start_time = 0;

		for(int i=0;i<timeSeries.length;++i)
		{
			if(timeSeries[i] == 0 || timeSeries[i] - next_start_time > 0)
			{
				next_start_time = timeSeries[i] + duration - 1;
				total_poisoned_time += duration;
			}
			else
			{
				total_poisoned_time += (timeSeries[i] + duration - 1) - next_start_time; // since overlapping happens , we calculate the offset before judging next start time for poisoning state
				next_start_time = timeSeries[i] + duration - 1;
			}
		}

		return total_poisoned_time;
	}

	public static void main(String args[]) {
		int[] a = {1, 2, 3, 4, 5, 6, 10};
		System.out.println(findPosisonedDuration(a, 2));
	}
}
