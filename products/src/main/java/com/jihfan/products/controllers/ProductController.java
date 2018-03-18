package com.jihfan.products.controllers;

import java.util.List;

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
@RequestMapping("/products")				//Reduces the need to repeat writing this

public class ProductController {
	private ProductService pS;					//allows us to use all the CRUD methods that link to the DB
	private CatService cS;
	
	public ProductController(ProductService pS) {
		this.pS = pS;
	}
// -------------------------------------------------------------------------------
		@RequestMapping("/new")
		public String product(Model model) {
			model.addAttribute("product", new Product());
			return "products";
		}
//		Alternate way to build a new product
//		public String newProduct(@ModelAttribute("product") Product product) {
//			return "newProduct";
//		}
// --------------------------------------------------------------------------------
		
		@PostMapping("/new")
		public String create( @Valid @ModelAttribute("product") Product product, BindingResult res ) {
			if(res.hasErrors()) {
				return "products";
			}
			
			pS.create(product);
			return "redirect:/products/new";
		}
		
		
		
//		public String allCats(Model model) {
//			List<Category> categories = cS.allCat();			//two lines 
//			model.addAttribute("categories", categories);		
//			model.addAttribute("categories", cS.allCat());		//one line
//			return "categories";
//			}
		
		@RequestMapping ("{id}")
		public String showProduct(@PathVariable("id") Long id, Model model) {
			model.addAttribute("categories", cS.allCat());
			model.addAttribute("product", pS.find(id));
			return "showproduct";
		}
		
		@PostMapping("{prod_id}/join")
		public String join(@RequestParam("cat_id") Long cat_id, @PathVariable("prod_id") Long prod_id) {
			
		Product product = pS.find(prod_id);							// product you added to
		List<Category> categories = product.getCategories();		// get all the categories that belong to the specific product
		Category category = cS.find(cat_id);						// look for the category (drop down menu) that we selected
		categories.add(category);									// add selected category to specific product's list of categories
		product.setCategories(categories);							// set categories to include new selection
		
		pS.create(product);											// save
	
		return "redirect:/products/"+prod_id;
			
		}
		
		

}
