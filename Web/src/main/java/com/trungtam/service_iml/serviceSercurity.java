package com.trungtam.service_iml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trungtam.dao.daohello;
import com.trungtam.modelEntity.User;

@Service
@Transactional
public class serviceSercurity implements UserDetailsService {

	@Autowired
	daohello helo;
	
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user= helo.getUserByUserName(arg0);
		if(user==null) {
			throw new UsernameNotFoundException("no user");
		}
		
		List<SimpleGrantedAuthority> authorities=new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(user.getUsername()));
		
		UserDetails details=new org.springframework.security.core.userdetails.User(user.getTen(), user.getPasswork(), true, true, true, true, authorities);
		return details;
	}

}
