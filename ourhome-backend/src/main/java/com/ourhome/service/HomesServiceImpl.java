package com.ourhome.service;

import com.ourhome.dao.IHomesDAO;
import com.ourhome.dto.Homes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomesServiceImpl implements IHomesService{

	@Autowired
	IHomesDAO iHomesDAO;
	
	@Override
	public List<Homes> listHomes() {
		return iHomesDAO.findAll();
	}

	@Override
	public List<Homes> listActiveHomes() {
		return iHomesDAO.findByActive(true);
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
	public List<Homes> getHomesByUser(int userId) {
		return iHomesDAO.findByUser_id(userId);
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
