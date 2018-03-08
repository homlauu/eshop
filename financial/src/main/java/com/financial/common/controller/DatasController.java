package com.financial.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.financial.common.model.TimeSeriesData;
import com.financial.common.service.DatasService;
import com.financial.common.vo.Response;

@Controller
public class DatasController {

	@Resource
	private DatasService datasService;
	
	/**
	 * http://localhost:8080/testSaveData
	 * @throws IOException 
	 */
	@RequestMapping("/testSaveData")
	@ResponseBody
	public Response testSaveData() throws IOException {
		
		List<TimeSeriesData> timeSeriesDataList = new ArrayList<TimeSeriesData>();
		
		TimeSeriesData bean = new TimeSeriesData();
		bean.setTradingDate("2018-03-05");
		bean.setStockCode("0000001");
		bean.setItemValue(0.01);
		
		TimeSeriesData bean1 = new TimeSeriesData();
		bean1.setTradingDate("2018-03-06");
		bean1.setStockCode("0000002");
		bean1.setItemValue(-0.18);
		
		timeSeriesDataList.add(bean);
		timeSeriesDataList.add(bean1);
		
//		String csvFilePath = "E:/Testfile/2018-03-05.csv";
		Response response = null;
		
		try {
//			List timeSeriesDataList = ParesCsv.readCsv(csvFilePath);
			datasService.saveBatch(timeSeriesDataList);
			
			System.out.println("写入数据:" + timeSeriesDataList.toString());
			
			response = new Response(Response.SUCCESS);
		}catch (Exception e) {
			e.printStackTrace();
			response = new Response(Response.FAILURE);
		}
		return response;
	}
	
}
