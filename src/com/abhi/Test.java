package com.abhi;

public class Test {
	
	public static void main(String[] args) {
//		PaymentService paymentService=new PaymentService();
//		paymentService.debit=new DebitCardPayment(); //for solving the problem of null pointer
//		paymentService.credit=new CreditCardPayment();
		//using Field =Field level injection or variable level injection
//		paymentService.payment=new DebitCardPayment();
//		paymentService.doPayment(1111);
		
		//using constructor level injection
//		PaymentService paymentService=new PaymentService(new DebitCardPayment());
//		paymentService.doPayment(1111);
		
		
		//Setter method 
		PaymentService paymentService=new PaymentService();
		paymentService.setPayment(new DebitCardPayment());
		paymentService.doPayment(1111);
		
	}

}
