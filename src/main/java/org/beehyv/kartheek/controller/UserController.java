package org.beehyv.kartheek.controller;

import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.beehyv.kartheek.enums.AddressType;
import org.beehyv.kartheek.enums.Role;
import org.beehyv.kartheek.enums.State;
import org.beehyv.kartheek.model.Address;
import org.beehyv.kartheek.model.CartProduct;
import org.beehyv.kartheek.model.Order;
import org.beehyv.kartheek.model.ShoppingCart;
import org.beehyv.kartheek.service.AddressService;
import org.beehyv.kartheek.service.CartProductService;
import org.beehyv.kartheek.service.OrderService;
import org.beehyv.kartheek.service.ShoppingCartService;
import org.beehyv.kartheek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@Autowired
	public OrderService orderService;
	
	@Autowired
	public AddressService addressService;
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public ShoppingCartService shoppingcartService;
	
	@Autowired
	public CartProductService cartproductService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
		Enumeration<String> errors=request.getParameterNames();
		if(errors.hasMoreElements()) { 
			   String nextlement=errors.nextElement();
			   System.out.println(nextlement);
			  if(nextlement.equals("logout")) {
				   return "redirect:/static/html/login.htm?logout";
			   
			   } else if(nextlement.equals("error")) {
			   return "redirect:/static/html/login.htm?error";
			   }
		}

        return "redirect:/static/html/login.htm";
    }
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String register(HttpServletRequest request,HttpServletResponse response){
		String firstname = request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String username= request.getParameter("username");
		String password = request.getParameter("password");
		String dob = request.getParameter("dateofbirth");
		String mobile = request.getParameter("mobileno");
		String landline = request.getParameter("landlineno");
		String state = State.ACTIVE.getState();
		String role = Role.USER.getRole();
		List<org.beehyv.kartheek.model.UserDetails> userslist = userService.listUsers();
		for(org.beehyv.kartheek.model.UserDetails u: userslist){
			if(u.getUserName().equals(username)){
				return "redirect:/static/html/register.htm?status=failure";
			}
		}
		org.beehyv.kartheek.model.UserDetails user = new org.beehyv.kartheek.model.UserDetails();
		ShoppingCart cart = new ShoppingCart();
		user.setCart(cart);
		user.setDateOfBirth(dob);
		user.setFirstName(firstname);
		user.setLandlineNo(landline);
		user.setLastName(lastname);
		user.setMobileNo(mobile);
		user.setPassword(password);
		user.setRole(role);
		user.setState(state);
		user.setUserName(username);
		cart.setUser(user);
		userService.saveUser(user);
		shoppingcartService.addCart(cart);
		return "redirect:/static/html/login.htm";
	}
	
	@RequestMapping(value="/saveuserdetails",method=RequestMethod.POST)
	public String updateUserDetails(HttpServletRequest request,HttpServletResponse response){
		String firstname = request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String username= request.getParameter("username");
		String dob = request.getParameter("dateofbirth");
		String mobile = request.getParameter("mobileno");
		String landline = request.getParameter("landlineno");
		List<org.beehyv.kartheek.model.UserDetails> userslist = userService.listUsers();
		for(org.beehyv.kartheek.model.UserDetails u: userslist){
			if(u.getUserName().equals(username) && !u.getUserName().equals(getPrincipal())){
				return "redirect:/static/html/account.htm?state=failure";
			}
		}
		org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
		user.setDateOfBirth(dob);
		user.setFirstName(firstname);
		user.setLandlineNo(landline);
		user.setLastName(lastname);
		user.setMobileNo(mobile);
		user.setUserName(username);
		userService.updateUser(user);
		return "redirect:/static/html/account.htm?state=success";
	}
	
	@RequestMapping(value="/resetpassworddetails",method=RequestMethod.POST)
	public String resetPasswordDetails(HttpServletRequest request,HttpServletResponse response){
		String password = request.getParameter("password");
		
		org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
		user.setPassword(password);
		userService.updateUser(user);
		return "redirect:/static/html/account.htm?state=success1";
	}
	
	@RequestMapping(value="/addaddressdetails",method=RequestMethod.POST)
	public String addAddress(HttpServletRequest request,HttpServletResponse response){
		String doorno = request.getParameter("doorno");
		String streetname=request.getParameter("street");
		String cityname=request.getParameter("city");
		String statename = request.getParameter("state");
		String pincode = request.getParameter("pincode");
		String addresstype = request.getParameter("type");
		
		org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
		
		Address address= new Address();
		address.setCity(cityname);
		address.setHouseno(doorno);
		address.setPincode(pincode);
		address.setState(statename);
		address.setStreet(streetname);
		if(addresstype.equalsIgnoreCase("HOME")){
			address.setAddresstype(AddressType.HOME.getaddressType());
		}
		if(addresstype.equalsIgnoreCase("OFFICE")){
			address.setAddresstype(AddressType.OFFICE.getaddressType());
		}
		if(addresstype.equalsIgnoreCase("OTHER")){
			address.setAddresstype(AddressType.OTHER.getaddressType());
		}
		user.getListOfAdressess().add(address);
		address.setUser(user);
		addressService.saveAddress(address);;
		userService.updateUser(user); ;
		return "redirect:/static/html/account.htm?state=success2";
	}
	
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("value is " + getPrincipal());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
    
    @RequestMapping(value="/address/list")
    public @ResponseBody ResponseEntity<List<Address>> getlistofaddresses(){
    	org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
    	List<Address> addresslist = addressService.listAddressByUserId(user.getUserId());
    	if(addresslist.isEmpty()){
            return new ResponseEntity<List<Address>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Address>>(addresslist, HttpStatus.OK);
    }
    
    @RequestMapping(value="/deleteaddress/id={id}")
    public String deleteAddress(@PathVariable("id") int id){
    	Address address= addressService.getAddressById(id);
    	org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
    	List<Order> listorders = orderService.listOrdersByUserId(user.getUserId());
    	for(Order o:listorders){
    		if(o.getShippingaddress().getAddressId()==id){
    			return "redirect:/static/html/account.htm?state=error3";
    		}
    	}
    	addressService.deleteAddress(address);
    	return "redirect:/static/html/account.htm?state=success3";
    }
    
    @RequestMapping(value="/orders/list")
    public @ResponseBody ResponseEntity<List<Order>> getlistoforders(){
    	org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
    	List<Order> orderslist = orderService.listOrdersByUserId(user.getUserId());
    	if(orderslist.isEmpty()){
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Order>>(orderslist, HttpStatus.OK);
    }
    
    @RequestMapping(value="/checkout",method=RequestMethod.POST)
    public String checkout(HttpServletRequest request,HttpServletResponse response){
    	org.beehyv.kartheek.model.UserDetails user = userService.getUserByName(getPrincipal());
    	int addressid = Integer.parseInt(request.getParameter("addressid"));
    	List<CartProduct> cartproductslist = cartproductService.listCartProductsByCartId(user.getCart().getCartId());
    	Address address = addressService.getAddressById(addressid);
    	for(CartProduct cp: cartproductslist){
    		Order order = new Order();
    		order.setDate(new Date());
    		order.setOrderproduct(cp.getProduct());
    		order.setQuantity(cp.getQuantity());
    		order.setUser(user);
    		order.setShippingaddress(address);
    		user.getOrder().add(order);
    		orderService.addOrder(order);
    		cartproductService.deleteCartProduct(cp.getCartproductId());
    	}
    	userService.updateUser(user);
    	return "redirect:/static/html/order.htm";
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
