package com.roll.comical.console.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author micah.shi
 */
public final class SourceUtil {

	private static final List<Integer> sourceIdList;

	private static final Map<Integer, String> sourceMap;

	private static final Map<Integer, String> sourceIdMap;


	static {
		sourceIdList = new ArrayList<>();
		sourceIdList.add(3);
		sourceIdList.add(36);
		sourceIdList.add(103);
		sourceIdList.add(6);
		sourceIdList.add(61);
		sourceIdList.add(106);
		sourceIdList.add(8);

		sourceMap = new HashMap<>();
		sourceMap.put(3, "网宿");
		sourceMap.put(36, "网宿互推");
		sourceMap.put(103, "网宿全民");
		sourceMap.put(6, "星域");
		sourceMap.put(61, "星域互推");
		sourceMap.put(106, "星域全名");
		sourceMap.put(8, "UCloud");

		sourceIdMap = new HashMap<>();
		sourceIdMap.put(3, 3+":"+"网宿");
		sourceIdMap.put(6, 6+":"+"星域");
		sourceIdMap.put(8, 8+":"+"UCloud");
		sourceIdMap.put(36, 36+":"+"网宿互推");
		sourceIdMap.put(103, 103+":"+"网宿全民");
		sourceIdMap.put(61, 61+":"+"星域互推");
		sourceIdMap.put(106, 106+":"+"星域全名");

	}

	public static List<Integer> getIdList() {
		return sourceIdList;
	}

	public static Map<Integer, String> getMap() {
		return sourceMap;
	}

	public static Map<Integer, String> getIdMap() {
		return sourceIdMap;
	}

	public static String getName(int sourceId) {
		return sourceIdList.contains(sourceId) ? sourceMap.get(sourceId) : "未知-" + sourceId;
	}
}
