var products;
if(document.URL=='http://localhost:8080/ShoppingBee/static/html/electronics.htm'){
$.getJSON("/ShoppingBee/category/electronics",function(result){
	products=result;
});
}
else if(document.URL=='http://localhost:8080/ShoppingBee/static/html/electronics.htm?filter=0'){
$.getJSON("/ShoppingBee/category/electronics",function(result){
	products=result;
});
}
else{
	var filter =  Number(document.URL.slice(document.URL.indexOf('=')+1));
	$.getJSON("/ShoppingBee/electronics/"+filter,function(result){
	products=result;
	});
}
$(document).ajaxStop(function(){
	$(document).ready(function(){

	for(i=0;i<products.length;i++)
 	{
		$('#content').append(selectelectronics(i));
	}
	});
});

// ALL FUNCTIONS
		function selectelectronics(i){
			var id =products[i].product_id-1;
			var div= '<a href="productdetails.htm?id='+id+'"><div id="main1" class="'+products[i].price+
			' col-md-4 col-static/html/home.htmsm-6 col-xs-12 main">'+
			'<img class="product-image" src='+products[i].imgsrc+' style="width:11.25em;height:9.375em;">'+
			'<div class="product-name"><a href="productdetails.htm?id='+products[i].product_id+'">'+products[i].product_name+'</a></div>'+
			'<div>&#8377;'+products[i].price+'</div></div></a>';
			return div;

		}
		



$('.filter button').click(function(){
		var checkbox = $(this).find(".range");
		var checkbox2 = $(this).find(".rang");
		var a,b,c,d,total;
		if(checkbox.is(":checked")){
			checkbox.prop("checked",false);
		}
		else{
			checkbox.prop("checked",true);
		}
		if(checkbox2.is(":checked")){
			checkbox2.prop("checked",false);
		}
		else{
			checkbox2.prop("checked",true);
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
		if($('#SG').is(":checked")){
			e=16;
		}
		else{
			e=0
		}
		if($('#NIV').is(":checked")){
			f=32;
		}
		else{
			f=0
		}
		if($('#VX').is(":checked")){
			g=64;
		}
		else{
			g=0
		}
		if($('#NB').is(":checked")){
			h=128;
		}
		else{
			h=0
		}
		total = a+b+c+d+e+f+g+h;
		location.href = location.pathname+"?filter="+total;
		
	});
	
	$(document).ready(function(){
		var filter = Number(document.URL.slice(document.URL.indexOf('=')+1));
		var a=decimaltobinary(filter,8);
		if(a[7]==1){
			$('#0-999').prop("checked",true);
		}
		else{
			$('#0-999').prop("checked",false);
		}
		if(a[6]==1){
			$('#1000-1999').prop("checked",true);
		}
		else{
			$('#1000-1999').prop("checked",false);
		}if(a[5]==1){
			$('#2000-9999').prop("checked",true);
		}
		else{
			$('#2000-9999').prop("checked",false);
		}if(a[4]==1){
			$('#10000-50000').prop("checked",true);
		}
		else{
			$('#10000-50000').prop("checked",false);
		}if(a[3]==1){
			$('#SG').prop("checked",true);
		}
		else{
			$('#SG').prop("checked",false);
		}
		if(a[2]==1){
			$('#NIV').prop("checked",true);
		}
		else{
			$('#NIV').prop("checked",false);
		}
		if(a[1]==1){
			$('#VX').prop("checked",true);
		}
		else{
			$('#VX').prop("checked",false);
		}
		if(a[0]==1){
			$('#NB').prop("checked",true);
		}
		else{
			$('#NB').prop("checked",false);
		}
	});

	function decimaltobinary(dec,length){
  		var out = "";
  		while(length--)
    		out += (dec >> length ) & 1;    
  		return out;  
	}