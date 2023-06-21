package com.saadne.firstSpringApp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoRepository todoRepository;

	TodoControllerJpa( TodoRepository todoRepository){
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("todo-list")
	public String getTodos(ModelMap model){
		String username = getLoggedInUsername(model);
		List<Todo> todos = todoRepository.findByUsername(username);
		model.addAttribute("todos", todos);
		return "todo-list";
	}

	@RequestMapping(value="add-todo",method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model){
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
		model.put("todo", todo);
		return "add-todo";
	}

	@RequestMapping(value="add-todo",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model,@Valid Todo todo, BindingResult result){
		String username = getLoggedInUsername(model);
		todo.setUsername(username);
		if(result.hasErrors()) {
			return "add-todo";
		}
		todoRepository.save(todo);
		return "redirect:todo-list";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id){
		todoRepository.deleteById(id);
		return "redirect:todo-list";
	}

	@RequestMapping("update-todo")
	public String updateTodo(@RequestParam int id ,ModelMap model){
		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo",todo);
		return "add-todo";
	}

	@RequestMapping(value="update-todo",method=RequestMethod.POST)
	public String addUpdatedTodo(ModelMap model,@Valid Todo todo, BindingResult result){
		String username = getLoggedInUsername(model);
		if(result.hasErrors()) {
			return "add-todo";
		}
		todo.setUsername(username);
		todoRepository.save(todo);
		return "redirect:todo-list";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication =
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
