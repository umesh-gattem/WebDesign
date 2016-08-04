$(document).ready(function() {
	var result=new Object;
	$('#otherposts').click(function(){
		$.ajax({
			type : 'get',
			url  : 'http://localhost:8080/SimpleWebApp/otherPosts',
			success : function(result){
				console.log(result);
				result=JSON.parse(result);
				for(var i=0; i< result.length; i++){
					$('#post').append("<input onclick='clickDet("+ result[i].id +")' type='submit' id='"+result[i].id+"'value='"+result[i].description+"' ><br><br>")
				}
			},
		})
	});
})

