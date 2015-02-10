$(document).ready(function() {

	nameVal();
});

function nameVal(){

	var firstName;
	var lastName;
	var wholeName;
	$('#fname').on('keyup change', function(e) {
		firstName = $('#fname').val();
		$('#fname').val(firstName);
		console.log(firstName);
	})
	
	$('#lname').on('keyup change', function(e) {
		lastName = $('#lname').val();
		$('#lname').val(lastName);
		console.log(lastName);
	})
	
	wholeName = firstName+" "+lastName;
	var aWho = JSON.stringify(wholeName);
	var bWho = JSON.parse(aWho)
	
	$("#submit").on('click change', function(){
	$('#name').val(bWho);
    alert($("#name").val());
  });
	
}

