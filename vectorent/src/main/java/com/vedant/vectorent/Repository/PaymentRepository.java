package com.vedant.vectorent.Repository;

import org.springframework.stereotype.Repository;

import com.vedant.vectorent.DTO.PaymentRequest;
import com.vedant.vectorent.Entity.PaymentEntity;

@Repository
public class PaymentRepository {

	public PaymentEntity getPaymentById(PaymentRequest request) {
		PaymentEntity paymentModel = executeQuery(request);
		return paymentModel;
		
	}
	
	private PaymentEntity executeQuery(PaymentRequest request) {
		PaymentEntity payment = new PaymentEntity();
		payment.setId(request.getId());
		payment.setPaymentAmount(100.00);
		payment.setPaymentCurrency("INR");
		return payment;
	}
}
