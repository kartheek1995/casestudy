//DIFFERENT CATOGERIES IN THE WEBSITE
var id=Number(document.URL.slice(document.URL.indexOf('=')+1));
var products;
var url = "/ShoppingBee/products/"+(id+1);
$.getJSON(url,function(result){
	products=result;
});
$(document).ajaxStop(function(){
	$(document).ready(function(){
// TO DISPLAY PRODUCT DETAILS UPON CLICKING
					
					if(products.category=='Electronics')
					{
						EDescription();
					}
					else if(products.category=='Books')
					{
						BDescription();
					}
					else if(products.category=='Sports')
					{
						SDescription();
					}
					else if(products.category=='Clothing')
					{
						CDescription();
					}
	});
});


// ALL FUNCTIONS
		function EDescription(){
			var attributes = products.attributeslist;
			var image='<img id="electronicsimage" src='+products.imgsrc+'>';
			var details='<div class="product-name">'+products.product_name+'</div>'+
			'<div class="product-cost">&#8377;'+products.price+'</div>'+
			'<div class="other"><div><em>Screen Size:</em>  '+attributes[0].value+'</div>'+
			'<div><em>Model Number:</em>  '+attributes[1].value+'</div>'+
			'<div><em>Resolution:</em>  '+attributes[3].value+'</div>'+
			'<div><em>Display:</em>  '+attributes[2].value+'</div>'+
			'<div><em>Warranty:</em>  '+attributes[4].value+'</div></div>';
			var addtocart='<a id="'+products.product_id+'" href="http://localhost:8080/ShoppingBee/addtocart/id='+products.product_id+'" class="cart btn btn-success btn-lg">'+
							'<span class="glyphicon glyphicon-shopping-cart"></span><span class="addcart">  Add to Cart</span></a>';
			var addtolist='<a id="'+products.product_id+'" href="cart.htm" class="cart btn btn-info btn-lg">'+
							'<span class="glyphicon glyphicon-heart"></span><span class="addcart">   Add to Wishlist</span></a>';
			$('#product-image').html(image);
			$('#product-details').html(details);
			$('#cartbutton').html(addtocart);
			$('#wishlistbutton').html(addtolist);
		}
		function BDescription(i){
			var attributes = products.attributeslist;
			var image='<img id="booksimage" src='+products.imgsrc+'>';
			var details='<div class="product-name">'+products.product_name+'</div>'+
			'<div class="product-cost">&#8377;'+products.price+'</div>'+
			'<div class="other"><div><em>Author:</em>  '+attributes[0].value+'</div>'+
			'<div><em>Publications:</em>  '+attributes[1].value+'</div>'+
			'<div><em>Type of Book:</em>  '+attributes[2].value+'</div>'+
			'<div><em>Pages:</em>  '+attributes[3].value+'</div>'+
			'<div><em>Language:</em>  '+attributes[4].value+'</div></div>';
			var addtocart='<a id="'+products.product_id+'" href="http://localhost:8080/ShoppingBee/addtocart/id='+products.product_id+'" class="cart btn btn-success btn-lg">'+
							'<span class="glyphicon glyphicon-shopping-cart"></span><span class="addcart">  Add to Cart</span></a>';
			var addtolist='<a id="'+products.product_id+'" href="cart.htm" class="cart btn btn-info btn-lg">'+
							'<span class="glyphicon glyphicon-heart"></span><span class="addcart">   Add to Wishlist</span></a>';
			$('#product-image').html(image);
			$('#product-details').html(details);
			$('#cartbutton').html(addtocart);
			$('#wishlistbutton').html(addtolist);
		}
		function SDescription(i){
			var attributes = products.attributeslist;
			var image='<img id="sportsimage" src='+products.imgsrc+'>';
			var details='<div class="product-name">'+products.product_name+'</div>'+
			'<div class="product-cost">&#8377;'+products.price+'</div>'+
			'<div class="other"><div><em>Brand:</em>  '+attributes[0].value+'</div>'+
			'<div><em>Color:</em>  '+attributes[1].value+'</div>'+
			'<div><em>Type:</em>  '+attributes[2].value+'</div>'+
			'<div><em>Lifestyle:</em>  '+attributes[3].value+'</div>'+
			'<div><em>Warranty:</em>  '+attributes[4].value+'</div></div>';
			var addtocart='<a id="'+products.product_id+'" href="http://localhost:8080/ShoppingBee/addtocart/id='+products.product_id+'" class="cart btn btn-success btn-lg">'+
							'<span class="glyphicon glyphicon-shopping-cart"></span><span class="addcart">  Add to Cart</span></a>';
			var addtolist='<a id="'+products.product_id+'" href="cart.htm" class="cart btn btn-info btn-lg">'+
							'<span class="glyphicon glyphicon-heart"></span><span class="addcart">   Add to Wishlist</span></a>';
			$('#product-image').html(image);
			$('#product-details').html(details);
			$('#cartbutton').html(addtocart);
			$('#wishlistbutton').html(addtolist);
		}
		function CDescription(i){
			var attributes = products.attributeslist;
			var image='<img id="clothimage" src='+products.imgsrc+'>';
			var details='<div class="product-name">'+products.product_name+'</div>'+
			'<div class="product-cost">&#8377;'+products.price+'</div>'+
			'<div class="other"><div><em>Brand:</em>  '+attributes[0].value+'</div>'+
			'<div><em>Color:</em>  '+attributes[1].value+'</div>'+
			'<div><em>Cloth:</em>  '+attributes[2].value+'</div>'+
			'<div><em>Lifestyle:</em>  '+attributes[3].value+'</div>'+
			'<div><em>Fit:</em>  '+attributes[4].value+'</div></div>';
			var addtocart='<a id="'+products.product_id+'" href="http://localhost:8080/ShoppingBee/addtocart/id='+products.product_id+'" class="cart btn btn-success btn-lg">'+
							'<span class="glyphicon glyphicon-shopping-cart"></span><span class="addcart">  Add to Cart</span></a>';
			var addtolist='<a id="'+products.product_id+'" href="cart.htm" class="cart btn btn-info btn-lg">'+
							'<span class="glyphicon glyphicon-heart"></span><span class="addcart">   Add to Wishlist</span></a>';
			$('#product-image').html(image);
			$('#product-details').html(details);
			$('#cartbutton').html(addtocart);
			$('#wishlistbutton').html(addtolist);
		}