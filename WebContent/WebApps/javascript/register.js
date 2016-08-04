$(document).ready(function() {
	$('#submit').click(function() {
		var fullname=$('#fullname').val();
		var username = $('#username').val();
		var password = $('#password').val();
		var emailId = $('#emailId').val();
		var mobileNo = $('#mobile').val();
		var address = $('#address').val();
		$.ajax({
			type : 'post',
			data : {
				fullname :fullname,
				username : username,
				password : password,
				emailId : emailId,
				mobileNo : mobileNo,
				address : address
			},
			url : "http://localhost:8080/SimpleWebApp/registerPage",
			success : function(res) {
				if(res=="Success"){
					alert("Registered Successfully\nLogin to your account")
					window.location.href="http://localhost:8080/SimpleWebApp"
				}
				else{
					alert("Registered Unsuccessfull\nRegister again")
					window.location.href="http://localhost:8080/SimpleWebApp/WebApps/html/registerPage.html"
				}
			},
			error : function() {
				alert("Registeration unsuccessfull!!");
				window.location.href="http://localhost:8080/SimpleWebApp/WebApps/html/registerPage.html";
			}
		});
	});
});