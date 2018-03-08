package com.singleton;

/**
 * 
* @ClassName: Singleton 
* @Description: TODO(����ģʽ�������أ�) 
*
 */
public class Singleton {

	private static volatile Singleton instance = null;

	public Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
}
