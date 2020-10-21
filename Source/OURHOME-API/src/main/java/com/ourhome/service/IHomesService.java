package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Homes;

public interface IHomesService {

	public List<Homes> listHomes(); 
	
	public Homes saveHomes(Homes home);	
	
	public Homes getHome(int id);

	public Homes getHomeByUser(int userId);

	public List<Homes> getHomesByCity(String city);
	
	public Homes updateHome(Homes home); 
	
	public void deleteHome(int id);
	
}
