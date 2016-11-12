package com.roll.comical.console.web.controller.stream;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roll.comical.console.business.stream.buffering.platformsource.PlatformSourceBuffering;
import com.roll.comical.console.business.stream.buffering.platformsource.service.StreamPlatformSourceBufferingService;
import com.roll.comical.console.business.stream.firstplay.platformsource.PlatformSourceFirstplay;
import com.roll.comical.console.business.stream.firstplay.platformsource.service.StreamPlatformSourceFirstplayService;
import com.roll.comical.console.util.*;

/**
 * @author zongqiang.hao
 */
@Controller
@RequestMapping("/daily/stream/platform/source/info/direction")
public class StreamPlatformSourceDirectionController {
    @Autowired
    private StreamPlatformSourceBufferingService streamPlatformSourceBufferingService;
    @Autowired
    private StreamPlatformSourceFirstplayService streamPlatformSourceFirstplayService;
    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");


    @RequestMapping
    public String info(Model model,
                       @RequestParam(value = "day", required = false, defaultValue = "7") int day,
                       @RequestParam(value = "platformId", required = false, defaultValue = "1") int platformId) {
        model.addAttribute("day", day);
        model.addAttribute("platformId", platformId);
        // 平台明细信息
        model.addAttribute("platformIdList", PlatformUtil.getPartIdList());
        model.addAttribute("platformMap", PlatformUtil.getPartMap());

        Date startDate = DateConvertUtil.asDate(LocalDate.now().minusDays(day));
        Date endDate = DateConvertUtil.asDate(LocalDate.now().minusDays(1));


        //平台cdn信息
        List<PlatformSourceBuffering> platformSourceBufferingList = streamPlatformSourceBufferingService.getList(platformId, startDate, endDate);

        List<Integer> platformSourceIdList = new ArrayList<>();
        Map<Integer, String> platformSourceNameMap = new HashMap<>();
        List<Integer> showPlatformSourceBufferingIdList = new ArrayList<Integer>() {{
            add(3);
            add(6);
            add(8);
        }};
        Map<Integer, Boolean> platformSourceBufferingNameMaps = new HashMap<>();

        // CDN信息
        for (PlatformSourceBuffering buffering : platformSourceBufferingList) {
            if (!platformSourceIdList.contains(buffering.getSourceId())) {
                platformSourceIdList.add(buffering.getSourceId());
                platformSourceNameMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
                platformSourceBufferingNameMaps.put(buffering.getSourceId(), showPlatformSourceBufferingIdList.contains(buffering.getSourceId()) ? true : false);
            }
        }

        Collections.sort(platformSourceIdList);
        if (platformSourceIdList.contains(0)) {
            platformSourceIdList.remove(0);
            Collections.sort(platformSourceIdList);
            platformSourceIdList.add(0);
        } else {
            Collections.sort(platformSourceIdList);
        }

        model.addAttribute("platformSourceIdList", platformSourceIdList);
        model.addAttribute("platformSourceNameMap", platformSourceNameMap);
        model.addAttribute("platformSourceBufferingNameMaps", platformSourceBufferingNameMaps);

        List<Date> platformDateList = DateUtil.getTimeGapDayList(startDate, endDate);

        // 时间列表
        List<String> platformDateFormatList = new ArrayList<>();

        Map<Date, Map<String, Long>> platformDateSourceMap = new HashMap<>();
        for (Date date : platformDateList) {
            platformDateFormatList.add(DateStringUtil.format(date));
        }
        model.addAttribute("platformDateFormatList", platformDateFormatList);

        for (Date date : platformDateList) {
            Map<String, Long> sourceMap = new HashMap<>();
            for (PlatformSourceBuffering buffering : platformSourceBufferingList) {
                if (date.getTime() == buffering.getDate().getTime()) {
                    sourceMap.put("bufferCount_" + buffering.getSourceId(), buffering.getBufferingCount());
                    sourceMap.put("fluencyCount_" + buffering.getSourceId(), buffering.getFluencyCount());
                }
            }
            platformDateSourceMap.put(date, sourceMap);
        }

        Map<Integer, List<String>> platformSourceBufferingListMap = new HashMap<>();
        for (Integer sourceId : platformSourceIdList) {
            List<String> sourceBufferingList = new ArrayList<>();
            for (Date date : platformDateList) {
                Map<String, Long> sourceMap = platformDateSourceMap.get(date);
                long bufferCount = sourceMap.getOrDefault("bufferCount_" + sourceId, 0L);
                long fluencyCount = sourceMap.getOrDefault("fluencyCount_" + sourceId, 0L);
                double bufferRate = 0.0;
                if (fluencyCount > 0) {
                    bufferRate = bufferCount * 100.0 / fluencyCount;
                }
                sourceBufferingList.add(decimalFormat.format(bufferRate));
            }
            platformSourceBufferingListMap.put(sourceId, sourceBufferingList);
        }

        platformSourceBufferingListMap.put(100, new ArrayList<>());

        model.addAttribute("platformSourceBufferingListMap", platformSourceBufferingListMap);


        //平台cdn信息
        List<PlatformSourceFirstplay> platformSourceFirstplayList = streamPlatformSourceFirstplayService.getList(platformId, startDate, endDate);

        List<Integer> platformSourceFirstplayIdList = new ArrayList<>();
        List<Integer> showPlatformSourceFirstplayIdList = new ArrayList<Integer>() {{
            add(3);
            add(6);
            add(8);
        }};
        Map<Integer, String> platformSourceFirstplayNameMap = new HashMap<>();
        Map<Integer, Boolean> platformSourceFirstplayNameMaps = new HashMap<>();

        // CDN信息
        for (PlatformSourceFirstplay buffering : platformSourceFirstplayList) {
            Map<String, Boolean> SourecNameMap = new HashMap<>();
            if (!platformSourceFirstplayIdList.contains(buffering.getSourceId())) {
                platformSourceFirstplayIdList.add(buffering.getSourceId());
                platformSourceFirstplayNameMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
                platformSourceFirstplayNameMaps.put(buffering.getSourceId(), showPlatformSourceFirstplayIdList.contains(buffering.getSourceId()) ? true : false);
            }
        }

        Collections.sort(platformSourceFirstplayIdList);
        if (platformSourceFirstplayIdList.contains(0)) {
            platformSourceFirstplayIdList.remove(0);
            Collections.sort(platformSourceFirstplayIdList);
            platformSourceFirstplayIdList.add(0);
        } else {
            Collections.sort(platformSourceFirstplayIdList);
        }

        model.addAttribute("platformSourceFirstplayIdList", platformSourceFirstplayIdList);
        model.addAttribute("platformSourceFirstplayNameMap", platformSourceFirstplayNameMap);
        model.addAttribute("platformSourceFirstplayNameMaps", platformSourceFirstplayNameMaps);

        List<Date> platformFirstplayDateList = DateUtil.getTimeGapDayList(startDate, endDate);

        // 时间列表
        List<String> platformFirstplayDateFormatList = new ArrayList<>();

        Map<Date, Map<String, Long>> platformFirstplayDateSourceMap = new HashMap<>();
        for (Date date : platformFirstplayDateList) {
            platformFirstplayDateFormatList.add(DateStringUtil.format(date));
        }
        model.addAttribute("platformFirstplayDateFormatList", platformFirstplayDateFormatList);

        for (Date date : platformFirstplayDateList) {
            Map<String, Long> sourceMap = new HashMap<>();
            for (PlatformSourceFirstplay buffering : platformSourceFirstplayList) {
                if (date.getTime() == buffering.getDate().getTime()) {
                    sourceMap.put("bufferTime_" + buffering.getSourceId(), buffering.getBufferTime());
                    sourceMap.put("bufferTimeCount_" + buffering.getSourceId(), buffering.getBufferTimeCount());
                }
            }
            platformFirstplayDateSourceMap.put(date, sourceMap);
        }

        Map<Integer, List<String>> platformSourceFirstplayListMap = new HashMap<>();
        for (Integer sourceId : platformSourceFirstplayIdList) {
            List<String> sourceFirstplayList = new ArrayList<>();
            for (Date date : platformFirstplayDateList) {
                Map<String, Long> sourceMap = platformFirstplayDateSourceMap.get(date);
                long bufferTime = sourceMap.getOrDefault("bufferTime_" + sourceId, 0L);
                long bufferTimeCount = sourceMap.getOrDefault("bufferTimeCount_" + sourceId, 0L);
                double bufferRate = 0.0;
                if (bufferTimeCount > 0) {
                    bufferRate = bufferTime * 1.0 / bufferTimeCount / 1000;
                }
                sourceFirstplayList.add(decimalFormat.format(bufferRate));
            }
            platformSourceFirstplayListMap.put(sourceId, sourceFirstplayList);
        }

        model.addAttribute("platformSourceFirstplayListMap", platformSourceFirstplayListMap);

        return "daily/stream/platform/source/info/direction";

    }
}
