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
public class updateBook {
	@Autowired
	BookServices bs;

	@GetMapping("/updateBook")
	public String updatBook() {
		return "update";
	}

	@PostMapping("/update")
	public String updateMethod(@RequestParam long id, String name, String author, boolean bool, Model model) {
		try {
			Book boo = new Book();
			boo = bs.findById(id);
			boo.setName(name);
			boo.setAuthor(author);
			boo.setAvalability(bool);
			bs.addBook(boo);
			model.addAttribute("status", "Update Successfull");
			return "update";
		} catch (Exception e) {
			model.addAttribute("status", "Invalid book ID");
			return "update";
		}
	}
}