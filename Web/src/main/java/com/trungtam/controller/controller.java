package com.trungtam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.trungtam.model.UserDTO;
import com.trungtam.service.serviceHello2;

@CrossOrigin(origins="http://localhost:4200")
@Controller
public class controller {
	@Autowired
	serviceHello2 svhello2;

	public static List<UserDTO> hello2s = new ArrayList<>();
	
	
	
	@GetMapping(value = "/login")
	public  String login_G (@RequestParam(name="e",required=false) String erro,HttpServletRequest request) {
		if(erro!=null) {
			request.setAttribute("e", erro);
		}
		return "login";
	}

	
	@GetMapping(value = "/trungtam")
	public String name(HttpServletRequest request) {
		hello2s = svhello2.getAll();
		request.setAttribute("listUser", hello2s);
		return "chao";
	}

	@GetMapping(value = "/listjson")
	public @ResponseBody List<UserDTO> json() {
		return svhello2.getAll();
	}
	@GetMapping(value = "/listjson1")
	public @ResponseBody UserDTO json1() {
		UserDTO helo =new  UserDTO(1, "ten", "tuoi");
		
		return helo;
	}

	@GetMapping(value = "/addUser")
	public String addUser_G(Model model) {
		UserDTO userDTO = new UserDTO(1, "Lam", "20");
		model.addAttribute("user", userDTO);
		return "admin/addUser";
	}

	// @PostMapping(value = "/trungtam")
	// public String addUser_P(HttpServletRequest request, @RequestParam(name =
	// "ten", required = true) String name,
	// @RequestParam(name = "tuoi", required = true) String age) {
	//
	//
	// hello2s = svhello2.getAll();
	// UserDTO userDTO = new UserDTO(hello2s.size()+1, name, age);
	// svhello2.add(userDTO);
	// return "redirect:/trungtam";
	// }
	
	
	
	@PostMapping(value = "/trungtam")
	public String addUser_P(HttpServletRequest request, @ModelAttribute(name = "user") UserDTO userDTO) {
		hello2s = svhello2.getAll();/////????
		userDTO.setId(hello2s.size() + 1);
		svhello2.add(userDTO);
		return "redirect:/trungtam";
	}

	@GetMapping(value = "/detele/{id}")
	public String deteleUser(@PathVariable(name = "id") String id, HttpServletRequest request) {
		int i = Integer.parseInt(id);
		svhello2.detele(i);
		return "redirect:/trungtam";
	}
}
