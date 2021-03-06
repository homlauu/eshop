package com.roncoo.eshop.cache.service.impl;

import javax.annotation.Resource;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisCluster;

import com.alibaba.fastjson.JSONObject;
import com.roncoo.eshop.cache.model.ProductInfo;
import com.roncoo.eshop.cache.model.ShopInfo;
import com.roncoo.eshop.cache.service.CacheService;

/**
 * 缓存Service实现类
 * @author homlau
 *
 */
@Service("cacheService")
public class CacheServiceImpl implements CacheService {

	public static final String CACHE_NAME = "local";
	
	@Resource
	private JedisCluster jedisCluster;
	
	/**
	 * 将商品信息保存到本地缓存中
	 * @param productInfo
	 * @return
	 */
	@CachePut(value = CACHE_NAME, key = "'key_'+#productInfo.getId()")
	public ProductInfo saveLocalCache(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		//System.out.println("设置cache: id=" + productInfo.getId() + " name=" + productInfo.getName() + " price=" + productInfo.getPrice());
		System.out.println(productInfo.toString());
		return productInfo;
	}

	/**
	 * 从本地缓存中获取商品信息
	 * @param id 
	 * @return
	 */
	@Cacheable(value = CACHE_NAME, key = "'key_'+#id")
	public ProductInfo getLocalCache(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 将商品信息保存到本地的ehcache缓存中
	 * @param productInfo
	 */
	@CachePut(value = CACHE_NAME, key = "'product_info_'+#productInfo.getId()")
	public ProductInfo saveProductInfo2LocalCache(ProductInfo productInfo) {
		// TODO Auto-generated method stub
		return productInfo;
	}

	/**
	 * 将店铺信息保存到本地的ehcache缓存中
	 * @param productInfo
	 */
	@CachePut(value = CACHE_NAME, key = "'shop_info_'+#shopInfo.getId()")
	public ShopInfo saveShopInfo2LocalCache(ShopInfo shopInfo) {
		// TODO Auto-generated method stub
		return shopInfo;
	}

	/**
	 * 将商品信息保存到redis中
	 * @param productInfo 
	 */
	public void saveProductInfo2ReidsCache(ProductInfo productInfo) {
		String key = "product_info_" + productInfo.getId();
		jedisCluster.set(key, JSONObject.toJSONString(productInfo));
	}
	
	/**
	 * 将店铺信息保存到redis中
	 * @param productInfo 
	 */
	public void saveShopInfo2ReidsCache(ShopInfo shopInfo) {
		String key = "shop_info_" + shopInfo.getId();
		jedisCluster.set(key, JSONObject.toJSONString(shopInfo));
	}
	
	/**
	 * 从本地ehcache缓存中获取商品信息
	 * @param productId
	 * @return
	 */
	@Cacheable(value = CACHE_NAME, key = "'product_info_'+#productId")
	public ProductInfo getProductInfoFromLocalCache(Long productId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 从本地ehcache缓存中获取店铺信息
	 * @param productId
	 * @return
	 */
	@Cacheable(value = CACHE_NAME, key = "'shop_info_'+#shopId")
	public ShopInfo getShopInfoFromLocalCache(Long shopId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
