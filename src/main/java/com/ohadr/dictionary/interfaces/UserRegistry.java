package com.ohadr.dictionary.interfaces;

public interface UserRegistry 
{
	GaeUser findUser(String userId);
	void registerUser(GaeUser newUser);
	void removeUser(String userId);
}