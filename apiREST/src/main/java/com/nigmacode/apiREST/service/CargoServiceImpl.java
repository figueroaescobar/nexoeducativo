package com.nigmacode.apiREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nigmacode.apiREST.dao.CargoDAO;
import com.nigmacode.apiREST.entity.cargo;;

@Service
public class CargoServiceImpl implements CargoService{
 
	@Autowired
	private CargoDAO cargoDAO;
	
	@Override
	public List<cargo> findAll(){
		List<cargo> listCargos = cargoDAO.findAll();
		return listCargos;
	}
	
	@Override
	public cargo findById(int idCargo) {
		cargo Cargo = cargoDAO.findById(idCargo);
		return Cargo;
	}
	
	@Override
	public void save(cargo Cargo) {
		cargoDAO.save(Cargo);
	}
	
	@Override
	public void deleteById(int idCargo) {
		cargoDAO.deleteById(idCargo);
	}
 
}
