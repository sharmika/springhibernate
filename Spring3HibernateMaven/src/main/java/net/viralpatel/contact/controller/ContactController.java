package net.viralpatel.contact.controller;

import java.util.Map;
import net.viralpatel.contact.form.Contact;
import net.viralpatel.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Class for taking the Inputs from jsp's and returns contact details
 * 
 * @author Bramhini
 * @version 1.0
 */
@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;

	
	/*
	 * this method is used for displaying contact page
	 */
	@RequestMapping("/welcome")
	public String homePage(ModelMap model) {

		model.addAttribute("contact",new Contact());

		return "contact";
	}

	/*
	 * this method is used for retrieving contact details
	 */
	@RequestMapping("/index")
	public String listContacts(Map<String, Object> map) {

		map.put("contact", new Contact());
		map.put("contactList", contactService.listContact());

		return "contact";
	}

	/*
	 * this method is for adding contact details into database
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact") Contact contact,
			BindingResult result) {

		contactService.addContact(contact);

		return "redirect:/index";
	}

	/*
	 * this method is for deleting contact based on contactId
	 */
	@RequestMapping("/delete/{contactId}")
	public String deleteContact(@PathVariable("contactId") Integer contactId) {

		contactService.removeContact(contactId);

		return "redirect:/index";
	}
}
