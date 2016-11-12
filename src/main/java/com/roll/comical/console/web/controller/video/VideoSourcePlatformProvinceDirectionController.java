package com.roll.comical.console.web.controller.video;

import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.VideoSourcePlatformProvinceBuffering;
import com.roll.comical.console.business.video.buffering.sourcePlatformProvince.dao.VideoStreamSourcePlatformProvinceBufferingDao;
import com.roll.comical.console.util.DateUtil;
import com.roll.comical.console.util.PlatformUtil;
import com.roll.comical.console.util.ProvinceUtil;
import com.roll.comical.console.util.SourceUtil;

/**
 * @author zongqiang.hao
 */
@Controller
@RequestMapping("/daily/video/province/info/direction")
public class VideoSourcePlatformProvinceDirectionController {

    @Autowired
    private VideoStreamSourcePlatformProvinceBufferingDao videoStreamSourcePlatformProvinceBufferingDao;

    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @RequestMapping
    public String info(Model model,
                       @RequestParam(value = "date", required = false, defaultValue = "") String date,
                       @RequestParam(value = "sourceId", required = false, defaultValue = "6") int sourceId,
                       @RequestParam(value = "platformId", required = false, defaultValue = "1") int platformId) {
        model.addAttribute("sourceId", sourceId);
        model.addAttribute("platformId", platformId);
        if ("".equals(date) || date == null) {
            //上一天
            date = DateUtil.getYesterday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }
        model.addAttribute("date", date);
        // 选择列表信息
        model.addAttribute("provinceNameList", ProvinceUtil.getNameList());

        //cnd列表
        List<Integer> sourceIdAllList = new ArrayList<>(SourceUtil.getIdList());
        Map<Integer, String> sourceAllMap = new HashMap<>(SourceUtil.getMap());
        //平台列表
        List<Integer> platformIdAllList = new ArrayList<>(PlatformUtil.getIdList());
        Map<Integer, String> platformNameAllMap = new HashMap<>(PlatformUtil.getMap());

        List<Integer> provinceIdList = new ArrayList<>();

        //平台信息
        List<VideoSourcePlatformProvinceBuffering> sourcePlatformProvinceBufferingList = videoStreamSourcePlatformProvinceBufferingDao.getProvinceList(sourceId, platformId, date);

        List<VideoSourcePlatformProvinceBuffering> allBufferingList = videoStreamSourcePlatformProvinceBufferingDao.getAllList(date);

        for (VideoSourcePlatformProvinceBuffering buffering : allBufferingList) {
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
        }
        //平台id+名称
        model.addAttribute("platformNameAllMap", platformNameAllMap);
        model.addAttribute("platformIdAllList", platformIdAllList);
        // cdn列表信息
        model.addAttribute("sourceIdAllList", sourceIdAllList);
        model.addAttribute("sourceAllMap", sourceAllMap);

        Map<String, Long> provinceBufferingMap = new HashMap<>();
        for (VideoSourcePlatformProvinceBuffering buffering : sourcePlatformProvinceBufferingList) {
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

        return "daily/video/province/info/direction";
    }
}
