package com.saadne.firstSpringApp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	TodoController(TodoService todoService){
		this.todoService = todoService;
	}

	@RequestMapping("todo-list")
	public String getTodos(ModelMap model){
		List<Todo> todos = todoService.findByUsername("saadne");
		model.put("todos", todos);
		return "todo-list";
	}
}
