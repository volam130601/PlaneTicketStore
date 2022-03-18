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
<title>Manager of Flight</title>
</head>
<body class="sb-nav-fixed">
	<jsp:include page="/common/admin/header.jsp"></jsp:include>
	<div id="layoutSidenav">
		<jsp:include page="/common/admin/Menu.jsp"></jsp:include>
		<div id="layoutSidenav_content">
			<main class="bg-light">
				<div class="container-fluid px-4">
					<h1 class="mt-4">
						<c:if test="${MODEL.id != null}">
	                             UPDATE Plane
	                        </c:if>
						<c:if test="${MODEL.id == null}">
	                             ADD Plane
	                        </c:if>
					</h1>
					<div class="row mt-4">
						<!--Form Edit  -->
						<form:form id="formSubmit" modelAttribute="MODEL">
							<div class="col-lg-8">
								<div class="card">
									<div class="card-body">
										<div class="card">
											<div class="card-body">
												
												<div class="row">
													<div class="col-lg-12">
														<c:if test="${MODEL.id != null}">
															<label for="id"><strong>ID Plane</strong> </label> 
															<form:input path="id" id="idPlane" class="form-control" disabled="true"/>
									                     </c:if>
														<c:if test="${MODEL.id == null}">
															<form:hidden path="id" id="idPlane"/>
									                     </c:if>
													</div>
												</div>
												<div class="row mt-4">
													<div class="col-lg-12">
														<label for="multipleselect"><strong>Airline</strong></label>
														<form:select path="idAirline" class="form-select" >
															<c:forEach var="item" items="${AIRLINE}">
																<option value="${item.id}" <c:if test="${MODEL.idAirline == item.id}">selected="selected"</c:if>>${item.name}</option>
															</c:forEach>
														</form:select>
													</div>
												</div>
												<div class="row mt-4">
													<div class="col-lg-4">
														<label for=""><strong>Factory</strong> </label> 
														<form:select class="form-select" path="factory">
															<option value="Airbus"  <c:if test="${MODEL.factory == 'Airbus'}">selected="selected"</c:if>>Airbus</option>
															<option value="Boeing" <c:if test="${MODEL.factory == 'Boeing'}">selected="selected"</c:if>>Boeing</option>
														</form:select>
													</div>
													<div class="col-lg-4">
														<label for="totalSeat"><strong>Total Seat</strong> </label> 
														<form:input path="totalSeat" value="200" class="form-control" />													
													</div>
													<div class="col-lg-4">
															<strong>Status</strong>
															<div class="form-group">
											                        <div class="btn-group" role="group" aria-label="Basic radio toggle button group"> 
											                        	<c:if test="${MODEL.id == null}">
											                        		<input value="1" type="radio" class="btn-check" name="status" id="btnradio1" autocomplete="off" checked/>
												                            <label class="btn btn-outline-success" for="btnradio1">Active</label>
												                          
												                            <input value="0" type="radio" class="btn-check" name="status" id="btnradio2" autocomplete="off" />
												                            <label class="btn btn-outline-danger" for="btnradio2">Stop</label>
											                        	</c:if>
											                        	<c:if test="${MODEL.id != null}">
												                            <input value="1" type="radio" class="btn-check" name="status" id="btnradio1" autocomplete="off" <c:if test="${MODEL.status == 1}">checked</c:if>/>
												                            <label class="btn btn-outline-success" for="btnradio1">Active</label>
												                          
												                            <input value="0" type="radio" class="btn-check" name="status" id="btnradio2" autocomplete="off" <c:if test="${MODEL.status == 0}">checked</c:if>/>
												                            <label class="btn btn-outline-danger" for="btnradio2">Stop</label>
											                        	</c:if>
											                          </div>
               												 </div>
													</div>
												</div>
												<div class="row mt-4">
		                                           <div class="col-lg-4">
		                                               <a href="<c:url value="/admin/plane/list"/>" class="btn btn-dark">Back</a>
		                                           </div>
		                                           <div class="col"></div>
		                                            <div class="col-lg-4 ">
		                                            	<c:if test="${not empty MODEL.id}">
			                                                <button id="btnAddorEditFlight" class="btn btn-primary float-end">UPDATE Plane</button>
		                                            	</c:if>
		                                            	<c:if test="${empty MODEL.id}">
			                                                <button id="btnAddorEditFlight" class="btn btn-primary float-end">ADD Plane</button>
		                                            	</c:if>
		                                            </div>
		                                       	</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</form:form>
						<div class="col"></div>
					</div>
				</div>
				<div id="box-toast" class="position-fixed top-0 end-0 p-3 w-25 mt-5"
					style="z-index: 11"></div>
			</main>
			<jsp:include page="/common/admin/footer.jsp"></jsp:include>

		</div>
	</div>
	<script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<c:url var="planeAPI" value="/api/plane"/>
	<c:url var="planeLIST" value="/admin/plane/list"/>
	<script type="text/javascript">
		$('#btnAddorEditFlight').click(function(e) {
			 e.preventDefault();
		     var data = {};
		     var formData = $('#formSubmit').serializeArray();
		     $.each(formData, function (i, v) {
		        data[""+v.name+""] = v.value;
		     });
		     console.log(data);
		     /* var flag = checkNull(data);
		     console.log(flag);*/
		     	var id = $('#idPlane').val();
			     if (id == "") { 
			        addPlane(data);
			         console.log('add')
			     } else {
			    	 data.id = id;
			         updatePlane(data); 
			         console.log('edit');
			     }
		})	
		
		function addPlane(param) {
            	$.ajax({
                    url: "${planeAPI}",
                    method: "POST",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    success: function (result) {
                    	showMessage('add_success', 'Plane');
                    },
                    error: function (error) {
                    	showMessage('add_error', 'Plane');
                    }
                })
            }
		function updatePlane(param) {
            	$.ajax({
                    url: "${planeAPI}",
                    method: "PUT",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    success: function (result) {
                    	showMessage('add_success', 'Plane');
                    	setTimeout(() => {
                            window.location.href = '${planeLIST}';
                        }, 3000);
                    },
                    error: function (error) {
                    	showMessage('add_error', 'Plane');
                    }
                })
            }
	</script>
</body>
</html>
