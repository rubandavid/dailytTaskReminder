var currentTaskId ;
var taskDatatable ;
var currentRow;

function getTaskDetails(){

	var getTaskDetailsList = postMehod('getTaskDetailsList',{});


	getTaskDetailsList.done(function(data){

		createDatatable(data);

	})



}

function validation(){

	var taskDesc = $('#taskDescription').val(),
	taskDate = dateConverter($('#taskDate').val()),
	startTime= $('#startTime').val(),
	endTime = $('#endTime').val(),
	status = $('#status').val();

	if(taskDesc ==  ''){
		alert('Please enter task description.');
		$('#taskDescription').focus();
		return;
	}else if($('#taskDate').val() == ''){
		alert('Please select the date');
		$('#taskDate').focus()
		return;
	}else if(startTime == ''){
		alert('Please enter the start time');
		$('#startTime').focus();
		return;
	}else if(endTime == ''){
		alert('Please enter the start time');
		$('#endTime').focus();
		return;
	}else if(startTime > endTime){
		alert('start time should be greater than end time');
		$('#status').focus();
		return;
	}else if(status == undefined ){
		alert('Please select the status');
		$('#status').focus();
		return;
	}


	var x = new Date();

	var cdate = x.getFullYear()+'-0'+Number(x.getMonth()+1)+'-'+x.getDate();
	var startTime = startTime+':00';
	var endTime = endTime+':00';

	var inputfields = {

			taskDate : taskDate,
			startTime : startTime,
			endTime : endTime

	}

	if(status == 'New'){

		var filters  = filter(inputfields);

		filters.done(function(data){
			console.log(data)
			if(data.length == 0){
				saveTask();
			}else{
				alert('Please select another time .Its already assigned.')
			}
		})

	}else if(status == 'Completed'){

		saveTask();
		alert("Confirmation mail has been sent to your registered mail id .")
	}else{
		saveTask();
	}


}



function saveTask(){


	var taskDesc = $('#taskDescription').val(),
	taskDate = dateConverter($('#taskDate').val()),
	startTime= $('#startTime').val(),
	endTime = $('#endTime').val(),
	status = $('#status').val();


	var userObj = {}


	var obj = {
			taskId : currentTaskId ,
			taskDescription : taskDesc,
			taskDate : taskDate,
			startTime : startTime,
			endTime : endTime ,
			status : status,
			userDetails : userObj

	}

	var saveTaskDetails = postMehod('saveTaskDetails',JSON.stringify(obj));


	saveTaskDetails.done(function (data){

		getTaskDetails();
		$('#myModal').modal('hide');
	});



}

function edit(taskId,row){


	var getTaskDetailsById =  postMehod('getTaskDetailsById/'+taskId,{});

	getTaskDetailsById.done(function(data){

		currentTaskId = taskId;

		var c = new Date(data.taskDate);
		var cdate1 = c.getFullYear()+'-0'+Number(c.getMonth()+1)+'-'+c.getDate();


		$('#taskDescription').val(data.taskDescription);
		$('#taskDate').val(cdate1);
		$('#startTime').val(data.startTime);
		$('#endTime').val(data.endTime);
		$('#status').val(data.status);

		modal('edit',taskId);




	})


}


function filter(inputfields){

	var flgfilter = inputfields;
	
	/*if(inputfields == undefined){
		if($('#startTimeFilter').val() == '' || $('#endTimeFilter').val() == ''){
			alert('Please select start and end time');
			return;
		}else if($('#startTimeFilter').val() > $('#endTimeFilter').val()){
			alert('start time should be greater than end time');
			return;
		}
		
		
		var x = new Date();

		var cdate = x.getFullYear()+'-0'+Number(x.getMonth()+1)+'-'+x.getDate();
		var startTime = $('#startTimeFilter').val()+':00';
		var endTime = $('#endTimeFilter').val()+':00';

		var obj = {

				taskDate : cdate,
				startTime : startTime,
				endTime : endTime

		}

		inputfields= obj;
	}	*/


	var filtertaskDetails = postMehod('filtertaskDetails',JSON.stringify(inputfields));

	filtertaskDetails.done(function(data){
		console.log(data);
		
		if(flgfilter == undefined){
			
			createDatatable(data);
		}
		

	});
	return filtertaskDetails;
}

function deleteTask(taskId,e){


	var deleteTaskDetailsById =  postMehod('deleteTaskDetailsById/'+taskId,{});

	deleteTaskDetailsById.done(function(data){

		$(e).parent().parent().remove();

	})




}

function createDatatable(data){

	var i = 0 ;

	if(taskDatatable != null){
		taskDatatable.destroy()
	}


	var columns= [
		{ data: function(data){ return ++i;} },
		{ data: function(data){ return data.taskDescription;} },
		{ data: function(data){ 

			if(data.taskDate != null){

				var c = new Date(data.taskDate);
				var cdate1 = c.getFullYear()+'-0'+Number(c.getMonth()+1)+'-'+c.getDate();

				return cdate1;
			}else{
				return '';
			}

		} },
		{ data: function(data){ return data.startTime;} },
		{ data: function(data){ return data.endTime;} },
		{ data: function(data){ return data.status;} },
		{ data: function(data){ return data.status == 'Completed' ? '' : '<span onclick = "edit('+data.taskId+',this)" class="glyphicon glyphicon-edit" style="cursor:pointer"></span>';} },
		{ data: function(data){ return data.status == 'Completed' ? '' :'<span onclick = "deleteTask('+data.taskId+',this)" class="glyphicon glyphicon-trash" style="cursor:pointer"></span>';} },
		];

	var dtobj = {
			data : data,
			columns : columns,
			searching: false
	}



	taskDatatable = $('#tasktable').DataTable(dtobj);


	return this.taskDatatable;
}


function modal(flag,id){

	if(flag == 'add'){
		$('#status').parent().parent().hide();
		$('#status').val('New');
		$('.mheader').html("Add Task")
		$('#taskDescription').val('');
		$('#taskDate').val('');
		$('#startTime').val('');
		$('#endTime').val('');
		$('#status').val('New');
		
		
		currentTaskId = 0 ;

	}else{
		$('#status').parent().parent().show();
		$('.mheader').html("Edit Task");
		currentTaskId = id;
	}
	$('#myModal').modal('show');
}



function filterDatatable(){
	
	
	

	if($('#startTimeFilter').val() == '' || $('#endTimeFilter').val() == ''){
		alert('Please select start and end time');
		return;
	}else if($('#startTimeFilter').val() > $('#endTimeFilter').val()){
		alert('start time should be greater than end time');
		return;
	}
	
	
	var x = new Date();

	var cdate = x.getFullYear()+'-0'+Number(x.getMonth()+1)+'-'+x.getDate();
	var startTime = $('#startTimeFilter').val()+':00';
	var endTime = $('#endTimeFilter').val()+':00';

	var obj = {

			taskDate : cdate,
			startTime : startTime,
			endTime : endTime

	}

	var filtertaskDetails = postMehod('filterDatatable',JSON.stringify(obj));

	filtertaskDetails.done(function(data){
		console.log(data);
		
			createDatatable(data);
		

	});

	
}

