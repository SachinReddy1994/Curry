<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="v" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
<title>Vendor Details</title>
</head>
<body>
	<br />
	<div class="row">
		<div class="container">
			<div class="row">
				<div class="col-xs-4 col-sm-4 col-md-4"></div>

				<div class="col-xs-12 col-sm-8 col-md-4 ">
					<h3 class="text-center text-info">Register</h3>
					<br />
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
								<small></small>
							</h3>
						</div>
						<div class="panel-body">
							<v:form action="addVendor" method="post" modelAttribute="vend">
								<table>
								<%-- <tr>
										<td>Vendor Id</td>
										<td><v:input path="id" required="true" /></td>
									</tr> --%>
									
									<tr>
										<td>Vendor Name</td>
										<td><v:input path="name" required="true" /></td>
									</tr>

									<tr>
										<td>Email</td>
										<td><v:input path="email" required="true" id="email" /></td>
									</tr>
									<tr>
										<td>Phone Number</td>
										<td><v:input path="phoneNumber" required="true" pattern="[6789][0-9]{9}" /></td>
									</tr>

									<tr>
										<td>House Number</td>
										<td><v:input path="address.houseNumber" required="true" /></td>
									</tr>
									<tr>
										<td>LandMark</td>
										<td><v:input path="address.landmark" required="true" /></td>
									</tr>
									<tr>
										<td>Area</td>
										<td><v:input path="address.area" required="true" /></td>
									</tr>
									<tr>
										<td>City</td>
										<td><v:input path="address.city" required="true" /></td>
									</tr>
									<tr>
										<td>State</td>
										<td><v:input path="address.state" required="true" /></td>
									</tr>
									<tr>
										<td>Pin Code</td>
										<td><v:input path="address.pincode" required="true" /></td>
									</tr>
			
								</table>

								<input type="submit" class="btn btn-primary btn-block md-4" />
								<input type="reset" class="btn btn-info btn-block md-4" />
							</v:form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>