package com.financial.common.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.financial.common.mapper.TimeSeriesDataMapper;
import com.financial.common.model.TimeSeriesData;
import com.financial.common.service.DatasService;

@Service("datasService")
public class DatasServiceImpl implements DatasService {
	
	@Resource
	private TimeSeriesDataMapper timeSeriesDataMapper;
	
	public void saveBatch(List<TimeSeriesData> timeSeriesDataList) {
		timeSeriesDataMapper.insertBatch(timeSeriesDataList);
	}

}
