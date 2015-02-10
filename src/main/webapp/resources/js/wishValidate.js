$(document).ready(function() {
	$('.nav-tabs a:first').tab('show');
	$('.triggerRemove2').click(function(e){
		e.preventDefault();
		$("#delModal2 .removeBtn2").attr("href", $(this).attr("href"));
		$("#delModal2").modal();
	});

	$(".wishForm").validate(
			{
				rules: {
					wishlistName: {
						required : true,
						minlength : 4
					},
					wishlistDesc: {
						required : true,
						minlength : 5
					}
				},
				highlight: function(element){
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element){
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages:{
					wishlistName:{
						minlength: "Please enter an item name"
					},
					wishlistDesc:{
						minlength: "Please enter an accurate description of your item!"
					}
				}
			}				
	);
});