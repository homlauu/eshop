package com.factorymethod;

//生产工作流程
public class FactoryPattern {
	
	public static void main(String[] args) {
		// 客户要产品A
		FactoryA mFactoryA = new FactoryA();
		mFactoryA.Manufacture().show();
		
		// 客户要产品B
		FactoryB mFactoryB = new FactoryB();
		mFactoryB.Manufacture().show();
		
	}
}
