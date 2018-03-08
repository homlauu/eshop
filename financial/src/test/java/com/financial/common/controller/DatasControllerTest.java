package com.financial.common.controller;

import java.io.IOException;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.financial.common.Application;

public class DatasControllerTest {

	@Test
	public void testSaveData() {
		
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class);
		
		DatasController controller = (DatasController) ctx.getBean("datasController");
		try {
			controller.testSaveData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
