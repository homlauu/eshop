package com.abstractfactory;

public class ConcreteFactory2 extends AbstractFactory{

	@Override
	public AbstractProductA CreateProductA() {
		// TODO Auto-generated method stub
		return new ProductA2();
	}

	@Override
	public AbstractProductB CreateProductB() {
		// TODO Auto-generated method stub
		return new ProductB2();
	}

}
