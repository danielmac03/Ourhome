package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.CustomTests;

public interface ICustomTestsService {

	public List<CustomTests> listCustomTests(); 
	
	public CustomTests saveCustomTest(CustomTests customTest);	
	
	public CustomTests searchCustomTest(int id);

	public CustomTests searchCustomTestByUser(int user_id);

	public CustomTests updateCustomTest(CustomTests customTest); 
	
	public void deleteCustomTest(int id);
	
}
