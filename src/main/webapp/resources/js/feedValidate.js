$(document).ready(function() {
	$('.nav-tabs a:first').tab('show');
	$('.triggerRemove').click(function(e){
		e.preventDefault();
		$("#delModal .removeBtn").attr("href", $(this).attr("href"));
		$("#delModal").modal();
	});

	$(".feedForm").validate(
			{
				rules: {
					feedbackDesc: {
						required : true,
						minlength : 10
					}
				},
				highlight: function(element){
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element){
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages:{
					feedbackDesc:{
						minlength: "Please post an honest feedback. Thank You"
					}
				}
			}				
	);
});