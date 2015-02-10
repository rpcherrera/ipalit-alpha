$( document ).ready(function() { 
	$('#field-1').click(clearField);
	$('#test').click(searchToggle);
	//$('#test').click(search);
	//$('#tradables').prop('checked', true);
});
var blog = {};
var wish = {};
var valid = false;
function clearField(){
	$('#field-1').val("");
}

function searchToggle(){
	if($('#tradables').is(':checked')) {
		
   		search();
   		
	}else if($('#wishlist').is(':checked')){
		
		searchwish();
	}

}

function validator(){
	if($('#field-1').val() == ""){
		$('#field-1').attr("placeholder", "You're looking for what?");
		valid= false;
	}else{
	blog.itemname = $("#field-1").val();
	valid = true;
	}
}
function search(){
	
	validator();
	if(valid){
		$.ajax({
			type: 'POST',
		   url: '/search.html',
		   data: blog,
		   success: function() {
			   //alert(blog);
			   window.location.replace("/search.html");
			   
		   }
		   
		});
	}
	//alert(JSON.stringify(blog));
	
}

function validatorwish(){
	if($('#field-1').val() == ""){
		$('#field-1').attr("placeholder", "You're looking for what?");
		valid= false;
	}else{
		wish.wishlistName = $("#field-1").val();
		valid = true;
	}
}
function searchwish(){
	
	validatorwish();
	if(valid){
		$.ajax({
			type: 'POST',
		   url: '/searchwish.html',
		   data: wish,
		   success: function() {
			   //alert(blog);
			   window.location.replace("/searchwish.html");
			   
		   }
		   
		});
	}
	//alert(JSON.stringify(blog));
	
}
