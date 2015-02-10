$(document).ready(function() {
	$('.nav-tabs a:first').tab('show');
	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$("#delModal .removeBtn").attr("href", $(this).attr("href"));
		$("#delModal").modal();
	});

	$(".blogForm").validate(
			{
				rules: {
					itemname: {
						required : true,
						minlength : 4
					},
					itemdescription: {
						required : true,
						minlength : 20
					}
				},
				highlight: function(element){
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element){
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages:{
					itemname:{
						minlength: "Please enter an item name"
					},
					itemdescription:{
						minlength: "Please enter an accurate description of your item!"
					}
				}
			}				
	);
});