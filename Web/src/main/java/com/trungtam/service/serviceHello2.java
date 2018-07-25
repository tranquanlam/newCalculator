package com.trungtam.service;

import java.util.List;

import com.trungtam.model.UserDTO;

public interface serviceHello2 {
	
	public List<UserDTO> getAll();
	public void add(UserDTO userDTO);
	public void detele(int id);
	public void update(UserDTO userDTO);
}
