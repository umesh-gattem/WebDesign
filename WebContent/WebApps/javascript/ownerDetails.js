$(document).ready(function() {
	var url = window.location.href;
	var id = getUrlParameter('id');
	$.ajax({
		type : 'get',
		data : {
			id : id
		},
		url : 'http://localhost:8080/SimpleWebApp/contactowner',
		success : function(result) {
			console.log(result);
			result = JSON.parse(result);
			$('#owner').append("<p><b><u>Owner</u></b>:&emsp;&emsp;"+result.username+"</p>")
			$('#owner').append("<p><b><u>Email Id</b></u>:&emsp;"+result.email+"</p>")
			$('#owner').append("<p><b><u>Mobile No</u></b>:&emsp;"+result.mobile+"</p>")
			$('#owner').append("<p><b><u>Address</u></b>:&emsp;&emsp;"+result.address+"</p>")						

		}

	})

})

function getUrlParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var id = sPageURL.substring(3)
	return id
}
