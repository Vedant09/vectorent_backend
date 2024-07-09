package com.vedant.vectorent.Controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedant.vectorent.DTO.PaymentRequest;
import com.vedant.vectorent.DTO.PaymentResponse;
import com.vedant.vectorent.Services.PaymentService;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@GetMapping("/{id}")
	public ResponseEntity<PaymentResponse> getPaymentById(@PathVariable Long id){
		
		PaymentRequest internalRequestObj = new PaymentRequest();
		internalRequestObj.setId(id);
		
		PaymentResponse payment = paymentService.getPaymentDetailsById(internalRequestObj);
		return ResponseEntity.ok(payment);
		
	}
	
	@GetMapping(path = "/getusers")
	public String getUsers(@RequestParam (name = "firstname") String firstname){
		String output = "fetched user details of "+firstname;
		
		return output;
		
	}
}
