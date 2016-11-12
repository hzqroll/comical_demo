package com.roll.comical.console.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zongqiang.hao
 */
public class PlatformUtil {

    private static final List<Integer> platformIdList;

    private static final Map<Integer, String> platformMap;

    private static final List<Integer> platformIdPartList;

    private static final Map<Integer, String> platformPartMap;

    static {
        platformIdList = new ArrayList<>();

        platformIdList.add(1);
        platformIdList.add(2);
        platformIdList.add(3);
        platformIdList.add(4);
        platformIdList.add(5);
        platformIdList.add(6);
        platformIdList.add(7);
        platformIdList.add(8);
        platformIdList.add(0);

        platformMap = new HashMap<>();

        platformMap.put(1, "安卓TV客户端");
        platformMap.put(2, "苹果TV客户端");
        platformMap.put(3, "PC客户端");
        platformMap.put(4, "安卓触手录客户端");
        platformMap.put(5, "苹果触手录客户端");
        platformMap.put(6, "安卓TV录制客户端");
        platformMap.put(7, "苹果TV录制客户端");
        platformMap.put(8, "第三方合作H5");
        platformMap.put(0, "未知客户端");

        platformIdPartList = new ArrayList<>();

        platformIdPartList.add(1);
        platformIdPartList.add(2);
        platformIdPartList.add(3);
        platformIdPartList.add(0);

        platformPartMap = new HashMap<>();

        platformPartMap.put(1, "安卓TV客户端");
        platformPartMap.put(2, "苹果TV客户端");
        platformPartMap.put(3, "PC客户端");
        platformPartMap.put(0, "未知客户端");
    }

    public static List<Integer> getIdList() {
        return platformIdList;
    }

    public static Map<Integer, String> getMap() {
        return platformMap;
    }

    public static List<Integer> getPartIdList() {
        return platformIdPartList;
    }

    public static Map<Integer, String> getPartMap() {
        return platformPartMap;
    }

    public static String getName(int platformId) {
        return platformIdList.contains(platformId) ? platformMap.get(platformId) : "未知-" + platformId;
    }
}
