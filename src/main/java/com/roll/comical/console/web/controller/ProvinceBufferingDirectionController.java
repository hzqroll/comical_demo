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

import com.roll.comical.console.business.province.ProvinceBuffering;
import com.roll.comical.console.business.province.service.ProvinceBufferingService;
import com.roll.comical.console.util.DateConvertUtil;
import com.roll.comical.console.util.DateStringUtil;
import com.roll.comical.console.util.DateUtil;
import com.roll.comical.console.util.ProvinceUtil;
import com.roll.comical.console.util.SourceUtil;

/**
 * @author micah.shi
 */

@Controller
@RequestMapping("/province/buffering/direction")
public class ProvinceBufferingDirectionController extends AbstractController {

	@Autowired
	private ProvinceBufferingService provinceBufferingService;

	private DecimalFormat decimalFormat = new DecimalFormat("#0.00");

	@RequestMapping
	public String info(
			Model model,
			@RequestParam(value = "day", required = false, defaultValue = "7") int day,
			@RequestParam(value = "provinceId", required = false, defaultValue = "110000") int provinceId
	) {
		model.addAttribute("day", day);
		model.addAttribute("provinceId", provinceId);
		// 省份明细信息
		model.addAttribute("provinceIdList", ProvinceUtil.getIdList());
		model.addAttribute("provinceMap", ProvinceUtil.getMap());

		Date startDate = DateConvertUtil.asDate(LocalDate.now().minusDays(day));
		Date endDate = DateConvertUtil.asDate(LocalDate.now().minusDays(1));

		List<ProvinceBuffering> provinceBufferingList = provinceBufferingService.getList(provinceId, startDate, endDate);


		List<Integer> provinceSourceIdList = new ArrayList<>();
		Map<Integer, String> provinceSourceNameMap = new HashMap<>();

		// 有哪些源的cdn
		for (ProvinceBuffering buffering : provinceBufferingList) {
			if (!provinceSourceIdList.contains(buffering.getSourceId())) {
				provinceSourceIdList.add(buffering.getSourceId());
				provinceSourceNameMap.put(buffering.getSourceId(), SourceUtil.getName(buffering.getSourceId()));
			}
		}

		model.addAttribute("provinceSourceIdList", provinceSourceIdList);
		model.addAttribute("provinceSourceNameMap", provinceSourceNameMap);

		List<Date> provinceDateList = DateUtil.getTimeGapDayList(startDate, endDate);

		// 时间列表
		List<String> provinceDateFormatList = new ArrayList<>();


		Map<Date, Map<String, Long>> provinceDateSourceMap = new HashMap<>();
		for (Date date : provinceDateList) {
			provinceDateFormatList.add(DateStringUtil.format(date));
		}
		model.addAttribute("provinceDateList", provinceDateFormatList);

		for (Date date : provinceDateList) {
			Map<String, Long> sourceMap = new HashMap<>();
			for (ProvinceBuffering buffering : provinceBufferingList) {
				if (date.getTime() == buffering.getDate().getTime()) {
					sourceMap.put("bufferCount_" + buffering.getSourceId(), buffering.getBufferingCount());
					sourceMap.put("fluencyCount_" + buffering.getSourceId(), buffering.getFluencyCount());
				}
			}
			provinceDateSourceMap.put(date, sourceMap);
		}

		Map<Integer, List<String>> provinceSourceBufferingListMap = new HashMap<>();
		for (Integer sourceId : provinceSourceIdList) {
			List<String> sourceBufferingList = new ArrayList<>();
			for (Date date : provinceDateList) {
				Map<String, Long> sourceMap = provinceDateSourceMap.get(date);
				long bufferCount = sourceMap.getOrDefault("bufferCount_" + sourceId, 0L);
				long fluencyCount = sourceMap.getOrDefault("fluencyCount_" + sourceId, 0L);
				double bufferRate = 0.0;
				if (fluencyCount > 0) {
					bufferRate = bufferCount * 100.0 / fluencyCount;
				}
				sourceBufferingList.add(decimalFormat.format(bufferRate));
			}
			provinceSourceBufferingListMap.put(sourceId, sourceBufferingList);
		}

		model.addAttribute("provinceSourceBufferingListMap", provinceSourceBufferingListMap);

		return "province/buffering/direction";
	}
}
