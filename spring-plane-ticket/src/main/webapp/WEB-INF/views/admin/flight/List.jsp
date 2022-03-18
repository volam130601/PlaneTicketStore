<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<c:url var="flightAPI" value="/api/flight"/>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Manager of Flight</title>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="/common/admin/Menu.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main id="main_content">
				<div class="container-fluid px-4">
					<h1 class="mt-4">Flight</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Flight</li>
					</ol>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Flight Table
						</div>
						<div class="card-body"> 
							<a href="<c:url value="/admin/flight/edit"/>" class="btn btn-success  float-end ms-1">
								<i class="fa-solid fa-plus"></i>
							</a>
						<div id="containerTable">
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ID Flight</th>
										<th>Date Start</th>
										<th>Date End</th>
										<th>Take-Off From</th>
										<th>Landing To</th>
										<th>Plane</th>
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID Flight</th>
										<th>Date Start</th>
										<th>Date End</th>
										<th>Take-Off From</th>
										<th>Landing To</th>
										<th>Plane</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${FLIGHT}">
										<tr id='${item.id}'>
											<th>${item.id}</th>
											<td>${item.dateStart}</td>
											<td>${item.dateEnd}</td>
											<td>${item.getRouteDTO().getCodeFrom()}</td>
											<td>${item.getRouteDTO().getCodeTo()}</td>
											<td>${item.getPlaneDTO().getId()}</td>
											<td>
												<c:url var="editUrl" value="/admin/flight/edit">
													<c:param name="id">${item.id}</c:param>
												</c:url>
												<a href="${editUrl}" class="btn btn-outline-warning">
													<i class="fa-solid fa-pen-to-square"></i></a>
												<button onclick="deleteFlight('${item.id}')" class="btn btn-outline-danger"><i class="fa-solid fa-circle-minus"></i></button>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</div>							
						</div>
					</div>
				</div>
				<div id="box-toast" class="position-fixed top-0 end-0 p-3 w-25 mt-5" style="z-index: 11"></div>
			</main>
			<input type="hidden" id="message" value="${message}">
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
	<c:url var="flightLIST" value="/admin/flight/list"/>
	<script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<script type="text/javascript">
			 $(document).ready(function() {
				  var message = $('#message').val();
				  if(message == 'delete_success') {
					  showMessage('delete_success', 'Flight');
				  }
				  
			  })
		  function deleteFlight(param) {
	      	$.ajax({
	              url: "${flightAPI}/"+param,
	              method: "DELETE",
	              success: function (result) {
	            	if(result != '') {
		        	  	$(`tr[id="\${result}"]`).remove(); 
		            	/* showMessage('delete_success', 'Flight'); */
		            	window.location.href = '${flightLIST}?message=delete-success';
	            	}
	              },
	              error: function (error) {
	            	  showMessage('delete_error', 'Flight')
	              }
	          })
	     	};
			
	</script>
	
</body>
</html>
