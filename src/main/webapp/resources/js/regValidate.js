$(document).ready(function(e){
	
	oohLa();
	
	
	$(".regForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3
				},
				lname: {
					required : true,
					minlength : 3
				},
				username: {
					required : true,
					minlength : 4,
					remote : {
						url: "/register/available.html",
						type: "get",
						data: {
							username: function(){
								return $("#username").val();
							}
						}
					}
				},
				email: {
					required : true,
					email : true,
					remote : {
						url: "/register/availableEmail.html",
						type: "get",
						data: {
							email: function(){
								return $("#email").val();
							}
						}
					}
				},
				password: {
					required : true,
					minlength : 6
				},
				cpassword: {
					required : true,
					minlength : 6,
					equalTo : "#password"
				},
				contactnum: {
					required : true,
					minlength : 11,
					maxlength : 11
				}
			},
			highlight: function(element){
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element){
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages:{
				username:{
					remote: "Such username already exists!"
				},
				email:{
					remote: "This email is already registered!"
				},
				contactnum:{
					minlength: "Please enter your 11-digit cellphone number",
					maxlength: "Please enter your 11-digit cellphone number"
				}
			}
		}		
	);
});


function oohLa(){
	$("#con").keypress(function() { 
		/*var arr = "123456789,.";
		var code;
		if (window.event)
			code = event.keyCode;
		else
			code = event.which;
		var char = keychar = String.fromCharCode(code);
		if (arr.indexOf(char) == -1)
			return false;*/
		$(this).numeric();
		
	});
}