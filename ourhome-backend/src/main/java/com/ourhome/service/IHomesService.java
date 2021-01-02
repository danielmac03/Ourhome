package com.ourhome.service;

import com.ourhome.dto.Homes;

import java.util.List;

public interface IHomesService {

	List<Homes> listHomes();

	List<Homes> listActiveHomes();

	Homes saveHomes(Homes home);

	Homes getHome(int id);

	List<Homes> getHomesByUser(int userId);

	Homes updateHome(Homes home);

	void deleteHome(int id);

}
