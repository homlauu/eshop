package com.financial.common.uitls;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.csvreader.CsvReader;
import com.financial.common.model.TimeSeriesData;

public class ParesCsv {

	public final static String FORMAT_YYYYMMDD24HHMMSS = "yyyy-MM-dd HH:mm:ss";
	
	public static void main(String[] args) throws Exception {
		// 解析目标文件
		String filePath = "E:/Testfile/2018-03-05.csv";
		List infos = readCsv(filePath);
		System.out.println(infos.toString());
	}
	
	public static List readCsv(String csvFilePath) throws IOException {
		
		Map infosMap = new HashMap();
		/**保存行数据的列表*/
        List listRows = new ArrayList();
		
		CsvReader reader = new CsvReader(csvFilePath, ',', Charset.forName("UTF-8"));

		SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_YYYYMMDD24HHMMSS);
		String dataStr = formatter.format(new Date());
		
		while (reader.readRecord()) {
			Map rowsMap = new HashMap();
			
			if (reader.getCurrentRecord() == 0)
				continue;
			
			if (StringUtils.isEmpty(reader.getValues()[0]))
				continue;
			
			for (int i = 1; i < reader.getValues().length; i++) {
				if (StringUtils.isEmpty(reader.getValues()[i]))
					continue;
				TimeSeriesData bean = new TimeSeriesData();
				bean.setStockCode(reader.getValues()[0]);
				bean.setItemValue(Double.parseDouble(reader.getValues()[i]));
				bean.setTradingDate(dataStr);
				listRows.add(bean);
			}
		}
		reader.close();
		
		return listRows;
	}
	
}
