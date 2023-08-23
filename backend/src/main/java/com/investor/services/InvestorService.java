package com.investor.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.investor.models.Investor;
import com.repository.InvestorRepository;

@Service
public class InvestorService {

	@Autowired
	InvestorRepository investorRepository;

	public String createInvestor(Investor investor) {
		try {
			investorRepository.save(investor);
			return "User created successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String updateInvestorById(int investorId, Investor i) throws Exception {
		try {

			Investor existingInvestor = investorRepository.findOne(investorId);

			if (existingInvestor == null) {
				throw new Exception("No Investor Found With Investor ID: " + investorId);
			}

			String res = "Investor's ";
			if (i.getInvestorPassword() != null) {
				existingInvestor.setInvestorPassword(i.getInvestorPassword());
				res += "Password, ";
			}

			if (i.getInvestorName() != null) {
				existingInvestor.setInvestorName(i.getInvestorName());
				res += "Name, ";
			}

			if (i.getInvestorEmail() != null) {
				existingInvestor.setInvestorEmail(i.getInvestorEmail());
				res += "Email, ";
			}

			if (i.getInvestorPhoneNumber() != 0) {
				existingInvestor.setInvestorPhoneNumber(i.getInvestorPhoneNumber());
				res += "Phone Number, ";
			}

			res += "Updated Successfully.";
			investorRepository.save(existingInvestor); // Use save to update the entity

			return res;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	public String deleteInvestorById(int investorId) throws Exception {
		try {
			investorRepository.delete(investorId);
			return "Investor deleted successfully";
		} catch (Exception e) {
			throw new Exception(e);
		}

	}

	public Map<String, Object> getInvestorById(int investorId) throws Exception {
		try {

			Map<String, Object> response = new HashMap<String, Object>();
			Investor existingInvestor = investorRepository.findOne(investorId);

			if (existingInvestor == null) {
				throw new Exception("No Investor Found With Investor ID: " + investorId);
			}

			int id = existingInvestor.getInvestorId();
			String name = existingInvestor.getInvestorName();
			response.put("id", id);
			response.put("name", name);

			return response;

		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
