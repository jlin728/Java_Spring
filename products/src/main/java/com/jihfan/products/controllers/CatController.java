package com.jihfan.products.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jihfan.products.models.Category;
import com.jihfan.products.services.CatService;

@Controller
@RequestMapping("/categories")				//Reduces the need to repeat writing this

public class CatController {
	private CatService cS;					//allows us to use all the CRUD methods that link to the DB
	
	public CatController(CatService cS) {
		this.cS = cS;
	}
		@RequestMapping("/new")
		public String categories(Model model) {
			model.addAttribute("category", new Category());
			return "categories";
		}
		
		@PostMapping("/new")
		public String create( @Valid @ModelAttribute("category") Category cat, BindingResult res ) {
			if(res.hasErrors()) {
				return "categories";
			}
			
			cS.create(cat);
			return "redirect:/categories/new";
		}
		
		
		
//		public String allCats(Model model) {
//			List<Category> categories = cS.allCat();			//two lines 
//			model.addAttribute("categories", categories);		
//			model.addAttribute("categories", cS.allCat());		//one line
//			return "categories";
//			}
		

}
