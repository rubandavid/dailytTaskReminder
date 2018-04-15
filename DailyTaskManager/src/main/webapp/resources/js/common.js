


function getMethod(url,data){
	
	var deffered =  $.ajax({

		type: 'post',
		url: url,
		data : data,
			
		
	});
	
	
	 return deffered;
	
}

function dateConverter(date){
	
	var cdate = date.split("-");
	
	cdate = cdate[0]+'-'+cdate[1]+'-'+cdate[2];
	
	return cdate;
	
}



function postMehod(url,obj){
	
	var deffered =  $.ajax({

		type: 'POST',
		url: url,
		data : obj,
		contentType: "application/json",
		
		
	});
	
	
	 return deffered;
	
}