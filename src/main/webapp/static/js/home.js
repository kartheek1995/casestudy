	$(document).ready(myFunction1);
	$(window).resize(myFunction1);
	function myFunction1(){
		if ($(document).width()<360)
			{
			$("#mycart").removeClass("btn-lg");
			$("#logout").removeClass("btn-lg");
			$('#title').attr("style","font-size:20px")
			$('#logo').attr({
	        					"style" : "width:40px",
	        					"style" : "height:40px"
	    					});
			$('#nav').removeClass("btn-group-justified").addClass("btn-group-vertical fullwidth");
		}
		else if ($(document).width()<600)
		{
			$("#mycart").removeClass("btn-lg");
			$("#logout").removeClass("btn-lg");
			$('#title').attr("style","font-size:30px")
			$('#logo').attr({
	        					"style" : "width:40px",
	        					"style" : "height:40px"
	    					});
			$('#nav').removeClass("btn-group-justified").addClass("btn-group-vertical fullwidth");
		}
		else if ($(document).width()<992)
		{
			$("#mycart").addClass("btn-lg");
			$("#logout").addClass("btn-lg");
			$('#title').attr("style","font-size:40px")
			$('#logo').attr({
	        					"style" : "width:50px",
	        					"style" : "height:50px"
	    					})
			$('#nav').addClass("btn-group-justified").removeClass("btn-group-vertical fullwidth");
		}
		else
		{
			$("#mycart").addClass("btn-lg");
			$("#logout").addClass("btn-lg");
			$('#title').attr("style","font-size:3.5vw")
			$('#logo').attr({
	        					"style" : "width:7%",
	        					"style" : "height:7%"
	    					});
			$('#nav').addClass("btn-group-justified").removeClass("btn-group-vertical fullwidth");
		}
	}
	// FOR MAKING WHOLE BUTTON IN FILTER AS TOGGLEABLE	& FILTER-DESIGN FOR PRICE

	$('.clot').click(function(){
		location.assign('http://localhost:8080/ShoppingBee/static/html/clothes.htm');
	});

	$('.sport').click(function(){
		location.assign('http://localhost:8080/ShoppingBee/static/html/sports.htm');
	});

	$('.elect').click(function(){
		location.assign('http://localhost:8080/ShoppingBee/static/html/electronics.htm');
	});

	$('.book').click(function(){
		location.assign('http://localhost:8080/ShoppingBee/static/html/books.htm');
	});