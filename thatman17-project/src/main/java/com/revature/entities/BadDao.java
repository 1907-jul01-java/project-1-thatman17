package com.revature.entities;

import java.util.List;

public interface BadDao<E> {
	
	List<E> getEmployee(String username);

}
