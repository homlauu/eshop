package com.abstractfactory;


public class ProductB2 extends AbstractProductB{

	@Override
	public void Interact(AbstractProductA a) {
		// TODO Auto-generated method stub
		// Console.WriteLine( this + " interacts with " + a );
		System.out.println(this + " interacts with " + a);
	}

}
