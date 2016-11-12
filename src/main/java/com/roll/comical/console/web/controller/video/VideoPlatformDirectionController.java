package com.roll.comical.console.web.controller.video;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roll.comical.console.business.video.buffering.platform.VideoPlatformBuffering;
import com.roll.comical.console.business.video.buffering.platform.service.VideoPlatformService;
import com.roll.comical.console.util.DateConvertUtil;
import com.roll.comical.console.util.DateStringUtil;
import com.roll.comical.console.util.DateUtil;
import com.roll.comical.console.util.PlatformUtil;
import com.roll.comical.console.web.controller.AbstractController;

/**
 * @author zongqiang.hao
 */

@Controller
@RequestMapping("/daily/video/platform/info/direction")
public class VideoPlatformDirectionController extends AbstractController {
    @Autowired
    VideoPlatformService videoPlatformService;

    private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

    @RequestMapping
    public String info(Model model,
                       @RequestParam(value = "day", required = false, defaultValue = "7") int day) {

        Date startDate = DateConvertUtil.asDate(LocalDate.now().minusDays(day));
        Date endDate = DateConvertUtil.asDate(LocalDate.now().minusDays(1));

        /**
         * 平台卡顿数据
         */
        List<VideoPlatformBuffering> videoBufferingList = videoPlatformService.getList(startDate, endDate);


        model.addAttribute("day", day);

        List<Integer> videoPlatformBufferingList = new ArrayList<>();
        Map<Integer, String> videoPlatformBufferingMap = new HashMap<>();

        //platformId->具体名称
        for (VideoPlatformBuffering buffering : videoBufferingList) {
            if (!videoPlatformBufferingList.contains(buffering.getPlatformId())) {
                videoPlatformBufferingList.add(buffering.getPlatformId());
                videoPlatformBufferingMap.put(buffering.getPlatformId(), PlatformUtil.getName(buffering.getPlatformId()));
            }
        }

        //平台列表
        Collections.sort(videoPlatformBufferingList);
        if (videoPlatformBufferingList.contains(0)) {
            videoPlatformBufferingList.remove(0);
            Collections.sort(videoPlatformBufferingList);
            videoPlatformBufferingList.add(0);
        } else {
            Collections.sort(videoPlatformBufferingList);
        }
        model.addAttribute("videoPlatformBufferingList", videoPlatformBufferingList);
        //平台id+名称

        model.addAttribute("videoPlatformBufferingMap", videoPlatformBufferingMap);

        List<Date> videoBufferingDateList = DateUtil.getTimeGapDayList(startDate, endDate);

        //时间信息
        List<String> videoBufferingDateFormatList = new ArrayList<>();

        Map<Date, Map<String, Long>> videoPlatformBufferingDateMap = new HashMap<>();
        for (Date date : videoBufferingDateList) {
            videoBufferingDateFormatList.add(DateStringUtil.format(date));
        }
        model.addAttribute("videoBufferingDateFormatList", videoBufferingDateFormatList);

        for (Date date : videoBufferingDateList) {
            Map<String, Long> platformMap = new HashMap<>();
            for (VideoPlatformBuffering platformBuffering : videoBufferingList) {
                if (date.getTime() == platformBuffering.getDate().getTime()) {
                    platformMap.put("bufferCount_" + platformBuffering.getPlatformId(), platformBuffering.getBufferingCount());
                    platformMap.put("fluencyCount_" + platformBuffering.getPlatformId(), platformBuffering.getFluencyCount());
                }
            }
            videoPlatformBufferingDateMap.put(date, platformMap);
        }

        Map<Integer, List<String>> videoPlatformBufferingListMap = new HashMap<>();
        for (Integer platformId : videoPlatformBufferingList) {
            List<String> platformBufferingList = new ArrayList<>();
            for (Date date : videoBufferingDateList) {
                Map<String, Long> sourceMap = videoPlatformBufferingDateMap.get(date);
                long bufferCount = sourceMap.getOrDefault("bufferCount_" + platformId, 0L);
                long fluencyCount = sourceMap.getOrDefault("fluencyCount_" + platformId, 0L);
                double bufferRate = 0.0;
                if (fluencyCount > 0) {
                    bufferRate = bufferCount * 100.0 / fluencyCount;
                }
                platformBufferingList.add(decimalFormat.format(bufferRate));
            }
            videoPlatformBufferingListMap.put(platformId, platformBufferingList);
        }

        model.addAttribute("videoPlatformBufferingListMap", videoPlatformBufferingListMap);


        return "daily/video/platform/info/direction";

    }
}
