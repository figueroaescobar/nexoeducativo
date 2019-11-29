package com.nigmacode.apiREST.dao;

import java.util.List;

import com.nigmacode.apiREST.entity.cargo;;

public interface CargoDAO {
	
	public List<cargo> findAll();
	public cargo findById(int idCargo);
	public void save(cargo Cargo);
	public void deleteById(int idCargo);
}
