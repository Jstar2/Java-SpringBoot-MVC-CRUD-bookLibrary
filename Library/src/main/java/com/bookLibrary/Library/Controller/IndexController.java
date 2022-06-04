package com.bookLibrary.Library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bookLibrary.Library.Model.Book;
import com.bookLibrary.Library.Service.BookServices;

@Controller
public class IndexController {
	@Autowired
	BookServices bs;
	Book book;


	@RequestMapping(value = { "/", "home", "index", "" })
	public String index(Model model) {
		model.addAttribute("book", bs.getBooks());	
		model.addAttribute("total", bs.totalBooks());
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") long id, Model model) {
		model.addAttribute("book", bs.getBooks());
		model.addAttribute("total", bs.totalBooks());
		bs.removeBook(id);
		return "redirect:/index";
	}
}