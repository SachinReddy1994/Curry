<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="n" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">

<title>Search By Name</title>
</head>
<body style="background-image: url('https://kalamundalearningcentre.org.au/wp-content/uploads/2018/06/155341bxs69v63gz47ps7n.jpg');">
<br />
	<div class="row">
		<div class="container">
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-4"></div>

				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<h1 class="text-center text-info">Items</h1>
					<br />
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<small></small>
							</h3>
						</div>
      <div class="container">
		<div class="card">
			<div class="card-header bg-warning text-center text-white">
			</div>
			</div>	
			</div>
			<div class="card-body text-center">
							<c:form action="searchByName" method="get" modelAttribute="vend">
							Enter Name: <c:input path="name" required="true" />
								<input type="submit" value="search" />
								<table border=1>
									<tr>
										<th>Vendor Name</th>
										<th>Vendor Phone Number</th>
										<th>Item Name</th>
										<th>Item Price</th>
									</tr>
									<s:forEach var="t" items="${sName}">
										<tr>
											<td>${t.name }</td>
											<td>${t.phoneNumber }</td>
											
											<n:forEach var="i" items="${t.items }">
												<td>${i.name }</td>
												<td>${i.price }</td>
											</n:forEach>
										</tr>
									</s:forEach>
								</table>
								<a href="welcome">
									<button type="button" class="btn btn-secondary custom-btn">Welcome</button>
								</a>
							</c:form>
						</div>
						<div class="card-footer bg-warning text-white text-center">
				${message }</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>