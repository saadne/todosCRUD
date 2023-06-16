package com.saadne.firstSpringApp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	
	private static List<Todo> todos = new ArrayList<Todo>();
	
	static  {
		todos.add(new Todo(1,"saadne", "Learn Docker", 
				LocalDate.now().plusYears(1),false));
		todos.add(new Todo(2,"saadne", "Learn Angular", 
				LocalDate.now().plusYears(2),false));
		todos.add(new Todo(3,"saadne", "Learn Spring", 
				LocalDate.now().plusYears(1),true));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
}
