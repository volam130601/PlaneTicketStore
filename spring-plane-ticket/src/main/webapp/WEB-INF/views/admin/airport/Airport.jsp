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
<title>Manager of Airpot flight</title>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="/common/admin/Menu.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main id="main_content">
				<div class="container-fluid px-4">
					<h1 class="mt-4">Airpot Flight</h1>
					<!-- <ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Route</li>
					</ol> -->
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Airpot Table
						</div>
						<div class="card-body">
							<button id="addBtn" class="btn btn-success float-end ms-1"
								data-bs-toggle="modal" data-bs-target="#AddOrUpdate">
								<i class="fa-solid fa-plus"></i>
							</button>
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ID</th>
										<th>Code</th>
										<th>Name</th>
										<th>Country</th>
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID</th>
										<th>Code</th>
										<th>Name</th>
										<th>Country</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${AIRPORT}">
										<tr>
											<th>${item.id}</th>
											<td>${item.code }</td>
											<td>${item.name }</td>
											<td>${item.country}</td>
											<td>
											<button onclick="" class="btn btn-outline-warning"
											data-bs-toggle="modal" data-bs-target="#AddOrUpdate"><i
													class="fa-solid fa-pen-to-square" ></i></button> 
											<a href="#"
												class="btn btn-outline-danger"><i
													class="fa-solid fa-circle-minus"></i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div id="box-toast" class="position-fixed top-0 end-0 p-3 w-25 mt-5" style="z-index: 11"></div>
			</main>

			<jsp:include page="/common/admin/footer.jsp"></jsp:include>

			<div class="modal" id="AddOrUpdate" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Edit Airport</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<form:form id="formSubmit" modelAttribute="route">
							<div class="modal-body">
								<div class="mb-3 box-id">
									<label for="id" class="col-form-label">ID Route</label>
									<form:input path="id" disabled="" class="form-control"/>
								</div>
								<div class="row mb-3">
									<div class="col-lg-6">
											<label for="from" class="fw-bold">From</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<button
													class="border border-end-0 bg-white rounded-start p-2 text-muted">
													<i class="fa-solid fa-plane-departure"></i>
												</button>
											</div>
											<form:select path="codeFrom" class="form-select">
												<option
													<c:if test="${empty MODEL.id}">selected="selected"</c:if>
													value="">Select Airport Take-off</option>
												<c:forEach var="item" items="${AIRPORT}">
													<option
														<c:if test="${MODEL.getRouteDTO().getCodeFrom() == item.code}">selected="selected"</c:if>
														value="${item.code}">${item.country}( ${item.code} )</option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col-lg-6">
										<label for="from" class="fw-bold">To</label>
                                               <div class="input-group">
                                                  <div class="input-group-prepend">
                                                    <button class="border border-end-0 bg-white rounded-start p-2 text-muted">
                                                        <i class="fa-solid fa-plane-arrival"></i></button>
                                                   </div>
                                                   <form:select path="codeTo" class="form-select" aria-label="Default select example">
	                                                   <option <c:if test="${empty MODEL.id}">selected="selected"</c:if> value="">Select Airport Landing</option>
                                                       <c:forEach var="item" items="${AIRPORT}">
                                                       		<option <c:if test="${MODEL.getRouteDTO().getCodeTo() == item.code}">selected="selected"</c:if> 
                                                       				value="${item.code}">${item.country} ( ${item.code} )</option>
                                                       </c:forEach>
                                                    </form:select>
                                                </div>
									</div>
								</div>
								<div class="mb-3">
									<label for="description" class="col-form-label">Status</label>
									<div class="form-group">
										<div class="btn-group" role="group"
											aria-label="Basic radio toggle button group">
											<input type="radio" value="1" class="btn-check" name="status"
												id="status1" autocomplete="off" checked="checked"
												<c:if test="${item.status == 1}">checked</c:if> /> <label
												class="btn btn-outline-success" for="status1">Active</label>

											<input type="radio" value="0" class="btn-check" name="status"
												id="status2" autocomplete="off"
												<c:if test="${item.status == 0}">checked</c:if> /> <label
												class="btn btn-outline-danger" for="status2">Stop</label>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<input id="btnAddorUpdate" type="submit" value="ADD Airline"
									data-bs-dismiss="modal" class="btn btn-success">
							</div>
						</form:form>
			
					</div>
				</div>
			</div>
		
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
<%-- 	<c:url var="routeAPI" value="/api/route"></c:url>
	<script type="text/javascript" src="<c:url value="/template/admin/js/route-js.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<script type="text/javascript">
	
		$('#btnAddorUpdate').click(function(e) {
			 e.preventDefault();
		     var data = {};
		     var formData = $('#formSubmit').serializeArray();
		     $.each(formData, function (i, v) {
		        data[""+v.name+""] = v.value;
		     });
	       	   var id = $('#id').val(); 
	           console.log(id)
		      	if (id == "") { 
		      		addRoute(data);
		       	} else {
		           data.id = id;
		           updateRoute(data);
		       	} 
		})
		
		function addRoute(param) {
            	$.ajax({
                    url: "${routeAPI}",
                    method: "POST",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    success: function (result) {
                    	showMessage('add_success', 'Route');
                    	console.log(result)
                    },
                    error: function (error) {
                    	showMessage('add_error', 'Route'); 
                    }
                })
            }
		function updateRoute(param) {
            	$.ajax({
                    url: "${routeAPI}",
                    method: "PUT",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    success: function (result) {
                    	showMessage('add_success', 'Route');
                    	console.log(result)
                    },
                    error: function (error) {
                    	showMessage('add_error', 'Route');
                    }
                })
            }
	</script>
 --%>
</body>
</html>
