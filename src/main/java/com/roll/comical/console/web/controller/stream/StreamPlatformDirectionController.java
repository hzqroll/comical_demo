package com.roll.comical.console.web.controller.stream;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roll.comical.console.business.stream.buffering.platform.PlatformBuffering;
import com.roll.comical.console.business.stream.buffering.platform.PlatformFirstplay;
import com.roll.comical.console.business.stream.buffering.platform.service.StreamPlatformService;
import com.roll.comical.console.util.DateConvertUtil;
import com.roll.comical.console.util.DateStringUtil;
import com.roll.comical.console.util.DateUtil;
import com.roll.comical.console.util.PlatformUtil;
import com.roll.comical.console.web.controller.AbstractController;

/**
 * @author zongqiang.hao
 */

@Controller
@RequestMapping("/daily/stream/platform/info/direction")
public class StreamPlatformDirectionController extends AbstractController {
    @Autowired
    StreamPlatformService streamPlatformService;

    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @RequestMapping
    public String info(Model model,
                       @RequestParam(value = "day", required = false, defaultValue = "7") int day) {

        Date startDate = DateConvertUtil.asDate(LocalDate.now().minusDays(day));
        Date endDate = DateConvertUtil.asDate(LocalDate.now().minusDays(1));

        /**
         * 平台卡顿数据
         */
        List<PlatformBuffering> streamBufferingList = streamPlatformService.getList(startDate, endDate);


        model.addAttribute("day", day);

        List<Integer> streamPlatformBufferingList = new ArrayList<>();
        Map<Integer, String> streamPlatformBufferingMap = new HashMap<>();

        //platformId->具体名称
        for (PlatformBuffering buffering : streamBufferingList) {
            if (!streamPlatformBufferingList.contains(buffering.getPlatformId())) {
                streamPlatformBufferingList.add(buffering.getPlatformId());
                streamPlatformBufferingMap.put(buffering.getPlatformId(), PlatformUtil.getName(buffering.getPlatformId()));
            }
        }

        //平台列表
        Collections.sort(streamPlatformBufferingList);
        if (streamPlatformBufferingList.contains(0)) {
            streamPlatformBufferingList.remove(0);
            Collections.sort(streamPlatformBufferingList);
            streamPlatformBufferingList.add(0);
        } else {
            Collections.sort(streamPlatformBufferingList);
        }
        model.addAttribute("streamPlatformBufferingList", streamPlatformBufferingList);
        //平台id+名称

        model.addAttribute("streamPlatformBufferingMap", streamPlatformBufferingMap);

        List<Date> streamBufferingDateList = DateUtil.getTimeGapDayList(startDate, endDate);

        //时间信息
        List<String> streamBufferingDateFormatList = new ArrayList<>();

        Map<Date, Map<String, Long>> streamPlatformBufferingDateMap = new HashMap<>();
        for (Date date : streamBufferingDateList) {
            streamBufferingDateFormatList.add(DateStringUtil.format(date));
        }
        model.addAttribute("streamBufferingDateFormatList", streamBufferingDateFormatList);

        for (Date date : streamBufferingDateList) {
            Map<String, Long> platformMap = new HashMap<>();
            for (PlatformBuffering platformBuffering : streamBufferingList) {
                if (date.getTime() == platformBuffering.getDate().getTime()) {
                    platformMap.put("bufferCount_" + platformBuffering.getPlatformId(), platformBuffering.getBufferingCount());
                    platformMap.put("fluencyCount_" + platformBuffering.getPlatformId(), platformBuffering.getFluencyCount());
                }
            }
            streamPlatformBufferingDateMap.put(date, platformMap);
        }

        Map<Integer, List<String>> streamPlatformBufferingListMap = new HashMap<>();
        for (Integer platformId : streamPlatformBufferingList) {
            List<String> platformBufferingList = new ArrayList<>();
            for (Date date : streamBufferingDateList) {
                Map<String, Long> sourceMap = streamPlatformBufferingDateMap.get(date);
                long bufferCount = sourceMap.getOrDefault("bufferCount_" + platformId, 0L);
                long fluencyCount = sourceMap.getOrDefault("fluencyCount_" + platformId, 0L);
                double bufferRate = 0.0;
                if (fluencyCount > 0) {
                    bufferRate = bufferCount * 100.0 / fluencyCount;
                }
                platformBufferingList.add(decimalFormat.format(bufferRate));
            }
            streamPlatformBufferingListMap.put(platformId, platformBufferingList);
        }

        model.addAttribute("streamPlatformBufferingListMap", streamPlatformBufferingListMap);

        /**
         * 平台首屏数据
         */
        List<PlatformFirstplay> streamFirstplayList = streamPlatformService.getFirstplay(startDate, endDate);


        model.addAttribute("day", day);

        List<Integer> streamPlatformFirstplayList = new ArrayList<>();
        Map<Integer, String> streamPlatformFirstplayMap = new HashMap<>();

        //platformId->具体名称
        for (PlatformFirstplay firstplay : streamFirstplayList) {
            if (!streamPlatformFirstplayList.contains(firstplay.getPlatformId())) {
                streamPlatformFirstplayList.add(firstplay.getPlatformId());
                streamPlatformFirstplayMap.put(firstplay.getPlatformId(), PlatformUtil.getName(firstplay.getPlatformId()));
            }
        }

        //平台列表
        Collections.sort(streamPlatformFirstplayList);
        if (streamPlatformFirstplayList.contains(0)) {
            streamPlatformFirstplayList.remove(0);
            Collections.sort(streamPlatformFirstplayList);
            streamPlatformFirstplayList.add(0);
        } else {
            Collections.sort(streamPlatformFirstplayList);
        }
        model.addAttribute("streamPlatformFirstplayList", streamPlatformFirstplayList);
        //平台id+名称

        model.addAttribute("streamPlatformFirstplayMap", streamPlatformFirstplayMap);

        List<Date> streamFirstplayDateList = DateUtil.getTimeGapDayList(startDate, endDate);

        //时间信息
        List<String> streamFirstplayDateFormatList = new ArrayList<>();

        Map<Date, Map<String, Long>> streamPlatformFirstplayDateMap = new HashMap<>();
        for (Date date : streamFirstplayDateList) {
            streamFirstplayDateFormatList.add(DateStringUtil.format(date));
        }
        model.addAttribute("streamFirstplayDateFormatList", streamFirstplayDateFormatList);

        for (Date date : streamFirstplayDateList) {
            Map<String, Long> platformMap = new HashMap<>();
            for (PlatformFirstplay platformFirstplay : streamFirstplayList) {
                if (date.getTime() == platformFirstplay.getDate().getTime()) {
                    platformMap.put("bufferTime_" + platformFirstplay.getPlatformId(), platformFirstplay.getBufferTime());
                    platformMap.put("bufferTimeCount_" + platformFirstplay.getPlatformId(), platformFirstplay.getBufferTimeCount());
                }
            }
            streamPlatformFirstplayDateMap.put(date, platformMap);
        }

        Map<Integer, List<String>> streamPlatformFirstplayListMap = new HashMap<>();
        for (Integer platformId : streamPlatformFirstplayList) {
            List<String> platformFirstplayList = new ArrayList<>();
            for (Date date : streamFirstplayDateList) {
                Map<String, Long> sourceMap = streamPlatformFirstplayDateMap.get(date);
                long bufferTime = sourceMap.getOrDefault("bufferTime_" + platformId, 0L);
                long bufferTimeCount = sourceMap.getOrDefault("bufferTimeCount_" + platformId, 0L);
                double bufferRate = 0.0;
                if (bufferTimeCount > 0) {
                    bufferRate = bufferTime * 1.0 / bufferTimeCount / 1000;
                }
                platformFirstplayList.add(decimalFormat.format(bufferRate));
            }
            streamPlatformFirstplayListMap.put(platformId, platformFirstplayList);
        }

        model.addAttribute("streamPlatformFirstplayListMap", streamPlatformFirstplayListMap);

        return "daily/stream/platform/info/direction";

    }
}
