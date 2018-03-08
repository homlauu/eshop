package com.roncoo.eshop.inventory.dao.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import redis.clients.jedis.JedisCluster;

import com.roncoo.eshop.inventory.dao.RedisDAO;

@Repository("redisDAO")
public class RedisDAOImpl implements RedisDAO {
	@Resource
	private JedisCluster jedisCluster;
	
	public void set(String key, String value) {
		jedisCluster.set(key, value);

	}
	
	public String get(String key) {
		return jedisCluster.get(key);
	}

	public void delete(String key) {
		jedisCluster.del(key);
	}

}
