var products;
if(document.URL=='http://localhost:8080/ShoppingBee/static/html/books.htm'){
$.getJSON("/ShoppingBee/category/books",function(result){
	products=result;
});
}
else if(document.URL=='http://localhost:8080/ShoppingBee/static/html/books.htm?filter=0'){
$.getJSON("/ShoppingBee/category/books",function(result){
	products=result;
});
}
else{
	var filter =  Number(document.URL.slice(document.URL.indexOf('=')+1));
	$.getJSON("/ShoppingBee/books/"+filter,function(result){
	products=result;
	});
}
$(document).ajaxStop(function(){
	$(document).ready(function(){
		   
	for(i=0;i<products.length;i++)
 	{
		$('#content').append(selectbooks(i));
	}
	
	});
});

// ALL FUNCTIONS
		function selectbooks(i){
			var id=products[i].product_id-1;
			var div= '<a href="productdetails.htm?id='+id+'"><div id="main2" class="'+products[i].price+
			' col-md-4 col-sm-6 col-xs-12 main">'+
			'<img class="product-image" src='+products[i].imgsrc+' style="width:11.25em;height:9.375em;">'+
			'<div class="product-name"><a href="productdetails.htm?id='+products[i].product_id+'">'+products[i].product_name+'</a></div>'+
			'<div>&#8377;'+products[i].price+'</div></div></a>';
			return div;
		}
	


$('.filter button').click(function(){
		var checkbox = $(this).find(".range");
		var a,b,c,d,total;
		if(checkbox.is(":checked")){
			checkbox.prop("checked",false);
		}
		else{
			checkbox.prop("checked",true);
		}
		if($('#0-999').is(":checked")){
			a=1;
		}
		else{
			a=0
		}
		if($('#1000-1999').is(":checked")){
			b=2;
		}
		else{
			b=0
		}
		if($('#2000-9999').is(":checked")){
			c=4;
		}
		else{
			c=0
		}
		if($('#10000-50000').is(":checked")){
			d=8;
		}
		else{
			d=0
		}
		total = a+b+c+d;
		location.href = location.pathname+"?filter="+total;
		
	});
	
	$(document).ready(function(){
		var filter = Number(document.URL.slice(document.URL.indexOf('=')+1));
		var a=[0,0,0,0];
		if(filter%2==1){
			a[3]=1;
		}
		if(filter%4>=2){
			a[2]=1;
		}
		if(filter%8>=4){
			a[1]=1;
		}
		if(filter>=8){
			a[0]=1;
		}
		if(a[3]==1){
			$('#0-999').prop("checked",true);
		}
		else{
			$('#0-999').prop("checked",false);
		}
		if(a[2]==1){
			$('#1000-1999').prop("checked",true);
		}
		else{
			$('#1000-1999').prop("checked",false);
		}if(a[1]==1){
			$('#2000-9999').prop("checked",true);
		}
		else{
			$('#2000-9999').prop("checked",false);
		}if(a[0]==1){
			$('#10000-50000').prop("checked",true);
		}
		else{
			$('#10000-50000').prop("checked",false);
		}
	});