package com.roll.comical.console.web.controller.stream;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.StreamSourcePlatformProvinceBuffering;
import com.roll.comical.console.business.stream.buffering.sourcePlatformProvince.service.StreamSourcePlatformProvinceBufferingService;
import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.StreamSourcePlatformProvinceFirstplay;
import com.roll.comical.console.business.stream.firstplay.sourcePlatformProvince.service.StreamSourcePlatformProvinceFirstplayService;
import com.roll.comical.console.util.DateUtil;
import com.roll.comical.console.util.PlatformUtil;
import com.roll.comical.console.util.ProvinceUtil;
import com.roll.comical.console.util.SourceUtil;

/**
 * @author zongqiang.hao
 */
@Controller
@RequestMapping("/daily/stream/province/info/direction")
public class StreamSourcePlatformProvinceDirectionController {

    @Autowired
    private StreamSourcePlatformProvinceBufferingService streamSourcePlatformProvinceBufferingService;

    @Autowired
    private StreamSourcePlatformProvinceFirstplayService streamSourcePlatformProvinceFirstplayService;

    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @RequestMapping
    public String info(Model model,
                       @RequestParam(value = "date", required = false, defaultValue = "") String date,
                       @RequestParam(value = "sourceId", required = false, defaultValue = "3") int sourceId,
                       @RequestParam(value = "platformId", required = false, defaultValue = "1") int platformId) {
        model.addAttribute("sourceId", sourceId);
        model.addAttribute("platformId", platformId);
        //当前时间赋值
        if ("".equals(date) || date == null) {
            //上一天
            date = DateUtil.getYesterday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        model.addAttribute("date", date);
        model.addAttribute("provinceNameList", ProvinceUtil.getNameList());

        //cnd列表
        List<Integer> sourceIdAllList = new ArrayList<>(SourceUtil.getIdList());
        Map<Integer, String> sourceAllMap = new HashMap<>(SourceUtil.getMap());
        //平台列表
        List<Integer> platformIdAllList = new ArrayList<>(PlatformUtil.getIdList());
        Map<Integer, String> platformNameAllMap = new HashMap<>(PlatformUtil.getMap());

        List<Integer> provinceIdList = new ArrayList<>();

        //平台信息
        List<StreamSourcePlatformProvinceBuffering> sourcePlatformProvinceBufferingList = streamSourcePlatformProvinceBufferingService.getProvinceList(sourceId, platformId, date);

        List<StreamSourcePlatformProvinceBuffering> allBufferingList = streamSourcePlatformProvinceBufferingService.getAllList(date);

        for (StreamSourcePlatformProvinceBuffering buffering : allBufferingList) {
            if (!provinceIdList.contains(buffering.getProvinceId())) {
                provinceIdList.add(buffering.getProvinceId());
            }
            if (!sourceIdAllList.contains(buffering.getSourceId())) {
                sourceIdAllList.add(buffering.getSourceId());
                sourceAllMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
            }
            if (!platformIdAllList.contains(buffering.getPlatformId())) {
                platformIdAllList.add(buffering.getPlatformId());
                platformNameAllMap.put(buffering.getPlatformId(), PlatformUtil.getName(buffering.getPlatformId()));
            }
            if (!provinceIdList.contains(buffering.getProvinceId())) {
                provinceIdList.add(buffering.getProvinceId());
            }
        }

        Map<String, Long> provinceBufferingMap = new HashMap<>();
        for (StreamSourcePlatformProvinceBuffering buffering : sourcePlatformProvinceBufferingList) {
            provinceBufferingMap.put("bufferCount_" + buffering.getProvinceId(), buffering.getBufferingCount());
            provinceBufferingMap.put("fluencyCount_" + buffering.getProvinceId(), buffering.getFluencyCount());
        }

        Map<String, String> platformSourceBufferingListMap = new HashMap<>();
        for (Integer provinceId : ProvinceUtil.getIdList()) {
            long bufferCount = provinceBufferingMap.getOrDefault("bufferCount_" + provinceId, 0L);
            long fluencyCount = provinceBufferingMap.getOrDefault("fluencyCount_" + provinceId, 0L);
            double bufferRate = 0.0;
            if (fluencyCount > 0) {
                bufferRate = bufferCount * 100.0 / fluencyCount;
            }
            platformSourceBufferingListMap.put(ProvinceUtil.getName(provinceId), decimalFormat.format(bufferRate));
        }

        model.addAttribute("platformSourceBufferingListMap", platformSourceBufferingListMap);

        //首屏时间
        List<StreamSourcePlatformProvinceFirstplay> sourcePlatformProvinceFirstplayList = streamSourcePlatformProvinceFirstplayService.getProvinceList(sourceId, platformId, date);

        List<StreamSourcePlatformProvinceFirstplay> allFirstplayList = streamSourcePlatformProvinceFirstplayService.getAllList(date);

        for (StreamSourcePlatformProvinceFirstplay buffering : allFirstplayList) {
            if (!provinceIdList.contains(buffering.getProvinceId())) {
                provinceIdList.add(buffering.getProvinceId());
            }
            if (!sourceIdAllList.contains(buffering.getSourceId())) {
                sourceIdAllList.add(buffering.getSourceId());
                sourceAllMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
            }
            if (!platformIdAllList.contains(buffering.getPlatformId())) {
                platformIdAllList.add(buffering.getPlatformId());
                platformNameAllMap.put(buffering.getPlatformId(), PlatformUtil.getName(buffering.getPlatformId()));
            }
            if (!provinceIdList.contains(buffering.getProvinceId())) {
                provinceIdList.add(buffering.getProvinceId());
            }
        }

        Map<String, Long> provinceFirstplayMap = new HashMap<>();
        for (StreamSourcePlatformProvinceFirstplay buffering : sourcePlatformProvinceFirstplayList) {
            provinceFirstplayMap.put("bufferTime_" + buffering.getProvinceId(), buffering.getBufferTime());
            provinceFirstplayMap.put("bufferTimeCount_" + buffering.getProvinceId(), buffering.getBufferTimeCount());
        }
        Map<String, String> platformSourceFirstplayListMap = new HashMap<>();
        for (Integer provinceId : ProvinceUtil.getIdList()) {
            long bufferTime = provinceFirstplayMap.getOrDefault("bufferTime_" + provinceId, 0L);
            long bufferTimeCount = provinceFirstplayMap.getOrDefault("bufferTimeCount_" + provinceId, 0L);
            double bufferRate = 0.0;
            if (bufferTimeCount > 0) {
                bufferRate = bufferTime * 1.0 / bufferTimeCount / 1000;
            }
            platformSourceFirstplayListMap.put(ProvinceUtil.getName(provinceId), decimalFormat.format(bufferRate));
        }

        model.addAttribute("platformSourceFirstplayListMap", platformSourceFirstplayListMap);

        //平台id+名称
        model.addAttribute("platformNameAllMap", platformNameAllMap);
        model.addAttribute("platformIdAllList", platformIdAllList);
        // cdn列表信息
        model.addAttribute("sourceIdAllList", sourceIdAllList);
        model.addAttribute("sourceAllMap", sourceAllMap);

        return "daily/stream/province/info/direction";
    }
}
