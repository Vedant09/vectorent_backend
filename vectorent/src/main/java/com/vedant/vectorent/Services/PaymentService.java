package com.vedant.vectorent.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedant.vectorent.DTO.PaymentRequest;
import com.vedant.vectorent.DTO.PaymentResponse;
import com.vedant.vectorent.Entity.PaymentEntity;
import com.vedant.vectorent.Repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	PaymentRepository  paymentRepository;
	
	public PaymentResponse getPaymentDetailsById(PaymentRequest internalRequestObj) {
		PaymentEntity paymentModel = paymentRepository.getPaymentById(internalRequestObj);
		
		PaymentResponse paymentResponse = mapModelToResponseDTO(paymentModel);
		
		return paymentResponse;
	}
	
	private PaymentResponse mapModelToResponseDTO(PaymentEntity paymentEntity) {
		PaymentResponse response = new PaymentResponse();
		response.setPaymentId(paymentEntity.getId());
		response.setAmount(paymentEntity.getPaymentAmount());
		response.setCurrency(paymentEntity.getPaymentCurrency());
		
		return response;
	}
}
