package edu.swe425.mum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.swe425.mum.model.Product;
import edu.swe425.mum.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public ModelAndView getProductsPage() {
		ModelAndView modelView = new ModelAndView();
		List<Product> products = productService.findAll();
		modelView.addObject("products", products);
		modelView.setViewName("products/list-products");
		return modelView;
	}
	
	@GetMapping("/products/{product_id}")
	public ModelAndView getProductPage(@PathVariable long product_id) {
		ModelAndView modelView = new ModelAndView();
		Product product = productService.findById(product_id);
		modelView.addObject("product", product);
		modelView.setViewName("products/product");
		return modelView;
	}
	
	@GetMapping("/products/new")
	public String addProductPage(Model model) {
		model.addAttribute("product", new Product());
		return "products/new-product";
	}
	
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product") Product product,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "/products/new-product";
		}
		productService.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{product_id}")
	public ModelAndView getEditProductPage(@PathVariable long product_id) {
		ModelAndView modelView = new ModelAndView();
		Product product = productService.findById(product_id);
		modelView.addObject("product", product);
		modelView.setViewName("products/edit-product");
		return modelView;
	}
	
	@PostMapping("/products/edit")
	public String editProduct(@Valid @ModelAttribute("product") Product product,
			BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "products/edit-product";
		}
		productService.save(product);
		return "redirect:/products";
		
	}
	
}
