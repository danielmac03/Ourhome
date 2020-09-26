package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IHomesDAO;
import com.ourhome.dto.Homes;

@Service
public class HomesServiceImpl implements IHomesService{

	@Autowired
	IHomesDAO iCasasDAO;
	
	@Override
	public List<Homes> listHomes() {
		return iCasasDAO.findAll();
	}

	@Override
	public Homes saveHomes(Homes home) {
		return iCasasDAO.save(home);
	}

	@Override
	public Homes searchHome(int id) {
		return iCasasDAO.findById(id).get();
	}

	@Override
	public Homes updateHome(Homes home) {
		return iCasasDAO.save(home);
	}

	@Override
	public void deleteHome(int id) {
		iCasasDAO.deleteById(id);
	}

}
