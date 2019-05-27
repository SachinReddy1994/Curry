<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="r" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>Search City</title>
</head>
<body style="background-image: url('https://p.motionelements.com/stock-video/business/me8469806-indian-street-food-mumbai-india-hd-a0092.jpg'); ">
<br />
	<div class="row">
		<div class="container">
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-4"></div>

				<div class="col-xs-12 col-sm-8 col-md-4 ">
					
 
 	<h1 class="text-center text-info" >CuRRy ShoPs</h1>
 					<br />
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<small></small>
							</h3>
						</div>
      <div class="container">
		<div class="card">
			<div class="card-header bg-info text-center text-white">
			</div>
			</div>	
			</div>
			<div class="card-body text-center">
			
<r:form action="searchByCity" method="get" modelAttribute="add">
Enter City: <r:input path="city" required="true"/>
<input type="submit" value="search"/>
<table border=1>
<tr>
<th> Vendor Name </th>
<th> Phone Number </th>
<th> Landmark </th>
<th>  Area </th>
<th> City </th>
<th> State </th>
</tr>
<d:forEach var="v" items="${sCity }">
<tr>
<td> ${v.name } </td>
<td> ${v.phoneNumber }</td>
<td> ${v.address.landmark }</td>
<td> ${v.address.city } </td>
<td> ${v.address.area }</td>
<td> ${v.address.state }</td>
</tr>
</d:forEach>
</table>
<a href="welcome"> <button type="button" class="btn btn-secondary custom-btn">Welcome</button></a>
</r:form>
</div>
<div class="card-footer bg-info text-white text-center">
				${message }</div>
			</div>
			</div>
			</div>
			</div>
			</div>
</body>
</html>