package com.financial.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.financial.common.model.TimeSeriesData;

public interface TimeSeriesDataMapper {
	
	public void insertBatch(@Param("list")List<TimeSeriesData > timeSeriesDataList);
	
}
