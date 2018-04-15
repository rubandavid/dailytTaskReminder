<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Daily Task Reminder</title>
	<link rel="stylesheet" href="resources/css/index.css">	
	<link rel="stylesheet" href="resources/css/datatable.css">	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 	

	</head> 
	<body>
	
	<div class="header">
	<div class="subheader"><h6>WELCOME</h6>
	<span><%=session.getAttribute("userName")%></span>
	<span class="title">Daily Task Manager</span>
	</div>
	<button class="btn logout" style="margin-top: -48px;" onclick="window.location='logout';">Logout</button>
	</div>
	
	<div class="filters">
	
		<button id="taskButton" type="button" class="btn btn-info" onclick="modal('add')">Create Task</button>
		<div class="tableFilter">
        	Start time : <input type="time" id="startTimeFilter" />
        	End time : <input type="time" id="endTimeFilter"/>
		
		<button onclick="filterDatatable()">filter</button>
		</div>
	</div>
	
	<div class="datatable">	
		<table id="tasktable">
		<thead>
		<th>Task Id</th>
		<th>Task Description</th>
		<th>Date</th>
		<th>Start Time</th>
		<th>End Time</th>
		<th>Status</th>
		<th>Edit</th>
		<th>Delete</th>
		</thead>
		<tbody>
		
		</tbody>
		</table>
	</div>	
	
	
	
<div class="modal fade" id="myModal" role="dialog" data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title mheader">Add Task</h4>
        </div>
        <div class="modal-body">
        	<table id="modalTable">
        	<tr><td>Task Description  :</td><td> <textarea  id="taskDescription"></textarea></td></tr>
        	<tr><td>Date :</td><td> <input  type="date" id="taskDate"/></td></tr>
        	<tr><td>Start time :</td><td> <input type="time" id="startTime" /></td></tr>
        	<tr><td>End time : </td><td><input type="time" id="endTime"/></td></tr>
        	<tr><td>Status : </td><td><select id="status"><option disabled selected>select</option><option>New</option><option>Started</option><option>Completed</option></select></td></tr>
       
        </table>
        </div>
        <div class="modal-footer" style="text-align: center;">
        <button type="button" class="btn btn-default" onclick="validation()">Submit</button>
          <button type="button" class="btn" data-dismiss="modal">Close</button>
        </div>
      </div>
      </div>
</div>		
		
	<div class="footer">dtm@DailyTaskManager pvt ltd</div>	
		<script src='resources/js/jquery.min.js'></script>
		 <script src="resources/js/bootstrap.min.js"></script>
		<script src="resources/js/datatable.min.js"></script>
		<script src='resources/js/common.js'></script>
		<script src="resources/js/taskDetails.js"></script>
		<script type="text/javascript">
		
		getTaskDetails();
		
		</script>
	</body>
</html>
