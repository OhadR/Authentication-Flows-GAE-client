package com.ohadr.dictionary.gae;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.appengine.api.datastore.*;
import com.ohadr.auth_flows.core.AbstractAuthenticationAccountRepository;
import com.ohadr.auth_flows.mocks.InMemoryAuthenticationUserImpl;


public class GAEAuthenticationAccountRepositoryImpl extends
		AbstractAuthenticationAccountRepository 
{
	private static final String USER_DB_KIND = "User";

	private static Logger log = Logger.getLogger(GAEAuthenticationAccountRepositoryImpl.class);

	private DatastoreService datastore;
	
	public GAEAuthenticationAccountRepositoryImpl()
	{
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	@Override
	public void setDisabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPassword(String arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(UserDetails user) 
	{
		Entity dbUser = new Entity(USER_DB_KIND, user.getUsername());		//the username is the key

		dbUser.setProperty("username", user.getUsername());
		dbUser.setProperty("password", user.getPassword());
		dbUser.setProperty("enabled", user.isEnabled());

		datastore.put(dbUser);	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) 
	{
		Key userKey = KeyFactory.createKey(USER_DB_KIND, username);
		datastore.delete(userKey);
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	 //TODO: be Spring-compatible, and use UsernameNotFoundException, and never return null
	@Override
	public UserDetails loadUserByUsername(String username)
//			throws UsernameNotFoundException
	{
		Key userKey = KeyFactory.createKey(USER_DB_KIND, username);
		Entity entity;
		try 
		{
			entity = datastore.get(userKey);
			log.info("GAEAuthenticationAccountRepositoryImpl: got entity of " + username + ": " + entity);
		} 
		catch (EntityNotFoundException e) 
		{
			log.error("GAEAuthenticationAccountRepositoryImpl: entity of " + username + " not found");
//			throw new UsernameNotFoundException(e.getMessage(), e);
			return null;
		}
		
		log.info("GAEAuthenticationAccountRepositoryImpl: got entity of " + username + ": " 
				+ entity.getProperty("password") + entity.getProperty("isEnabled") 
				+ entity.getProperty("LoginAttemptsLeft"));
		
		return new InMemoryAuthenticationUserImpl(
						username, 
						(String)entity.getProperty("password"),
						(Boolean)entity.getProperty("isEnabled"),
						(Integer)entity.getProperty("LoginAttemptsLeft"),
						(Date)entity.getProperty("PasswordLastChangeDate"));
		
	}

	@Override
	protected void setEnabledFlag(String arg0, boolean arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void updateLoginAttemptsCounter(String arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

}
