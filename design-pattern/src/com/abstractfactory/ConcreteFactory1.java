package com.abstractfactory;

public class ConcreteFactory1 extends AbstractFactory{

	@Override
	public AbstractProductA CreateProductA() {
		// TODO Auto-generated method stub
		return new ProductA1();
	}

	@Override
	public AbstractProductB CreateProductB() {
		// TODO Auto-generated method stub
		return new ProductB1();
	}

}
