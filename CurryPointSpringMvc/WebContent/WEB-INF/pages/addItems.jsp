<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <ul class="navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="add">Add Vendor</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="search">Search City Name</a>
    </li>
    <li class="nav-item active">
      <a class="nav-link" href="searchby">Search Vendor By Name</a>
    </li>

  </ul>
</nav>
<br />
	<div class="row">
		<div class="container">
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-4"></div>

				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<h3 class="text-center text-info">Add Items</h3>
					<br />
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<small></small>
							</h3>
						</div>
						<div class="panel-body">
			
							<form action="additem" method="post" >
								<table>
							<!-- 	 <tr>
								<td>Item Id</td>
								<td><input type="text" name="id" >
									</tr>  --> 
										<tr> 
										<td>Item Name</td>
										<td><input type="text"  name="name" /></td>
									</tr>
									<tr>
										<td>Item Price</td>
										<td><input type="text"  name="price" /></td>
									</tr>
										
								</table>

								<input type="submit" class="btn btn-success" />
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>