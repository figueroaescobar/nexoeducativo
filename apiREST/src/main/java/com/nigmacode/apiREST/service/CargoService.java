package com.nigmacode.apiREST.service;

import java.util.List;

import com.nigmacode.apiREST.entity.cargo;;

public interface CargoService {
	public List<cargo> findAll();
	public cargo findById(int id);
	public void save (cargo Carg);
	public void deleteById(int id);
}
