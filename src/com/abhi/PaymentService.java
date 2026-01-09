package com.abhi;

public class PaymentService {
	
	
	//this is said as to loose coupling
//	DebitCardPayment debitCardPayment=new DebitCardPayment();
//	CreditCardPayment creditCardPayment=new CreditCardPayment();

//	DebitCardPayment debit; //null 
//	CreditCardPayment credit;
	
	IPayment payment; //2 calsses implement ipayment debit and credit
	
	public void setPayment(IPayment payment)
	{
		this.payment=payment;
	}
	
//	public PaymentService(IPayment payment) {
//		this.payment=payment;
//		// TODO Auto-generated constructor stub
//	}
	
	public void doPayment(double amount)	
	{
		
		//debitCardPayment.provesspayment(amount);
//		creditCardPayment.provesspayment(amount);
		
//		debit.provesspayment(amount);
//		credit.provesspayment(amount);
		
		payment.processPayment(amount);
		System.out.println("Payment success");
	}

}
