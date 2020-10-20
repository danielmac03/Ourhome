package com.ourhome.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ourhome.dao.IHomesDAO;
import com.ourhome.dto.Homes;

@Service
public class HomesServiceImpl implements IHomesService{

	@Autowired
	IHomesDAO iHomesDAO;
	
	@Override
	public List<Homes> listHomes() {
		return iHomesDAO.findAll();
	}

	@Override
	public Homes saveHomes(Homes home) {
		return iHomesDAO.save(home);
	}

	@Override
	public Homes getHome(int id) {
		return iHomesDAO.findById(id).get();
	}

	@Override
	public List<Homes> getHomesByCity(String city){
		return iHomesDAO.findByCity(city);
	}

	@Override
	public Homes updateHome(Homes home) {
		return iHomesDAO.save(home);
	}

	@Override
	public void deleteHome(int id) {
		iHomesDAO.deleteById(id);
	}

}
