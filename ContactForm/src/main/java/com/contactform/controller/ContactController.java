package com.contactform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.contactform.entity.Contact;
import com.contactform.repository.ContactRepository;

@Controller
public class ContactController {
	@Autowired
	private ContactRepository contactRepository;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("contact", new Contact());
		return "index";
	}

	@PostMapping("/submit")
	public String submitForm(@ModelAttribute Contact contact) {
		contactRepository.save(contact);
		return "redirect:/";
	}

}
