package com.saadne.firstSpringApp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model){
		String username = (String)model.get("name");
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "add-todo";
	}
	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result){
		String username = (String)model.get("name");
		if(result.hasErrors()) {
			return "add-todo";
		}
		todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:todo-list";
	}
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoService.deleteById(id);
		return "redirect:todo-list";
	}
	@RequestMapping("update-todo")
	public String updateTodo(@RequestParam int id ,ModelMap model){
		Todo todo = todoService.findById(id);
		model.addAttribute("todo",todo);
		return "add-todo";
	}
	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String addUpdatedTodo(ModelMap model,@Valid Todo todo, BindingResult result){
		String username = (String)model.get("name");
		if(result.hasErrors()) {
			return "add-todo";
		}
		todo.setName(username);
		todoService.updateTodo(todo);
		return "redirect:todo-list";
	}
}
