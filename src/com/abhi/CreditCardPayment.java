package com.abhi;

public class CreditCardPayment implements IPayment{
	
	public void processPayment(double amount)
	{
		System.out.println("Payment Processing Via Credit Card: "+amount);
	}

}
