$(document).ready(myFunction);
$(window).resize(myFunction);

function myFunction(){
	if ($(document).width()>992)
	{
		$("#login").addClass("btn-block");
		$("#login").removeClass("btn-lg");
	}
	else
	{
		$("#login").removeClass("btn-block");
		$("#login").addClass("btn-lg");
	}

	var error = document.URL.slice(document.URL.indexOf('?')+1);
	if(error=='error'){
		$(".error-message").show();
	}
	if(error=='logout'){
		$(".logout-message").show();
	}
	}




