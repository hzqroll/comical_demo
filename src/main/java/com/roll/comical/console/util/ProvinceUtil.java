package com.roll.comical.console.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author micah.shi
 */
public final class ProvinceUtil {

    private static final List<Integer> provinceIdList;

    private static final List<String> provinceNameList;

    private static final Map<Integer, String> provinceMap;

    static {
        provinceIdList = new ArrayList<>();
        provinceIdList.add(110000);
        provinceIdList.add(120000);
        provinceIdList.add(130000);
        provinceIdList.add(140000);
        provinceIdList.add(150000);
        provinceIdList.add(210000);
        provinceIdList.add(220000);
        provinceIdList.add(230000);
        provinceIdList.add(310000);
        provinceIdList.add(320000);
        provinceIdList.add(330000);
        provinceIdList.add(340000);
        provinceIdList.add(350000);
        provinceIdList.add(360000);
        provinceIdList.add(370000);
        provinceIdList.add(410000);
        provinceIdList.add(420000);
        provinceIdList.add(430000);
        provinceIdList.add(440000);
        provinceIdList.add(450000);
        provinceIdList.add(460000);
        provinceIdList.add(500000);
        provinceIdList.add(510000);
        provinceIdList.add(520000);
        provinceIdList.add(530000);
        provinceIdList.add(540000);
        provinceIdList.add(610000);
        provinceIdList.add(620000);
        provinceIdList.add(630000);
        provinceIdList.add(640000);
        provinceIdList.add(650000);
        provinceIdList.add(710000);
        provinceIdList.add(810000);
        provinceIdList.add(820000);
        provinceIdList.add(100000);

        provinceMap = new HashMap<>();

        provinceMap.put(110000, "北京");
        provinceMap.put(120000, "天津");
        provinceMap.put(130000, "河北");
        provinceMap.put(140000, "山西");
        provinceMap.put(150000, "内蒙古");
        provinceMap.put(210000, "辽宁");
        provinceMap.put(220000, "吉林");
        provinceMap.put(230000, "黑龙江");
        provinceMap.put(310000, "上海");
        provinceMap.put(320000, "江苏");
        provinceMap.put(330000, "浙江");
        provinceMap.put(340000, "安徽");
        provinceMap.put(350000, "福建");
        provinceMap.put(360000, "江西");
        provinceMap.put(370000, "山东");
        provinceMap.put(410000, "河南");
        provinceMap.put(420000, "湖北");
        provinceMap.put(430000, "湖南");
        provinceMap.put(440000, "广东");
        provinceMap.put(450000, "广西");
        provinceMap.put(460000, "海南");
        provinceMap.put(500000, "重庆");
        provinceMap.put(510000, "四川");
        provinceMap.put(520000, "贵州");
        provinceMap.put(530000, "云南");
        provinceMap.put(540000, "西藏");
        provinceMap.put(610000, "陕西");
        provinceMap.put(620000, "甘肃");
        provinceMap.put(630000, "青海");
        provinceMap.put(640000, "宁夏");
        provinceMap.put(650000, "新疆");
        provinceMap.put(710000, "台湾");
        provinceMap.put(810000, "香港");
        provinceMap.put(820000, "澳门");
        provinceMap.put(100000, "其他");

        provinceNameList =  new ArrayList<>();
        provinceNameList.add("北京");
        provinceNameList.add("天津");
        provinceNameList.add("河北");
        provinceNameList.add("山西");
        provinceNameList.add("内蒙古");
        provinceNameList.add("辽宁");
        provinceNameList.add("吉林");
        provinceNameList.add("黑龙江");
        provinceNameList.add("上海");
        provinceNameList.add("江苏");
        provinceNameList.add("浙江");
        provinceNameList.add("安徽");
        provinceNameList.add("福建");
        provinceNameList.add("江西");
        provinceNameList.add("山东");
        provinceNameList.add("河南");
        provinceNameList.add("湖北");
        provinceNameList.add("湖南");
        provinceNameList.add("广东");
        provinceNameList.add("广西");
        provinceNameList.add("海南");
        provinceNameList.add("重庆");
        provinceNameList.add("四川");
        provinceNameList.add("贵州");
        provinceNameList.add("云南");
        provinceNameList.add("西藏");
        provinceNameList.add("陕西");
        provinceNameList.add("甘肃");
        provinceNameList.add("青海");
        provinceNameList.add("宁夏");
        provinceNameList.add("新疆");
        provinceNameList.add("台湾");
        provinceNameList.add("香港");
        provinceNameList.add("澳门");
        provinceNameList.add("其他");
    }

    public static List<Integer> getIdList() {
        return provinceIdList;
    }

    public static Map<Integer, String> getMap() {
        return provinceMap;
    }

    public static List<String> getNameList() {
        return provinceNameList;
    }

    public static String getName(int provinceId) {
        return provinceIdList.contains(provinceId) ? provinceMap.get(provinceId) : provinceMap.get(100000);
    }
}
