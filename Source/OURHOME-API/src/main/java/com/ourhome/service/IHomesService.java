package com.ourhome.service;

import java.util.List;
import com.ourhome.dto.Homes;

public interface IHomesService {

	public List<Homes> listHomes(); 
	
	public Homes saveHomes(Homes home);	
	
	public Homes searchHome(int id);

	public List<Homes> searchHomeByCity(String city);
	
	public Homes updateHome(Homes home); 
	
	public void deleteHome(int id);
	
}
