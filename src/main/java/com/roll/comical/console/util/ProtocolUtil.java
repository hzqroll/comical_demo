package com.roll.comical.console.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author micah.shi
 */
public final class ProtocolUtil {


	private static final List<Integer> protocolIdList;

	private static final Map<Integer, String> protocolMap;

	static {

		protocolIdList = new ArrayList<>();
		protocolIdList.add(1);
		protocolIdList.add(2);
		protocolIdList.add(3);

		protocolMap = new HashMap<>();
		protocolMap.put(1, "RTMP");
		protocolMap.put(2, "HDL");
		protocolMap.put(3, "HLS");

	}

	public static List<Integer> getIdList() {
		return protocolIdList;
	}

	public static Map<Integer, String> getMap() {
		return protocolMap;
	}

	public static String getName(int protocolId) {
		return protocolIdList.contains(protocolId) ? protocolMap.get(protocolId) : "未知-" + protocolId;
	}
}
