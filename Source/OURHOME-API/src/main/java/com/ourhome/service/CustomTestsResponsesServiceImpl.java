package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.ICustomTestsResponsesDAO;
import com.ourhome.dto.CustomTestsResponses;

@Service
public class CustomTestsResponsesServiceImpl implements ICustomTestsResponsesService{
	
	@Autowired
	ICustomTestsResponsesDAO iCustomTestsResponsesDAO;

	@Override
	public List<CustomTestsResponses> listCustomTestsResponses() {
		return iCustomTestsResponsesDAO.findAll();
	}

	@Override
	public CustomTestsResponses saveCustomTestResponses(CustomTestsResponses customTestResponses) {
		return iCustomTestsResponsesDAO.save(customTestResponses);
	}

	@Override
	public CustomTestsResponses searchCustomTestResponses(int id) {
		return iCustomTestsResponsesDAO.findById(id).get();
	}

	@Override
	public CustomTestsResponses updateCustomTestResponses(CustomTestsResponses customTestResponses) {
		return iCustomTestsResponsesDAO.save(customTestResponses);
	}

	@Override
	public void deleteCustomTestResponses(int id) {
		iCustomTestsResponsesDAO.deleteById(id);
	}
	
}