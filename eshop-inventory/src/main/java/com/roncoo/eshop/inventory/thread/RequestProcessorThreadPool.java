package com.roncoo.eshop.inventory.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.roncoo.eshop.inventory.request.Request;
import com.roncoo.eshop.inventory.request.RequestQueue;

/**
 * 请求处理线程池：单例
 * @author homlau
 *
 */
public class RequestProcessorThreadPool {

	// 在实际项目中，你设置线程池大小是多少，每个线程监控的那个内存队列的大小是多少
	// 都可以做到一个外部的配置文件中
	// 我们这了就给简化了，直接写死了，好吧
	
	/**
	 * 线程池
	 */
	private ExecutorService threadPool = Executors.newFixedThreadPool(10);

	/**
	 * 内存队列
	 */
//	private List<ArrayBlockingQueue<Request>> queues = new ArrayList<ArrayBlockingQueue<Request>>();
//
//	public RequestProcessorThreadPool() {
//		
//		for (int i = 0; i < 10; i++) {
//			ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(100);
//			queues.add(queue);
//			threadPool.submit(new RequestProcessorThread(queue));
//		}
//	}
	
	public RequestProcessorThreadPool() {
		RequestQueue requestQueue = RequestQueue.getInstance();
		
		for (int i = 0; i < 10; i++) {
			ArrayBlockingQueue<Request> queue = new ArrayBlockingQueue<Request>(100);
			requestQueue.addQueue(queue);
			threadPool.submit(new RequestProcessorThread(queue));
		}
	}
	
	/**
	 * 单例有很多种方式去实现：我采取绝对线程安全的一种方式
	 * 
	 * 静态内部类的方式，去初始化单例
	 * @author homlau
	 *
	 */
	private static class Singleton {
		
		private static RequestProcessorThreadPool instance;
		
		static {
			instance = new RequestProcessorThreadPool();
		}
		
		public static RequestProcessorThreadPool getInstance() {
			return instance;
		}
	}
	
	/**
	 * jvm的机制去保证多线程并发安全
	 * 
	 * 内部类的初始化，一定只会发生一次，不管多少个线程并发去初始化
	 * 
	 * @return
	 */
	public static RequestProcessorThreadPool getInstance() {
		return Singleton.getInstance();
	}
	
	/**
	 * 初始化的便捷方法
	 */
	public static void init() {
		getInstance();
	}
	
}
