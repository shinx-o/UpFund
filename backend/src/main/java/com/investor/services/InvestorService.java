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
		System.out.println("Calling Service");
		try {
			investorRepository.save(investor);
			return "User created successfully";
		}catch (Exception e) {
			return e.getMessage();
		}
    }
	
	public String updateInvestorByIdCompletely(int investorId, Investor i) {
	    Investor existingInvestor = investorRepository.findOne(investorId);
	    if (existingInvestor == null) {
	        return "Investor not found";
	    }
	    existingInvestor.setInvestorPassword(i.getInvestorPassword());
	    existingInvestor.setInvestorName(i.getInvestorName());
	    existingInvestor.setInvestorEmail(i.getInvestorEmail());
	    existingInvestor.setInvestorPhoneNumber(i.getInvestorPhoneNumber());
	    
	    // ...

	    investorRepository.save(existingInvestor); // Use save to update the entity

	    return "Investor updated successfully";
	}

	public String updateInvestorById(int investorId,  Investor i) {
	    Investor existingInvestor = investorRepository.findOne(investorId);
	    if (existingInvestor == null) {
	        return "Investor not found";
	    }

	    // Update only the non-null attributes of the existingInvestor using the data from i
	    if (i.getInvestorPassword() != null) {
	        existingInvestor.setInvestorPassword(i.getInvestorPassword());
	    }
	    if (i.getInvestorName() != null) {
	        existingInvestor.setInvestorName(i.getInvestorName());
	    }
	    if(i.getInvestorEmail()!=null)
	    {
	    	existingInvestor.setInvestorEmail(i.getInvestorEmail());
	    }
	    if(i.getInvestorPhoneNumber()!=0)
	    {
	    	existingInvestor.setInvestorPhoneNumber(i.getInvestorPhoneNumber());
	    }
	    // ...

	    investorRepository.save(existingInvestor); // Use save to update the entity

	    return "Investor updated successfully";
	}
	
	public String deleteInvestorById( int investorId) {
		
	    investorRepository.delete(investorId);
	    return "Investor deleted successfully";
	    
	}
	
	@SuppressWarnings("unchecked")
	public Map<String,String> getInvestorById(int investorId)
	{
		Map<String,String> response=new HashMap<String, String>();
	    Investor existingInvestor = investorRepository.findOne(investorId);
	    
	    String id = "" + existingInvestor.getInvestorId();
	    String name = "" + existingInvestor.getInvestorName();
	    response.put("id", id);
	    response.put("name", name);
//	    response.put("email", (T) existingInvestor.getInvestorEmail());
//	    response.put("phoneNumber", (T) existingInvestor.getInvestorPhoneNumber());

	    return response;   
	}
	
//	public String updateInvestorById(int investorId,Investor i)
//	{
//		for(Investor it:investorRepository.findAll())
//		{
//			if(it.getInvestorId()==investorId)
//			{
//				it.setInvestorName(i.getInvestorName());
//				it.setInvestorEmail(i.getInvestorEmail());
//				it.setInvestorPhoneNumber(i.getInvestorPhoneNumber());
//				it.setInvestorPassword(i.getInvestorPassword());
//				
//				return "Updated investor with Invenstor_id"+investorId+"successfully";
//				
//			}
//		}
//		return "Not Updated Since no investor with this "+investorId+"found";
//		
//	}

  
}
