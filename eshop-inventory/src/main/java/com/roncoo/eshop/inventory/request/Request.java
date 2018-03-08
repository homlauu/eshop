package com.roncoo.eshop.inventory.request;
/**
 * 请求接口
 * @author homlau
 *
 */
public interface Request {
	
	void process();
	
	Integer getProductId();

	boolean isForceRefresh();
	
}
