$(document).ready(function() {
	$('#submit').click(function(){
		var description=$('#description').val();
		var price=$('#price').val();
		$.ajax({
			type : 'post',
			data :{
				description : description,
				price : price,
			},
			url  : 'http://localhost:8080/SimpleWebApp/newPost',
			success : function(result){
				alert("New post is added")
				window.location.href="http://localhost:8080/SimpleWebApp/WebApps/html/homePage.html";
			},
		})
	})
})