var orderproducts;
$.getJSON("/ShoppingBee/orders/list",function(result){
	orderproducts=result;
	console.log(result);
});

$(document).ajaxStop(function(){
$(document).ready(function(){
	if(orderproducts==null){
		$('#noorders').show();
	}
	for (var i = orderproducts.length - 1; i >= 0; i--) {
		var cp =orderproducts[i].orderproduct;
		if(cp.category=='Electronics'){
			console.log('true');
			electronics(i);
		}
		if(cp.category=='Books'){
			console.log('true');
			books(i);
		}
		if(cp.category=='Clothing'){
			console.log('true');
			clothes(i);
		}
		if(cp.category=='Sports'){
			console.log('true');
			sports(i);
		}
	}
});
});

	function electronics(i){
		var attributes = orderproducts[i].orderproduct.attributeslist;
		var address= orderproducts[i].shippingaddress;
		var addresstext = address.houseno+','+address.street+','+address.city+','+address.pincode;
		var div='</div><div class="'+ orderproducts[i].orderproduct.price+' cartitem col-xs-offset-2 col-xs-8">'+
		'<div><div class="col-sm-4">'+
		'<img class="image" src='+orderproducts[i].orderproduct.imgsrc+'></div><div class="text1 col-sm-8">'+
		'<div>'+orderproducts[i].orderproduct.product_name+'</div><div>Size:'+attributes[0].value+'</div><div>Rs:'+orderproducts[i].orderproduct.price+'</div><div>Quantity:'+orderproducts[i].quantity+'</div><div>Order Date: '+orderproducts[i].date+'</div><div>Shipping Address: '+addresstext+'</div></div></div></div>';
		$('.ordercontent').append(div);
	}
	function books(i){
		var attributes = orderproducts[i].orderproduct.attributeslist;
		var address= orderproducts[i].shippingaddress;
		var addresstext = address.houseno+','+address.street+','+address.city+','+address.pincode;
		var div='</div><div class="'+orderproducts[i].orderproduct.price+' cartitem col-xs-offset-2 col-xs-8">'+
		'<div><div class="col-sm-4">'+
		'<img class="image" src='+orderproducts[i].orderproduct.imgsrc+'></div><div class="text1 col-sm-8">'+
		'<div>'+orderproducts[i].orderproduct.product_name+'</div><div>Author:'+attributes[0].value+'</div><div>Rs:'+orderproducts[i].orderproduct.price+'</div><div>Quantity:'+orderproducts[i].quantity+'</div><div>Order Date: '+orderproducts[i].date+'</div><div>Shipping Address: '+addresstext+'</div></div></div></div>';
		$('.ordercontent').append(div);
	}
	function clothes(i){
		var attributes = orderproducts[i].orderproduct.attributeslist;
		var address= orderproducts[i].shippingaddress;
		var addresstext = address.houseno+','+address.street+','+address.city+','+address.pincode;
		var div='</div><div class="'+ orderproducts[i].orderproduct.price+' cartitem col-xs-offset-2 col-xs-8">'+
		'<div><div class="col-sm-4">'+
		'<img class="image" src='+orderproducts[i].orderproduct.imgsrc+'></div><div class="text1 col-sm-8">'+
		'<div>'+orderproducts[i].orderproduct.product_name+'</div><div>Color:'+attributes[1].value+'</div><div>Rs:'+orderproducts[i].orderproduct.price+'</div><div>Quantity:'+orderproducts[i].quantity+'</div><div>Order Date: '+orderproducts[i].date+'</div><div>Shipping Address: '+addresstext+'</div></div></div></div>';
		$('.ordercontent').append(div);
	}
	function sports(i){
		var attributes = orderproducts[i].orderproduct.attributeslist;
		var address= orderproducts[i].shippingaddress;
		var addresstext = address.houseno+','+address.street+','+address.city+','+address.pincode;
		var div='</div><div class="'+ orderproducts[i].orderproduct.price+' cartitem col-xs-offset-2 col-xs-8">'+
		'<div><div class="col-sm-4">'+
		'<img class="image" src='+orderproducts[i].orderproduct.imgsrc+'></div><div class="text1 col-sm-8">'+
		'<div>'+orderproducts[i].orderproduct.product_name+'</div><div>Color:'+attributes[1].value+'</div><div>Rs:'+orderproducts[i].orderproduct.price+'</div><div>Quantity:'+orderproducts[i].quantity+'</div><div>Order Date: '+orderproducts[i].date+'</div><div>Shipping Address: '+addresstext+'</div></div></div></div>';
		$('.ordercontent').append(div);
	}