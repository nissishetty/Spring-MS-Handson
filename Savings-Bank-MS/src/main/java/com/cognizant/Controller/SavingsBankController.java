package com.cognizant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.Model.Account;
import com.cognizant.Model.Loan;

@RestController
@RequestMapping("/savings")
public class SavingsBankController {
	
	@Autowired
	private RestTemplate restTemp;
	
	@RequestMapping("/{number}")
	public Account getAccountInfo(@PathVariable("number") String number) {
		
		Account account = restTemp.getForObject("http://account-service/accounts/"+number, Account.class);
		
		
		return account;
		
	}
	
	@RequestMapping("/loan/{num}")
	public Loan getLoanInfo(@PathVariable("num") String num) {
		
		Loan loan = restTemp.getForObject("http://loan-service/loans/"+num, Loan.class);
		
		
		return loan;
		
	}

}
