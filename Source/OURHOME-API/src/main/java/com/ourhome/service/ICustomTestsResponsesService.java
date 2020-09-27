package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.CustomTestsResponses;

public interface ICustomTestsResponsesService {

	public List<CustomTestsResponses> listCustomTestsResponses(); 
	
	public CustomTestsResponses saveCustomTestResponses(CustomTestsResponses CustomTestResponses);	
	
	public CustomTestsResponses searchCustomTestResponses(int id);
	
	public CustomTestsResponses updateCustomTestResponses(CustomTestsResponses CustomTestResponses); 
	
	public void deleteCustomTestResponses(int id);
		
}
