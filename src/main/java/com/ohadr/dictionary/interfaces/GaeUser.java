package com.ohadr.dictionary.interfaces;

import java.io.Serializable;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public interface GaeUser extends Serializable
{

	public String getUserId();

	public Object getEmail();

	public Object getNickname();

	public Object getForename();

	public Object getSurname();

	public Object isEnabled();

	public Collection<? extends GrantedAuthority> getAuthorities();
}
