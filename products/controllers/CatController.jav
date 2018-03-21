package com.jihfan.products.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jihfan.products.models.Category;
import com.jihfan.products.models.Product;
import com.jihfan.products.services.CatService;
import com.jihfan.products.services.ProductService;

@Controller
@RequestMapping("/categories")				//Reduces the need to repeat writing this

public class CatController {
	private CatService cS;				//allows us to use all the CRUD methods that link to the DB
	private ProductService pS;
	
	public CatController(CatService cS, ProductService pS) {
		this.cS = cS;
		this.pS = pS;
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
		
		@RequestMapping("/{id}")
		public String showProduct(@PathVariable("id") Long id, Model model) {			
			Optional<Category> c = cS.find(id);
			
			if(!c.isPresent()){
				return "redirect:/categories/new";
			}
			Category category = c.get();
//			System.out.println(p);
			
			model.addAttribute("products", pS.allProducts());
			model.addAttribute("category", category);
			
			return "showcat";
		}
		
		@PostMapping("/{cat_id}/join")
		public String join(@RequestParam("prod_id") Long prod_id, @PathVariable("cat_id") Long cat_id) {
			
		Category category = cS.find(cat_id).get();		// category you added to
		List<Product> products = category.getProducts();	// get all the products that belong to the specific category
		Product product = pS.find(prod_id).get();		// look for the product (drop down menu) that we selected
		products.add(product);					// add selected product to specific categories's list of products
		category.setProducts(products);				// set categories to include new selection
		
		cS.create(category);					// save
	
		return "redirect:/categories/"+cat_id;
		}
		
//		public String allCats(Model model) {
//			List<Category> categories = cS.allCat();	//two lines 
//			model.addAttribute("categories", categories);		
//			model.addAttribute("categories", cS.allCat());	//one line
//			return "categories";
//			}
		

}
