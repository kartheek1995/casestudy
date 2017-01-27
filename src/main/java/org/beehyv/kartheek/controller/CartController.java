package org.beehyv.kartheek.controller;

import java.util.List;

import org.beehyv.kartheek.model.CartProduct;
import org.beehyv.kartheek.model.Product;
import org.beehyv.kartheek.service.CartProductService;
import org.beehyv.kartheek.service.ProductService;
import org.beehyv.kartheek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {
	@Autowired
	public CartProductService cartproductService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public ProductService productService;
	
	@RequestMapping(value="/cartproducts")
	public @ResponseBody ResponseEntity<List<CartProduct>> cartproducts(){
		org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
		int id = user.getCart().getCartId();
		List<CartProduct> Products = cartproductService.listCartProductsByCartId(id);
        if(Products.isEmpty()){
            return new ResponseEntity<List<CartProduct>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<CartProduct>>(Products, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addtocart/id={id}")
	public String addproducttocart(@PathVariable("id") int id){
		Product product = productService.getProductById(id);
		org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
		List<CartProduct> CartProducts = cartproductService.listCartProductsByCartId(user.getCart().getCartId());
		for(CartProduct cp:CartProducts){
				if(cp.getProduct().getProduct_id()== product.getProduct_id()){
					cp.setQuantity(cp.getQuantity()+1);
					cartproductService.updateCartProduct(cp);
					return "redirect:/static/html/cart.htm";
				}
		}
		CartProduct cproduct = new CartProduct();
		cproduct.setProduct(product);
		cproduct.setQuantity(1);
		cproduct.setCart(user.getCart());
		cartproductService.addCartProduct(cproduct);
		return "redirect:/static/html/cart.htm";
	}
	
	@RequestMapping(value="/removefromcart/id={id}")
	public String removeproductfromcart(@PathVariable("id") int id){
		Product product = productService.getProductById(id);
		org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
		int cartid = user.getCart().getCartId();
		CartProduct cartproduct = cartproductService.getCartProductByProductIdAndCartId(id, cartid);
		cartproductService.deleteCartProduct(cartproduct.getCartproductId());
		return "redirect:/static/html/cart.htm";
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
