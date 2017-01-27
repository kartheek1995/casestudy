var cartproducts;
$.getJSON("/ShoppingBee/cartproducts",function(result){
	cartproducts=result;
});

$.getJSON("/ShoppingBee/address/list",function(result){
    addresslist=result;
});

$(document).ajaxStop(function(){
$(document).ready(function(){
	if(cartproducts==[] || cartproducts==null){
		$('.empty').show();
		$('.butt').hide();
	}
	else{
		$('.empty').hide();
		$('.butt').show();
	}
var total=0;
	for (var i = cartproducts.length - 1; i >= 0; i--) {
		var cp =cartproducts[i].product;
		total = total+ (cp.price*cartproducts[i].quantity);
		if(cp.category=='Electronics'){
			electronics(i);
		}
		if(cp.category=='Books'){
			books(i);
		}
		if(cp.category=='Clothing'){
			clothes(i);
		}
		if(cp.category=='Sports'){
			sports(i);
		}
	}
var tot="<strong>Grand Total: &#8377 "+total+"</strong>";
$('.total').html(tot);

if(addresslist==null){
	$('#noaddress').show();
	$('#check').attr('disabled',true);
}

for(var i=1;i<=addresslist.length;i++){
    $("#address").append(appendAddress(i-1));
}


$('#checkout').submit(function(){
    var radioName='addressid';

      if ($('input[name='+ radioName +']:checked').length) {
           return true; 
      }
      else {
      	console.log(false);
           $('#errormessage').show();
           return false; 
      }
    }
  );

});
});

	function electronics(i){
		var attributes = cartproducts[i].product.attributeslist;
		var div='</div><div class="'+ cartproducts[i].product.price+' cartitem col-xs-offset-2 col-xs-8"><div class="col-xs-12">'+
		'<a href="http://localhost:8080/ShoppingBee/removefromcart/id='+cartproducts[i].product.product_id+'" <button id="'+cartproducts[i].product.price+'" type="button" class="close"><span>&times;</span></button></a></div><div><div class="col-sm-4">'+
		'<img class="image" src='+cartproducts[i].product.imgsrc+'></div><div class="text col-sm-8">'+
		'<div>'+cartproducts[i].product.product_name+'</div><div>Size:'+attributes[0].value+'</div><div>Rs:'+cartproducts[i].product.price+'</div><div>Quantity:'+cartproducts[i].quantity+'</div></div></div></div>';
		$('.cartcontent').append(div);
	}
	function books(i){
		var attributes = cartproducts[i].product.attributeslist;
		var div='</div><div class="'+cartproducts[i].product.price+' cartitem col-xs-offset-2 col-xs-8"><div class="col-xs-12">'+
		'<a href="http://localhost:8080/ShoppingBee/removefromcart/id='+cartproducts[i].product.product_id+'" <button id="'+cartproducts[i].product.price+'" type="button" class="close"><span>&times;</span></button></a></div><div><div class="col-sm-4">'+
		'<img class="image" src='+cartproducts[i].product.imgsrc+'></div><div class="text col-sm-8">'+
		'<div>'+cartproducts[i].product.product_name+'</div><div>Author:'+attributes[0].value+'</div><div>Rs:'+cartproducts[i].product.price+'</div><div>Quantity:'+cartproducts[i].quantity+'</div></div></div></div>';
		$('.cartcontent').append(div);
	}
	function clothes(i){
		var attributes = cartproducts[i].product.attributeslist;
		var div='</div><div class="'+ cartproducts[i].product.price+' cartitem col-xs-offset-2 col-xs-8"><div class="col-xs-12">'+
		'<a href="http://localhost:8080/ShoppingBee/removefromcart/id='+cartproducts[i].product.product_id+'" <button id="'+cartproducts[i].product.price+'" type="button" class="close"><span>&times;</span></button></a></div><div><div class="col-sm-4">'+
		'<img class="image" src='+cartproducts[i].product.imgsrc+'></div><div class="text col-sm-8">'+
		'<div>'+cartproducts[i].product.product_name+'</div><div>Color:'+attributes[1].value+'</div><div>Rs:'+cartproducts[i].product.price+'</div><div>Quantity:'+cartproducts[i].quantity+'</div></div></div></div>';
		$('.cartcontent').append(div);
	}
	function sports(i){
		var attributes = cartproducts[i].product.attributeslist;
		var div='</div><div class="'+ cartproducts[i].product.price+' cartitem col-xs-offset-2 col-xs-8"><div class="col-xs-12">'+
		'<a href="http://localhost:8080/ShoppingBee/removefromcart/id='+cartproducts[i].product.product_id+'" <button id="'+cartproducts[i].product.price+'" type="button" class="close"><span>&times;</span></button></a></div><div><div class="col-sm-4">'+
		'<img class="image" src='+cartproducts[i].product.imgsrc+'></div><div class="text col-sm-8">'+
		'<div>'+cartproducts[i].product.product_name+'</div><div>Color:'+attributes[1].value+'</div><div>Rs:'+cartproducts[i].product.price+'</div><div>Quantity:'+cartproducts[i].quantity+'</div></div></div></div>';
		$('.cartcontent').append(div);
	}


function appendAddress(i){
    var addressdiv = '<div class="panel-group col-xs-12"><div class="panel panel-success"><div class="panel-heading"><input type="radio" name="addressid" value="'+addresslist[i].addressId+'">'+
                   ' Address '+(i+1)+' </div><div class="panel-body"><p>'+addresslist[i].houseno+'</p><p>'+addresslist[i].houseno.street+'</p>'+
                    '<p>'+addresslist[i].city+'</p><p>'+addresslist[i].state+'</p><p>'+addresslist[i].pincode+'</p><p>Address type: '+addresslist[i].addresstype+'</p></div></div>'
    return addressdiv;
}
