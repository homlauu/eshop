package com.roncoo.eshop.inventory.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.roncoo.eshop.inventory.thread.RequestProcessorThreadPool;

public class InitListener implements ServletContextListener {


	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("============初始化工作线程池和内存队列===========");
		
		// 初始化工作线程池和内存队列
		RequestProcessorThreadPool.init();
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
