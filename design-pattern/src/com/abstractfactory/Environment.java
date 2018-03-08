package com.abstractfactory;

public class Environment {
	// Fields
	private AbstractProductA AbstractProductA;
	private AbstractProductB AbstractProductB;

	// Constructors
	public Environment(AbstractFactory factory) {
		AbstractProductB = factory.CreateProductB();
		AbstractProductA = factory.CreateProductA();
	}

	// Methods
	public void Run() {
		AbstractProductB.Interact(AbstractProductA);
	}

}
