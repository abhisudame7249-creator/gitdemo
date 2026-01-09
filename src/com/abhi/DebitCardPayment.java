package com.abhi;

public class DebitCardPayment implements IPayment{
	public void processPayment(double amount)
	{
		System.out.println("Payment Processing Via Debit Card: "+amount);
	}

}
