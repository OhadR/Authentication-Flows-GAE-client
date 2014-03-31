package com.ohadr.dictionary.jdbc;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

import com.ohadr.dictionary.gae.AppRole;
import com.ohadr.dictionary.interfaces.GaeUser;

public class GaeUserImpl implements GaeUser 
{
	private String userId;
	private String email;
	private String nickname;
	private String forename;
	private String surname;
	private Set<AppRole> authorities;
	private boolean enabled;

	public GaeUserImpl(String name, String property, String property2,
			String property3, String property4, Set<AppRole> roles,
			Boolean property5) 
	{

	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getNickname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getForename() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getSurname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object isEnabled() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
