package com.roll.comical.console.web.controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roll.comical.console.business.buffering.DailyBuffering;
import com.roll.comical.console.business.buffering.service.DailyBufferingService;
import com.roll.comical.console.business.first.play.FirstPlayBuffering;
import com.roll.comical.console.business.first.play.service.FirstPlayBufferingService;
import com.roll.comical.console.util.DateConvertUtil;
import com.roll.comical.console.util.DateStringUtil;
import com.roll.comical.console.util.DateUtil;
import com.roll.comical.console.util.SourceUtil;

/**
 * @author micah.shi
 */

@Controller
@RequestMapping("/daily/buffering/direction")
public class DailyBufferingDirectionController extends AbstractController {

	@Autowired
	private FirstPlayBufferingService firstPlayBufferingService;

	@Autowired
	private DailyBufferingService dailyBufferingService;

	private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

	@RequestMapping
	public String info(
			Model model,
			@RequestParam(value = "day", required = false, defaultValue = "7") int day
	) {
		Date startDate = DateConvertUtil.asDate(LocalDate.now().minusDays(day));
		Date endDate = DateConvertUtil.asDate(LocalDate.now().minusDays(1));

		List<FirstPlayBuffering> firstPlayBufferingList = firstPlayBufferingService.getList(startDate, endDate);

		model.addAttribute("day", day);

		List<Integer> firstPlaySourceIdList = new ArrayList<>();
		Map<Integer, String> firstPlaySourceNameMap = new HashMap<>();

		// 有哪些源的cdn
		for (FirstPlayBuffering buffering : firstPlayBufferingList) {
			if (!firstPlaySourceIdList.contains(buffering.getSourceId())) {
				firstPlaySourceIdList.add(buffering.getSourceId());
				firstPlaySourceNameMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
			}
		}

		model.addAttribute("firstPlaySourceIdList", firstPlaySourceIdList);
		model.addAttribute("firstPlaySourceNameMap", firstPlaySourceNameMap);

		List<Date> firstPlayDateList = DateUtil.getTimeGapDayList(startDate, endDate);

		// 时间列表
		List<String> firstPlayDateFormatList = new ArrayList<>();


		Map<Date, Map<String, Long>> firstPlayDateSourceMap = new HashMap<>();
		for (Date date : firstPlayDateList) {
			firstPlayDateFormatList.add(DateStringUtil.format(date));
		}
		model.addAttribute("firstPlayDateList", firstPlayDateFormatList);

		for (Date date : firstPlayDateList) {
			Map<String, Long> sourceMap = new HashMap<>();
			for (FirstPlayBuffering buffering : firstPlayBufferingList) {
				if (date.getTime() == buffering.getDate().getTime()) {
					sourceMap.put("bufferTime_" + buffering.getSourceId(), buffering.getBufferTime());
					sourceMap.put("bufferTimeCount_" + buffering.getSourceId(), buffering.getBufferTimeCount());
				}
			}
			firstPlayDateSourceMap.put(date, sourceMap);
		}

		Map<Integer, List<String>> firstPlaySourceBufferingListMap = new HashMap<>();
		for (Integer sourceId : firstPlaySourceIdList) {
			List<String> sourceBufferingList = new ArrayList<>();
			for (Date date : firstPlayDateList) {
				Map<String, Long> sourceMap = firstPlayDateSourceMap.get(date);
				long bufferTime = sourceMap.getOrDefault("bufferTime_" + sourceId, 0L);
				long bufferTimeCount = sourceMap.getOrDefault("bufferTimeCount_" + sourceId, 0L);
				double bufferRate = 0.0;
				if (bufferTimeCount > 0) {
					bufferRate = bufferTime * 1.0 / bufferTimeCount / 1000;
				}
				sourceBufferingList.add(decimalFormat.format(bufferRate));
			}
			firstPlaySourceBufferingListMap.put(sourceId, sourceBufferingList);
		}

		model.addAttribute("firstPlaySourceBufferingListMap", firstPlaySourceBufferingListMap);


		// 每日卡顿率
		List<DailyBuffering> dailyBufferingList = dailyBufferingService.getList(startDate, endDate);

		List<Integer> dailyBufferingSourceIdList = new ArrayList<>();
		Map<Integer, String> dailyBufferingSourceNameMap = new HashMap<>();

		// 有哪些源的cdn
		for (DailyBuffering buffering : dailyBufferingList) {
			if (!dailyBufferingSourceIdList.contains(buffering.getSourceId())) {
				dailyBufferingSourceIdList.add(buffering.getSourceId());
				dailyBufferingSourceNameMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
			}
		}

		model.addAttribute("dailyBufferingSourceIdList", dailyBufferingSourceIdList);
		model.addAttribute("dailyBufferingSourceNameMap", dailyBufferingSourceNameMap);

		List<Date> dailyBufferingDateList = DateUtil.getTimeGapDayList(startDate, endDate);

		// 时间列表
		List<String> dailyBufferingDateFormatList = new ArrayList<>();


		Map<Date, Map<String, Long>> dailyBufferingDateSourceMap = new HashMap<>();
		for (Date date : dailyBufferingDateList) {
			dailyBufferingDateFormatList.add(DateStringUtil.format(date));
		}
		model.addAttribute("dailyBufferingDateList", dailyBufferingDateFormatList);

		for (Date date : dailyBufferingDateList) {
			Map<String, Long> sourceMap = new HashMap<>();
			for (DailyBuffering buffering : dailyBufferingList) {
				if (date.getTime() == buffering.getDate().getTime()) {
					sourceMap.put("bufferCount_" + buffering.getSourceId(), buffering.getBufferingCount());
					sourceMap.put("fluencyCount_" + buffering.getSourceId(), buffering.getFluencyCount());
				}
			}
			dailyBufferingDateSourceMap.put(date, sourceMap);
		}

		Map<Integer, List<String>> dailySourceBufferingListMap = new HashMap<>();
		for (Integer sourceId : dailyBufferingSourceIdList) {
			List<String> sourceBufferingList = new ArrayList<>();
			for (Date date : dailyBufferingDateList) {
				Map<String, Long> sourceMap = dailyBufferingDateSourceMap.get(date);
				long bufferCount = sourceMap.getOrDefault("bufferCount_" + sourceId, 0L);
				long fluencyCount = sourceMap.getOrDefault("fluencyCount_" + sourceId, 0L);
				double bufferRate = 0.0;
				if (fluencyCount > 0) {
					bufferRate = bufferCount * 100.0 / fluencyCount;
				}
				sourceBufferingList.add(decimalFormat.format(bufferRate));
			}
			dailySourceBufferingListMap.put(sourceId, sourceBufferingList);
		}

		model.addAttribute("dailySourceBufferingListMap", dailySourceBufferingListMap);
		return "daily/buffering/direction";
	}
}
