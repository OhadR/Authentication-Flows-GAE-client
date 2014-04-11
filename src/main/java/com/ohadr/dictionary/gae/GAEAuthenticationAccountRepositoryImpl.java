package com.ohadr.dictionary.gae;

import java.util.Date;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.appengine.api.datastore.*;
import com.ohadr.auth_flows.core.AbstractAuthenticationAccountRepository;
import com.ohadr.auth_flows.interfaces.AuthenticationUser;
import com.ohadr.auth_flows.mocks.InMemoryAuthenticationUserImpl;


public class GAEAuthenticationAccountRepositoryImpl extends
		AbstractAuthenticationAccountRepository 
{
	private static final String PASSWORD_PROP_NAME = "password";
	private static final String LOGIN_ATTEMPTS_LEFT_PROP_NAME = "loginAttemptsLeft";
	private static final String ENABLED_PROP_NAME = "enabled";
	private static final String LAST_PSWD_CHANGE_DATE_PROP_NAME = "lastPasswordChangeDate";

	private static final String USER_DB_KIND = "User";


	private static Logger log = Logger.getLogger(GAEAuthenticationAccountRepositoryImpl.class);

	private DatastoreService datastore;
	
	public GAEAuthenticationAccountRepositoryImpl()
	{
		datastore = DatastoreServiceFactory.getDatastoreService();
	}

	@Override
	public void setDisabled(String email) 
	{
		setEnabledFlag(email, false);
	}

	@Override
	public void setEnabled(String email) 
	{
		setEnabledFlag(email, true);
	}

	@Override
	public void setPassword(String username, String newEncodedPassword)
	{
		changePassword(username, newEncodedPassword);
	}

	@Override
	public void createUser(UserDetails user) 
	{
		AuthenticationUser authUser = (AuthenticationUser) user;

		Entity dbUser = new Entity(USER_DB_KIND, user.getUsername());		//the username is the key

		dbUser.setProperty("username", user.getUsername());
		dbUser.setProperty(PASSWORD_PROP_NAME, user.getPassword());
		dbUser.setProperty(ENABLED_PROP_NAME, user.isEnabled());
		dbUser.setProperty(LOGIN_ATTEMPTS_LEFT_PROP_NAME, authUser.getLoginAttemptsLeft());
		dbUser.setProperty(LAST_PSWD_CHANGE_DATE_PROP_NAME, new Date( System.currentTimeMillis()) );

		datastore.put(dbUser);	
	}

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
			log.info("got entity of " + username + ": " + entity);
		} 
		catch (EntityNotFoundException e) 
		{
			log.error("entity of " + username + " not found");
//			throw new UsernameNotFoundException(e.getMessage(), e);
			return null;
		}
		
		boolean isEnabled = false;
		Object isEnabledObj = entity.getProperty(ENABLED_PROP_NAME);
		if( null != isEnabledObj )
		{
			isEnabled = (Boolean)isEnabledObj;
		}
		int loginAttemptsLeft = 0;
		Object loginAttemptsLeftObj = entity.getProperty(LOGIN_ATTEMPTS_LEFT_PROP_NAME);
		if( null != loginAttemptsLeftObj )
		{
			loginAttemptsLeft = new Integer(loginAttemptsLeftObj.toString());
		}

		return new InMemoryAuthenticationUserImpl(
						username, 
						(String)entity.getProperty(PASSWORD_PROP_NAME),
						isEnabled,
						loginAttemptsLeft,
						(Date)entity.getProperty("PasswordLastChangeDate"));
		
	}

	@Override
	protected void setEnabledFlag(String username, boolean flag) 
	{
		Key userKey = KeyFactory.createKey(USER_DB_KIND, username);
		Entity entity;
		try 
		{
			entity = datastore.get(userKey);
			log.debug("got entity of " + username + ": " + entity);
		} 
		catch (EntityNotFoundException e) 
		{
			log.error("entity of " + username + " not found");
			throw new NoSuchElementException(e.getMessage());
		}
		
		entity.setProperty(ENABLED_PROP_NAME, flag);				
		datastore.put(entity);	
	}

	@Override
	protected void updateLoginAttemptsCounter(String username, int attempts) 
	{
		Key userKey = KeyFactory.createKey(USER_DB_KIND, username);
		Entity entity;
		try 
		{
			entity = datastore.get(userKey);
			log.debug("got entity of " + username + ": " + entity);
		} 
		catch (EntityNotFoundException e) 
		{
			log.error("entity of " + username + " not found");
			throw new NoSuchElementException(e.getMessage());
		}
		
		entity.setProperty(LOGIN_ATTEMPTS_LEFT_PROP_NAME, attempts);				
		datastore.put(entity);	
	}

	@Override
	public void changePassword(String username, String newEncodedPassword) 
	{
		Key userKey = KeyFactory.createKey(USER_DB_KIND, username);
		Entity entity;
		try 
		{
			entity = datastore.get(userKey);
			log.debug("got entity of " + username + ": " + entity);
		} 
		catch (EntityNotFoundException e) 
		{
			log.error("entity of " + username + " not found");
			throw new NoSuchElementException(e.getMessage());
		}
		
		entity.setProperty(LAST_PSWD_CHANGE_DATE_PROP_NAME, new Date( System.currentTimeMillis()));
		entity.setProperty(PASSWORD_PROP_NAME, newEncodedPassword);
		datastore.put(entity);	
	}

}
