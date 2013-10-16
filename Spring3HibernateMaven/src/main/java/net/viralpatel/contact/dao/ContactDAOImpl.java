package net.viralpatel.contact.dao;

import java.util.List;

import net.viralpatel.contact.form.Contact;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Class for communicating with database
 * 
 * @author bramhini
 * @version 1.0
 */
@Repository
public class ContactDAOImpl implements ContactDAO {

	@Autowired
	private SessionFactory sessionFactory;

	/*
	 * method for inserting contact details into database (non-Javadoc)
	 * 
	 * @see
	 * net.viralpatel.contact.dao.ContactDAO#addContact(net.viralpatel.contact
	 * .form.Contact)
	 */
	public void addContact(Contact contact) {
		sessionFactory.getCurrentSession().save(contact);
	}

	/*
	 * method for retrieving all contacts (non-Javadoc)
	 * 
	 * @see net.viralpatel.contact.dao.ContactDAO#listContact()
	 * 
	 * @return user contacts
	 */
	@SuppressWarnings("unchecked")
	public List<Contact> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Contact")
				.list();
	}

	/*
	 * method for removing contact based on contactId (non-Javadoc)
	 * 
	 * @see
	 * net.viralpatel.contact.dao.ContactDAO#removeContact(java.lang.Integer)
	 * 
	 * @ Param id passing user unique contactId
	 */
	public void removeContact(Integer id) {
		Contact contact = (Contact) sessionFactory.getCurrentSession().load(
				Contact.class, id);
		if (null != contact) {
			sessionFactory.getCurrentSession().delete(contact);
		}

	}
}
