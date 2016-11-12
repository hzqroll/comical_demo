package com.roll.comical.console.business.province.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roll.comical.console.business.province.ProvinceBuffering;
import com.roll.comical.console.business.province.dao.ProvinceBufferingDao;
import com.roll.comical.console.business.province.service.ProvinceBufferingService;

/**
 * @author micah.shi
 */
@Service
public class ProvinceBufferingServiceImpl implements ProvinceBufferingService {

	@Autowired
	private ProvinceBufferingDao provinceBufferingDao;
	@Override
	public List<ProvinceBuffering> getList(int provinceId, Date startDate, Date endDate) {
		return provinceBufferingDao.getList(provinceId, startDate, endDate);
	}
}
