	$(document).ready(function() {
		$('#signin').click(function() {
			var username = $('#username').val();
			var password = $('#password').val();
			$.ajax({
				type : 'get',
				data : {
					username : username,
					password : password,
				},
				url : "http://localhost:8080/SimpleWebApp/loginPage",
				success : function(res) {
					if(res=="Successful!!"){
						window.location.href="http://localhost:8080/SimpleWebApp/WebApps/html/homePage.html";
					}						
					else{
						alert("Invalid Credentials!!!!!!");
						window.location.href="http://localhost:8080/SimpleWebApp";
					}
				},
				error : function(res) {
					alert(res);
				}
			});
		});
	});