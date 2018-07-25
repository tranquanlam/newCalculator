package com.trungtam.service_iml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trungtam.dao.daohello;
import com.trungtam.model.UserDTO;
import com.trungtam.modelEntity.User;
import com.trungtam.service.serviceHello2;

@Service
public class serviceHello2_iml implements serviceHello2 {

	@Autowired
	daohello dao;

	@Override
	public List<UserDTO> getAll() {
		List<User> list = dao.getAll();
		List<UserDTO> listdto = new ArrayList<>();

		for (User user : list) {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setTen(user.getTen());
			dto.setTuoi(user.getTuoi());
			listdto.add(dto);
		}

		return listdto;
	}

	@Override
	public void add(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId(userDTO.getId());
		user.setTen(userDTO.getTen());
		user.setTuoi(userDTO.getTuoi());
		dao.add(user);
	}

	@Override
	public void detele(int id) {
		// TODO Auto-generated method stub
		User user = dao.getID(id);
		if (user != null)
			dao.detele(user);
	}

	@Override
	public void update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = dao.getID(userDTO.getId());
		
		if(user !=null) {
			user.setTen(userDTO.getTen());
			user.setTuoi(userDTO.getTuoi());
			
			dao.update(user);
		}
		
	}

	// @Autowired
	// daohello hello;
	//
	// @Override
	// public List<UserDTO> getAll() {
	// return hello.getAll();
	// }
	//
	// @Override
	// public void add(UserDTO hello2) {
	// hello.add(hello2);
	// }
	//
	// @Override
	// public void detele(int id) {
	// hello.detele(id);
	// }
	//
	// @Override
	// public void update(int id,String ten,String tuoi) {
	// hello.update(id, ten, tuoi);
	// }

}
