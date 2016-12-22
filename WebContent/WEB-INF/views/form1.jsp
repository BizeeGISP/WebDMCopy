<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"
	rel="stylesheet" type="text/css">
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="/WebDM/WEB-INF/scripts/jquery-1.12.4.js"></script>
<script src="/WebDM/WEB-INF/scripts/1.10.12/js/jquery.dataTables.min.js" ></script>
<script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$('#usha').DataTable({
			"pagingType" : "full_numbers",
			"aoColumns" : [ {
				"width" : "10%"
			}, {
				"width" : "10%"
			}, {
				"width" : "10%"
			}, {
				"width" : "10%"
			}

			],
			"fixedColumns" : false,
		/* "aoColumnDefs": [
		    {
		        "aTargets": [0], "bSortable": false
		    },
		    {
		        "aTargets": [10], visible: false
		    }
		] */
		});

	});
</script>

</head>
<body>
	<form method="POST" action="/webdm/form1.html">
		<h3>Form List</h3>


		<table class="display" cellspacing="0" width="50%" id="usha">
			<thead>

				<tr class="text-center">
					<th id="tag">Tag</th>
					<th id="name">Name</th>
					<th id="label">Label</th>
					<th id="type">Type</th>
					<th id="class">Class</th>
					<th id="placeholder">Placeholder</th>
					<th>
					<select name="LookUp" id="lookup" >
					<option value="none">LookUp</option>
					<option value="url1">a2</option>
					<option value="url2">a3</option>
					</select>
					</th>
				</tr>
			</thead>
              
               <!-- <input type="button" value="Register" disabled> -->

			 <tbody>
				<%-- <tr class="text-center">
					<td><%=rs.getInt(1)%></td>

					<td><%=rs.getString(1)%></td>
					<td><%=rs.getString(2)%></td>
					<td><%=rs.getString(3)%></td>

				</tr> --%>
			</tbody> 


		</table>
		 <button type="submit" >Active</button>
		 <button type="submit" disabled>Inactive</button>

	</form>
</body>
</html>