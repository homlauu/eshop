package com.roncoo.eshop.inventory.service.impl;

import java.util.concurrent.ArrayBlockingQueue;

import org.springframework.stereotype.Service;

import com.roncoo.eshop.inventory.request.Request;
import com.roncoo.eshop.inventory.request.RequestQueue;
import com.roncoo.eshop.inventory.service.RequestAsyncProcessService;

/**
 * 请求异步处理的service实现
 * @author homlau
 *
 */
@Service("requestAsyncProcessService")
public class RequestAsyncProcessServiceImpl implements RequestAsyncProcessService {

	public void process(Request request) {
		// TODO Auto-generated method stub
		try {
			// 先做读请求的去重  移到  RequestProcessorThread.java
//			RequestQueue requestQueue = RequestQueue.getInstance();
//			Map<Integer, Boolean> flagMap = requestQueue.getFlagMap();
//			if (request instanceof ProductInventoryDBUpdateRequest) {
//				// 如果是一个更新数据库的请求，那么就将那个productId对应的标识设置为true
//				flagMap.put(request.getProductId(), true);
//			} else if (request instanceof ProductInventoryCacheRefreshRequest) {
//				// 如果是缓存刷新的请求，那么就判断：如果标识不为空，且为true,就说明之前有一个商品的数据库更新请求
//				Boolean flag = flagMap.get(request.getProductId());
//				if (flag != null && flag) {
//					flagMap.put(request.getProductId(), false);
//				}
//				
//				// 如果flag是null
//				if (flag == null) {
//					flagMap.put(request.getProductId(), false);
//				}
//				
//				// 如果是缓存刷新的请求，那么就判断：如果标识不为空，且为flase,
//				// 就说明之前有一个商品的数据库更新请求，一个缓存刷新请求
//				if (flag != null && !flag) {
//					return;
//				}
//				
//			}
			
			// 做请求的路由，根据每个请求的商品id，路由到对应的内存队列中去
			ArrayBlockingQueue<Request> queue = getRoutingQueue(request.getProductId());
			// 将请求放入对应的队列中，完成路由操作
			queue.put(request);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	/**
	 * 获取路由到的内存队列
	 * @param productId 商品id
	 * @return 内存队列
	 */
	private ArrayBlockingQueue<Request> getRoutingQueue(Integer productId) {
		RequestQueue requestQueue = RequestQueue.getInstance();
		
		// 先获取productId的hash值
		String key = String.valueOf(productId);
		int h;
		int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
		
		// 对hash值取模，将hash值路由到指定的内存队列中，比如内存队列大小8
		// 用内存队列的数量对hash值取模之后，结果一定是在0~7之间
		// 所以任何一个商品id都会被固定路由到同样的一个内存队列中去的
		int index = (requestQueue.queueSize() - 1) & hash;
		
		System.out.println("===========日志===========: 路由内存队列，商品id=" + productId + ", 队列索引=" + index);  
		
		return requestQueue.getQueue(index);
		
	}

}
