package com.factorymethod;

//������������
public class FactoryPattern {
	
	public static void main(String[] args) {
		// �ͻ�Ҫ��ƷA
		FactoryA mFactoryA = new FactoryA();
		mFactoryA.Manufacture().show();
		
		// �ͻ�Ҫ��ƷB
		FactoryB mFactoryB = new FactoryB();
		mFactoryB.Manufacture().show();
		
	}
}
