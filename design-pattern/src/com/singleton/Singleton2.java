package com.singleton;

/**
 * 
* @ClassName: Singleton2 
* @Description: TODO(����ģʽ) 
*
 */
public class Singleton2 {

	private static final Singleton2 instance = new Singleton2();

	public static Singleton2 getInstance() {
		return instance;
	}

}
