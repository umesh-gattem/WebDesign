function getOwner(){
	var url = window.location.href;
	var id = getUrlParameter('id');
	window.location.href = "../html/ownerDetails.html?id="+id;
	
}

function getUrlParameter(sParam) {
	var sPageURL = window.location.search.substring(1);
	var id=sPageURL.substring(3)
	return id
}


		