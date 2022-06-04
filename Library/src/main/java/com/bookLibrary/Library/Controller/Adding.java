package com.bookLibrary.Library.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookLibrary.Library.Model.Book;
import com.bookLibrary.Library.Service.BookServices;

@Controller
public class Adding {
	@Autowired
	BookServices bs;

	@GetMapping("/addBook")
	public String addBookForm() {
		return "adding";
	}

	@PostMapping("/addProcess")
	public String saveBook(@RequestParam String name, String author, boolean bool, Model model) {
		Book book = new Book();
		book.setName(name);
		book.setAuthor(author);
		book.setAvalability(bool);
		bs.addBook(book);
		model.addAttribute("state", "Book Added Successfully!");
		return "adding";
	}

}
