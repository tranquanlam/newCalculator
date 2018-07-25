package com.trungtam.dao;

import java.util.List;

import com.trungtam.modelEntity.User;

public interface daohello {
		public List<User> getAll();
		public void add(User user);
		public void detele(User user);
		public void update(User user);
		public User getID(int id);
		public User getUserByUserName(String username);
}
