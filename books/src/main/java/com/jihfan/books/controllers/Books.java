package com.jihfan.books.controllers;

import java.util.List; // java.awt.List throws an error "The type List is not generic; it cannot be parameterized with arguments <Book>"

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jihfan.books.models.Book;
import com.jihfan.books.services.BookService;

@Controller
public class Books {

	private final BookService bookService; // "FINAL" tells us that we are going to be using a bookService and that it will not
											// be changing. We set this in the constructor. If we have multiple constructors use @Autowired

	public Books(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/books")
	public String books(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books/{index}")
    public String findBookByIndex(Model model, @PathVariable("index") int index) {		// set conditional for out of bounds numbers in BookService.java
        Book book = bookService.findBookByIndex(index);
        model.addAttribute("book", book);
        return "showBook.jsp";
	}
	
	@RequestMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {			//Used here to instantiate new Book type and bind to view model. This is why we need an empty model Book. 
        return "newBook.jsp";
    }
	
	@PostMapping("/books/new")
    public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {		//@Valid has to come before BindingResults
        if (result.hasErrors()) {
            return "newBook.jsp";
        }else{
            bookService.addBook(book);
            return "redirect:/books";
        }
    }
	
	@RequestMapping("/books/edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        Book book = bookService.findBookByIndex(id);			//grab book by id
        if (book != null){										//if it exists
            model.addAttribute("book", book);					//add changes
            return "editBook.jsp";								//return here
        }else{													//if does not exist
            return "redirect:/books";							// redirect here
        }
    }
	
	@PostMapping("/books/edit/{id}")
    public String updateBook(@PathVariable("id") int id, @Valid @ModelAttribute("book") Book book, BindingResult result) {		//Corresponds to Services updateBook
        if (result.hasErrors()) {
            return "editBook.jsp";
        }else{
            bookService.updateBook(id, book);
            return "redirect:/books";
        }
    }
	
	@RequestMapping(value="/books/delete/{id}")
    public String destroyBook(@PathVariable("id") int id) {
        bookService.destroyBook(id);
        return "redirect:/books";
    }
	
}