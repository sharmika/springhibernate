package net.viralpatel.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.viralpatel.contact.dao.ContactDAO;
import net.viralpatel.contact.form.Contact;

/**
 * Class for calling dao layer methods
 * 
 * @author Bramhini
 * @version 1.0
 */
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO contactDAO;

	/*
	 * method for calling inserting contact details into database (non-Javadoc)
	 * 
	 * @see
	 * net.viralpatel.contact.service.ContactService#addContact(net.viralpatel
	 * .contact.form.Contact)
	 */
	@Transactional
	public void addContact(Contact contact) {
		contactDAO.addContact(contact);
	}

	/*
	 * method for retrieving all contacts (non-Javadoc)
	 * 
	 * @see net.viralpatel.contact.service.ContactService#listContact()
	 */
	@Transactional
	public List<Contact> listContact() {

		return contactDAO.listContact();
	}

	/*
	 * method for deleting contact based on contactId(non-Javadoc)
	 * 
	 * @see
	 * net.viralpatel.contact.service.ContactService#removeContact(java.lang
	 * .Integer)
	 * 
	 * @param id passing contactId to remove contact
	 */
	@Transactional
	public void removeContact(Integer id) {
		contactDAO.removeContact(id);
	}
}
