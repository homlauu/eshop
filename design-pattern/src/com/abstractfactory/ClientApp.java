package com.abstractfactory;

public class ClientApp {

	public static void main(String[] args) {

		AbstractFactory factory1 = new ConcreteFactory1();
		Environment e1 = new Environment(factory1);
		e1.Run();

		AbstractFactory factory2 = new ConcreteFactory2();
		Environment e2 = new Environment(factory2);
		e2.Run();
	}
}
