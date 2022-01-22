package com.me.rentacar.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.rentacar.pojo.User;

public class UserDAO extends MainDAO {
	
	public UserDAO() {
	}

public User getUser(String username) throws Exception {
	try {
		begin();
		System.out.println(username);
		Query q = getSession().createQuery("from User where username = :username");
		q.setString("username", username);
		User user = (User) q.uniqueResult();
		System.out.println(user.getFirstname());
		commit();
		return user;
	} catch (HibernateException e) {
		rollback();
		throw new Exception("Could not get user " + username, e);
	}
}

public User AddNewUser(String username, String password, String userrole, String emailId, String firstname, String lastname,
		String phonenumber, String address, int age) throws Exception {
	try {
		begin();
		System.out.println("inside DAO");

		User user = new User(username, password, userrole);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setPhonenumber(phonenumber);
		user.setAddress(address);
		user.setEmailId(emailId);
		user.setAge(age);

		getSession().save(user);

		commit();
		return user;
	} catch (HibernateException e) {
		rollback();
		throw new Exception("Exception while creating user: " + e.getMessage());
	}
}

public void delete(User user) throws Exception {
	try {
		begin();
		getSession().delete(user);
		commit();
	} catch (HibernateException e) {
		rollback();
		throw new Exception("Could not delete user " + user.getUsername(), e);
	}
}

public User getUserbyID(int userid) throws Exception {
	try {
		begin();
		System.out.println(userid);
		Query q = getSession().createQuery("from Person where userid = :userid");
		q.setInteger("userid", userid);
		User user = (User) q.uniqueResult();
		System.out.println(user.getFirstname());
		commit();
		return user;
	} catch (HibernateException e) {
		rollback();
		throw new Exception("Could not get user " + userid, e);
	}
}

}
