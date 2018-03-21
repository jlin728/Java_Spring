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
import com.jihfan.products.repositories.ProductRepo;
import com.jihfan.products.services.CatService;
import com.jihfan.products.services.ProductService;

@Controller
@RequestMapping("/products")

public class ProductController {
	private ProductService pS;
	private CatService cS;
	
	public ProductController(ProductService pS, CatService cS) {
		this.pS = pS;
		this.cS = cS;
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
		
		@RequestMapping("/{id}")
		public String showProduct(@PathVariable("id") Long id, Model model) {			
			Optional<Product> p = pS.find(id);
			
			if(!p.isPresent()){
				return "redirect:/products/new";
			}
			Product product = p.get();
			
			model.addAttribute("categories", cS.allCat());
			model.addAttribute("product", product);
			
			return "showproduct";
		}
		
		@PostMapping("/{prod_id}/join")
		public String join(@RequestParam("cat_id") Long cat_id, @PathVariable("prod_id") Long prod_id) {
			
		Product product = pS.find(prod_id).get();
		List<Category> categories = product.getCategories();
		Category category = cS.find(cat_id).get();
		categories.add(category);
		product.setCategories(categories);
	
		pS.create(product);									
	
		return "redirect:/products/"+prod_id;
			
		}
		
}
