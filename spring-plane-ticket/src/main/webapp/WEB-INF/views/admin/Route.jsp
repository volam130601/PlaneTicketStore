<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Manager of Route flight</title>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="/common/admin/Menu.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main id="main_content">
				<div class="container-fluid px-4">
					<h1 class="mt-4">Route Flight</h1>
					<!-- <ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Route</li>
					</ol> -->
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Route Flight Table
						</div>
						<div class="card-body">
							<button id="addBtn" class="btn btn-success float-end ms-1">
								<i class="fa-solid fa-plus"></i>
							</button>
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ID Route</th>
										<th>From</th>
										<th>To</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID Route</th>
										<th>From</th>
										<th>To</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${ROUTE}">
										<tr>
											<td>${item.id}</td>
											<td>
												 <c:forEach var="temp" items="${AIRPORT}">
													<c:if test="${item.codeFrom == temp.code}">${temp.country}</c:if>
												</c:forEach>
											</td>
											<td>
												<c:forEach var="temp" items="${AIRPORT}">
													<c:if test="${item.codeTo == temp.code}">${temp.country}</c:if>
												</c:forEach>
											</td>
											<td><span class="text-white p-1 fw-bold border-2 rounded 
												<c:if test="${item.status == 1}">bg-success</c:if>
												<c:if test="${item.status == 0}">bg-danger</c:if>">
												<c:if test="${item.status == 1}">Active</c:if>
												<c:if test="${item.status == 0}">Stopped</c:if>
											</span></td>
											<td>
												<a class="btn btn-outline-warning"><i class="fa-solid fa-pen-to-square"></i></a>
												<a href="#" class="btn btn-outline-danger"><i class="fa-solid fa-circle-minus"></i></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				
			</main>
	
			<jsp:include page="/common/admin/footer.jsp"></jsp:include>

		</div>
	</div>
	<script>
		// Example starter JavaScript for disabling form submissions if there are invalid fields
		(function() {
			'use strict'

			// Fetch all the forms we want to apply custom Bootstrap validation styles to
			var forms = document.querySelectorAll('.needs-validation')

			// Loop over them and prevent submission
			Array.prototype.slice.call(forms).forEach(function(form) {
				form.addEventListener('submit', function(event) {
					if (!form.checkValidity()) {
						event.preventDefault()
						event.stopPropagation()
					}

					form.classList.add('was-validated')
				}, false)
			})
		})()
	</script>
	<c:url var="airlineAPI" value="/api/airline"></c:url>
	<script type="text/javascript">
		function getID(param) {
			$.ajax({
				url: '${airlineAPI}',
				type: 'POST',
				data: {
					id: param
				},
				success: function (data) {
				},
				error: function () {
					console.log(error);
				} 
			});
	    }
	</script>
</body>
</html>
