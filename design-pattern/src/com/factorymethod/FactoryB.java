package com.factorymethod;


//工厂B类 - 生产B类产品
public class FactoryB extends Factory{
	
	public Product Manufacture() {
		// TODO Auto-generated method stub
		return new ProductB();
	}

}
