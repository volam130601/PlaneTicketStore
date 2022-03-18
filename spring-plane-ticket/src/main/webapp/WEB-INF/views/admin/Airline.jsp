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
<title>Manager of airline</title>

</head>
<body class="sb-nav-fixed">
	<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="/common/admin/Menu.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main id="main_content">
				<div class="container-fluid px-4">
					<h1 class="mt-4">Airline</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Airline</li>
					</ol>
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Airline Table
						</div>
						<div class="card-body">
							<button id="addBtn" class="btn btn-success float-end ms-1"
								data-bs-toggle="modal" data-bs-target="#addOrEditAirlineModal">
								<i class="fa-solid fa-plus"></i>
							</button>
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ID Airline</th>
										<th>Name</th>
										<th>Description</th>
										<th>Logo</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID Airline</th>
										<th>Name</th>
										<th>Description</th>
										<th>Logo</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody >
									<c:forEach var="item" items="${AIRLINE}">
										<tr>
											<td>${item.id}</td>
											<td>${item.name}</td>
											<td>${item.description}</td>
											<td><img alt="logo" src="${item.logo}" width="auto"
												height="50"></td>
											<td id="box-form">
							                    <form id="formSubmit">
							                        <input type="hidden" name="id" value="${item.id}">
													<div class="form-group">
														<div class="btn-group" role="group"
															aria-label="Basic radio toggle button group">
															<input type="radio" value="1"  class="btn-check"
																name="status" id="${item.id}1" autocomplete="off"
																<c:if test="${item.status == 1}">checked</c:if> /> <label
																class="btn btn-outline-success" for="${item.id}1">Active</label>
	
															<input type="radio" value="0"  class="btn-check"
																name="status" id="${item.id}2" autocomplete="off"
																<c:if test="${item.status == 0}">checked</c:if> /> <label
																class="btn btn-outline-danger" for="${item.id}2">Stop</label>
														</div>
													</div>
							                    </form>
											</td>
											<td>
												<button id="editBtn" onclick="getID('${item.id}')"
													class="btn btn-outline-warning" data-bs-toggle="modal"
													data-bs-target="#addOrEditAirlineModal">
													<i class="fa-solid fa-pen-to-square"></i>
												</button> <a
												href="#"
												class="btn btn-outline-danger"><i
													class="fa-solid fa-circle-minus"></i></a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div id="box-toast" class="position-fixed top-0 end-0 p-3 w-25 mt-5"
					style="z-index: 11"></div>
			</main>

			<jsp:include page="/common/admin/footer.jsp"></jsp:include>
			
			<c:url var="urlADD" value="/admin/manager/airline/add" />
			<c:url var="urlEDIT" value="/admin/manager/airline/edit" />
			
			<!-- Modal -->
			<div class="modal" id="addOrEditAirlineModal" tabindex="-1"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Add Airline</h5>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<form:form action="${urlADD}" method="POST"
							modelAttribute="airline">
							<div class="modal-body">
								<div class="row">
									<div class="col-lg-6">
										<div class="mb-3">
											<label for="id" class="col-form-label">ID Airline</label>
											<form:input path="id" cssClass="form-control" />
											<div class="invalid-feedback">Please provide a valid
												ID.</div>
										</div>
									</div>
									<div class="col-lg-6">
										<div class="mb-3">
											<label for="recipient-name" class="col-form-label">Name
												Airline</label>
											<form:input path="name" cssClass="form-control" />
											<div class="invalid-feedback">Please provide a valid
												Name.</div>
										</div>
									</div>
								</div>
								<div class="mb-3">
									<label for="description" class="col-form-label">Description</label>
									<form:textarea path="description" cssClass="form-control" />
									<div class="invalid-feedback">Please provide a valid
										Description.</div>
								</div>
								<div class="mb-3">
									<label for="logo" class="col-form-label">Logo</label>
									<form:input path="logo" cssClass="form-control" />
									<div class="invalid-feedback">Please provide a address
										image.</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-bs-dismiss="modal">Close</button>
								<input id="btnAddorUpdate" type="submit" value="ADD Airline"
									class="btn btn-success">
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
	<c:url var="airlineAPI" value="/api/airline"></c:url>
	<input type="hidden" id="message" value="${message}">
	<script type="text/javascript">
		$(document).ready(function() {
			  var message = $('#message').val();
			  if(message == 'add_success') {
				  showMessage('add_success', 'Airline');
			  } else if(message == 'update_success'){
				  showMessage('update_success', 'Airline');
			  } eles if(message == 'add_error') {
				  showMessage('add_error', 'Airline');
			  }
			  
			  
		  })
		function getID(param) {
			$(`input[id='${param}']`).val("UPDATE Airline");
			$.ajax({
				url : '${airlineAPI}',
				type : 'POST',
				data : {
					id : param
				},
				success : function(data) {
					$(`input[id='id']`).val(data.id);
					/* $(`input[id='id']`).attr('disabled','disabled'); */
					$(`input[id='name']`).val(data.name);
					$(`textarea[id='description']`).val(data.description);
					$(`input[id='logo']`).val(data.logo);
				},
				error : function() {
					console.log(error);
				}
			});
		}
		$(function() {
			$('#addBtn').click(function() {
				var message = $('#message').val();
				$('form').attr('action', '${urlADD}?message=add_success')
				$('#btnAddorUpdate').val("ADD Airline");

				$('input[id="id"]').val('');
				/* $('input[id="id"]').removeAttr('disabled') */
				$('input[id="name"]').val('');
				$('textarea[id="description"]').val('');
				$('input[id="logo"]').val('');
			})
			$('button[id="editBtn"]').click(function() {
				$('form').attr('action', '${urlEDIT}?message=update_success')
				$('#btnAddorUpdate').val("UPDATE Airline");
			})
		});
	</script>
	<c:url var="airlineAPI_UpdateStatus" value="/api/airline/status"></c:url>
	<script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<script type="text/javascript">
		/*Update Status Airline */
		$(document).ready(function () {
			$('input[type="radio"]').on('click',function () {
				 var temp = $('form[id*="formSubmit"]').serializeArray();
	             var data2 = []
	             $.each(temp, function (index, value) { 
	                 if(value.name == 'id') {
	                     data2.push(temp.slice(index , index + 2));
	                 }
	             });
	             var data = [];
	             $.each(data2, function (index, value) { 
	                 var str = {};
	                 $.each(value, function (j, val) {
	                     if(val.name == 'id') {
	                         str.id = val.value;
	                     }else {
	                         str.status = val.value;
	                     }
	                 });
	                 data.push(str);
	             });
	             console.log(data)
	            $.ajax({
					url : '${airlineAPI_UpdateStatus}',
					type : 'PUT',
					contentType: 'application/json',
	                dataType: 'json',
	                data: JSON.stringify(data),
					success : function(data) {
						showMessage('update_success', 'Airline');
					},
					error : function() {
						showMessage('update_error', 'Airline');
					}
				});
		    });
		});
	</script>
</body>
</html>
