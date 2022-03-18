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
<title>Manager of Plane Flight</title>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="/common/admin/Menu.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main id="main_content">
				<div class="container-fluid px-4">
					<h1 class="mt-4">Plane Flight</h1>
					<!-- <ol class="breadcrumb mb-4">
						<li class="breadcrumb-item active">Route</li>
					</ol> -->
					<div class="card mb-4">
						<div class="card-header">
							<i class="fas fa-table me-1"></i> Plane Flight Table
						</div>
						<div class="card-body"> 
							<a href="<c:url value="/admin/plane/edit"/>" class="btn btn-success float-end ms-1">
								<i class="fa-solid fa-plus"></i>
							</a>
							<table id="datatablesSimple">
								<thead>
									<tr>
										<th>ID Plane</th>
										<th>ID Airline</th>
										<th>Factory</th>
										<th>Total Seat</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</thead>
								<tfoot>
									<tr>
										<th>ID Plane</th>
										<th>ID Airline</th>
										<th>Factory</th>
										<th>Total Seat</th>
										<th>Status</th>
										<th>Action</th>
									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="item" items="${PLANE}">
										<tr id="${item.id}">
											<th>${item.id}</th>
											<th>${item.idAirline}</th>
											<th>${item.factory}</th>
											<th>${item.totalSeat}</th>
											<td><span class="text-white p-1 fw-bold border-2 rounded 
												<c:if test="${item.status == 1}">bg-success</c:if>
												<c:if test="${item.status == 0}">bg-danger</c:if>">
												<c:if test="${item.status == 1}">Active</c:if>
												<c:if test="${item.status == 0}">Stopped</c:if>
											</span></td>
											<td>
												<a href="<c:url value="/admin/plane/edit?id=${item.id}"/>" class="btn btn-outline-warning"><i class="fa-solid fa-pen-to-square"></i></a>
												<button onclick="deletePlane('${item.id}')" class="btn btn-outline-danger"><i class="fa-solid fa-circle-minus"></i></button>
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
			<input type="hidden" id="message" value="${message}">
			<jsp:include page="/common/admin/footer.jsp"></jsp:include>
	
		</div>
	</div>
	<script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<c:url var="planeAPI" value="/api/plane"/>
	<script type="text/javascript">
		  $(document).ready(function() {
			  var message = $('#message').val();
			  if(message == 'delete-success') {
				  showMessage('delete_success', 'Plane');
			  }
			  
		  })
		  function deletePlane(param) {
	      	$.ajax({
	              url: "${planeAPI}/"+param,
	              method: "DELETE",
	              success: function (result) {
	            	if(result != '') {
		        	  	$(`tr[id="\${result}"]`).remove(); 
                        window.location.href = '${planeLIST}?message=delete-success';
		            	/* setTimeout(() => {
		            		showMessage('delete_success', 'Plane');
                        }, 3000); */
	            	}
	              },
	              error: function (error) {
	            	  showMessage('delete_error', 'Plane')
	              }
	          })
	     	};
			
	</script>
</body>
</html>
