package com.financial.common.service;

import java.util.List;

import com.financial.common.model.TimeSeriesData;


public interface DatasService {

	void saveBatch(List<TimeSeriesData > timeSeriesDataList);
	
}
