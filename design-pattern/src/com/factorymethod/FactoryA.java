package com.factorymethod;

//工厂A类 - 生产A类产品
public class FactoryA extends Factory{
	
	public Product Manufacture() {
		// TODO Auto-generated method stub
		return new ProductA();
	}

}
