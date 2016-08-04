$(document).ready(
		function() {
			var url = window.location.href;
			var id = getUrlParameter('id');
			$.ajax({
				type : 'get',
				data : {
					id : id
				},
				url : 'http://localhost:8080/SimpleWebApp/eachposts',
				success : function(result) {
					console.log(result);
					result = JSON.parse(result);
					$('#eachpost').append("<p><b><u>Description</u></b>:&emsp;&emsp;"+result.description+"</p>")
					$('#eachpost').append("<p><b><u>Owner</b></u>:&emsp;&emsp;&emsp;&emsp;&emsp;"+result.username+"</p>")
					$('#eachpost').append("<p><b><u>Price</u></b>:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"+result.price+"/-</p>")
					$('#eachpost').append("<p><b><u>Date of post</u></b>:&emsp;&emsp;"+result.date+"</p>")							
					$('#eachpost').append(
							"<input type='submit' onclick='getOwner()' id='submit' value=' Contact Owner'><br> <br>")

				},
			})

		})

function getUrlParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var id=sPageURL.substring(3)
	return id
}