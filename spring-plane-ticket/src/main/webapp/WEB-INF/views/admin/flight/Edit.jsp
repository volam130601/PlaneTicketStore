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
			    <main class="bg-light">
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">
							<c:if test="${MODEL.id != null}">
	                             UPDATE Flight
	                        </c:if>	
							<c:if test="${MODEL.id == null}">
	                             ADD Flight
	                        </c:if>	
						</h1>
                        <div class="row">
                        <!--Form Edit  -->
                        <form:form id="formSubmit" modelAttribute="MODEL">
                            <div class="col-lg-8">
                                <div class="card">
                                    <div class="card-body">
                                    	<div class="row mb-4">
                                    		<div class="col-lg-12">
	                                    		<c:if test="${MODEL.id != null}">
	                                    			<form:input path="id" id="flightID" disabled="true" cssClass="form-control"/>
	                                    		</c:if>
	                                    		<c:if test="${MODEL.id == null}">
		                                    		<form:hidden path="id" id="flightID"/>
	                                    		</c:if>
                                    		</div>
                                    	</div>
                                       <div class="row mb-4">
                                           <div class="col-lg-6">
                                               <label for="from" class="fw-bold">From</label>
                                               <div class="input-group">
                                                  <div class="input-group-prepend">
                                                    <button class="border border-end-0 bg-white rounded-start p-2 text-muted">
                                                        <i class="fa-solid fa-plane-departure"></i></button>
                                                   </div>
                                                   <form:select path="codeFrom" class="form-select">
	                                                   <option <c:if test="${empty MODEL.id}">selected="selected"</c:if> value="">Select Airport Take-off</option>
                                                       <c:forEach var="item" items="${AIRPORT}">
                                                       		<option <c:if test="${MODEL.getRouteDTO().getCodeFrom() == item.code}">selected="selected"</c:if>  
                                                       				value="${item.code}">${item.name} ( ${item.code} )</option>
                                                       </c:forEach>
                                                    </form:select>
                                                </div>
                                                <span id="messageFrom_1" class="text-danger d-none">Select Airport not valid!</span>
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
                                                       				value="${item.code}">${item.name} ( ${item.code} )</option>
                                                       </c:forEach>
                                                    </form:select>
                                                </div>
                                                <span id="messageFrom_2" class="text-danger d-none">Select Airport not valid!</span>
                                           </div>
                                       </div>
                                       <div class="row mb-4">
                                           <div class="col-lg-6">
                                                <label for="dateStart" class="fw-bold">Date Start</label>
                                                <form:input path="dateStart" type="datetime-local" class="form-control text-muted"/>
                                                <span id="messageDate_1" class="text-danger d-none">Date not valid!</span>
                                           </div>
                                           <div class="col-lg-6">
                                                <label for="dateEnd" class="fw-bold">Date Start</label>
                                                <form:input path="dateEnd" type="datetime-local" class="form-control text-muted"/>
                                                <span id="messageDate_2" class="text-danger d-none">Date not valid!</span>
                                           </div>
                                       </div>
                                       <div class="row mb-4">
                                            <div class="col-lg-12">
                                                <label for="from" class="fw-bold">Plane</label>
                                                <div class="input-group">
                                                <div class="input-group-prepend">
                                                    <button class="border border-end-0 bg-white rounded-start p-2 text-muted">
                                                        <i class="fa-solid fa-plane-arrival"></i></button>
                                                    </div>
                                                    <form:select path="idPlane" class="form-select">
	                                                   <option <c:if test="${empty MODEL.id}">selected="selected"</c:if> value="">Select Plane</option>
                                                       <c:forEach var="item" items="${PLANE}">
                                                       		<option <c:if test="${MODEL.getPlaneDTO().getId() == item.id}">selected="selected"</c:if> 
                                                       				value="${item.id}">${item.factory} ${item.id}</option>
                                                       </c:forEach>                                                      
                                                    </form:select>
                                                </div>
                                                 <span id="messageplane" class="text-danger d-none">Plane not valid!</span>
                                            </div>
                                       </div>
                                       <div class="row mb-4">
                                            <div class="col-lg-4">
                                                <label for="from" class="fw-bold">Economy</label>
                                                <form:input path="economy" type="text" class="form-control"/>
                                             	<span id="messageprice-1" class="text-danger d-none">Price Economy not valid!</span> 
                                            </div>
                                            <div class="col-lg-4">
                                                <label for="from" class="fw-bold">Business</label>
                                                <form:input path="business" type="text" class="form-control"/>
                                             	<span id="messageprice-2" class="text-danger d-none">Price Business not valid!</span> 
                                            </div>
                                            <div class="col-lg-4">
                                                <label for="from" class="fw-bold">First Class</label>
                                                <form:input path="firstClass" type="text" class="form-control"/>
                                             	<span id="messageprice-3" class="text-danger d-none">Price First Class not valid!</span> 
                                            </div>
                                            <c:if test="${not empty MODEL.id}">
	                                            <form:hidden path="idPriceSeat" value="${MODEL.idPriceSeat}"/>
                                            </c:if>
                                       </div>
                                       <div class="row mb-4">
                                           <div class="col-lg-4">
                                               <a href="<c:url value="/admin/flight/list"/>" class="btn btn-dark">Back</a>
                                           </div>
                                           <div class="col"></div>
                                            <div class="col-lg-4 ">
                                            	<c:if test="${not empty MODEL.id}">
	                                                <button id="btnAddorEditFlight" class="btn btn-primary float-end">UPDATE Flights</button>
                                            	</c:if>
                                            	<c:if test="${empty MODEL.id}">
	                                                <button id="btnAddorEditFlight" class="btn btn-primary float-end">ADD Flights</button>
                                            	</c:if>
                                            </div>
                                       </div>
                                    </div>
                                </div>
							</div>
					</form:form>
                            <div class="col"></div>
                        </div>
                    </div>
                    <div id="box-toast" class="position-fixed top-0 end-0 p-3 w-25 mt-5" style="z-index: 11"></div>
                </main>
			<jsp:include page="/common/admin/footer.jsp"></jsp:include>

		</div>
	</div>
	<script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<script type="text/javascript" src="<c:url value="/template/admin/js/format-date-1.js" />"></script>
	<script>
		$(function() {
			var flag = '${MODEL.id}';
			if(flag != null) {
				let dateStart = formatDateLocal('${MODEL.dateStart}');
				let dateEnd = formatDateLocal('${MODEL.dateEnd}');
				
				var nowDateStart = new Date(dateStart);
				nowDateStart.setMinutes(nowDateStart.getMinutes() - nowDateStart.getTimezoneOffset());
				var dS = nowDateStart.toISOString().slice(0,16)
				$('#dateStart').val(dS)
				
				var nowDateEnd = new Date(dateEnd);
				nowDateEnd.setMinutes(nowDateEnd.getMinutes() - nowDateEnd.getTimezoneOffset());
				var dE = nowDateEnd.toISOString().slice(0,16)
				$('#dateEnd').val(dE)
			}
		})
		$('#dateStart').focusout( function() {
            var date = formatDateLocal($('#dateStart').val());
            var dateStart = new Date(date);
            dateStart.setMinutes(dateStart.getMinutes() - dateStart.getTimezoneOffset());
            document.getElementById('dateStart').value = dateStart.toISOString().slice(0, 16);
            
            var dateEnd = dateAdd(new Date(date), 'hour', 1.4166666666666666666);
            console.log(dateEnd)
            dateEnd.setMinutes(dateEnd.getMinutes() - dateEnd.getTimezoneOffset());
            document.getElementById('dateEnd').value = dateEnd.toISOString().slice(0, 16);
        });
	
		$('#btnAddorEditFlight').click(function(e) {
			 e.preventDefault();
		     var data = {};
		     var formData = $('#formSubmit').serializeArray();
		     $.each(formData, function (i, v) {
		    	 if(v.name == 'dateStart' || v.name == 'dateEnd') {
		    		 v.value = formatDateLocal(v.value);
		    	 }
		        data[""+v.name+""] = v.value;
		     });
		     var flag = checkNull(data);
		     console.log(flag);
		     if(flag == true) {
			     var id = $('#flightID').val();
			     if (id == "") { 
			         addFlight(data);
			     } else {
			    	 data.id = id;
			         updateFlight(data);
			     }
		     } else {
		    	 console.log('Error')
		     }
		})
			
            function checkNull(param) {
            	var codeFrom = param.codeFrom;
                var codeTo = param.codeTo;
                var dateStart = param.dateStart;
                var dateEnd = param.dateEnd;
                var plane = param.idPlane;
                var economy = param.economy;
                var business = param.business;
                var firstClass = param.firstClass;
            	
                if(codeFrom == '') {
                    $('#messageFrom_1').removeClass('d-none');
                } else {
                    $('#messageFrom_1').addClass('d-none');
                }
                if(codeTo == '') {
                    $('#messageFrom_2').removeClass('d-none');
                } else {
                    $('#messageFrom_2').addClass('d-none');
                }
                if(dateEnd.includes('NaN') == true) {
                    $('#messageDate_1').removeClass('d-none');
                } else {
                    $('#messageDate_1').addClass('d-none');
                }
                if(dateEnd.includes('NaN') == true) {
                    $('#messageDate_2').removeClass('d-none');
                } else {
                    $('#messageDate_2').addClass('d-none');
                }
                if(plane == '') {
                    $('#messageplane').removeClass('d-none');
                } else {
                    $('#messageplane').addClass('d-none');
                }
                if(economy == '') {
                    $('#messageprice-1').removeClass('d-none');
                } else {
                    $('#messageprice-1').addClass('d-none');
                }
                if(business == '') {
                    $('#messageprice-2').removeClass('d-none');
                } else {
                    $('#messageprice-2').addClass('d-none');
                }
                if(firstClass == '') {
                    $('#messageprice-3').removeClass('d-none');
                } else {
                    $('#messageprice-3').addClass('d-none');
                }
                if(codeFrom != '' && codeTo != '' && dateStart.includes('NaN') == false  
                		&& dateEnd.includes('NaN') == false && plane != '' && economy != ''&& business != ''&& firstClass != '') {
					return true;
                }
               	return false;
            }
            
            function addFlight(param) {
            	$.ajax({
                    url: "${flightAPI}",
                    method: "POST",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    success: function (result) {
                    	 /* $("#formSubmit").trigger("reset"); *///Reset input '' 
                    	showMessage('add_success', 'Flight');
                    },
                    error: function (error) {
                    	showMessage('add_error', 'Flight');
                    }
                })
            }
            
            function updateFlight(param) {
            	$.ajax({
                    url: "${flightAPI}",
                    method: "PUT",
                    contentType: 'application/json',
                    dataType: 'json',
                    data: JSON.stringify(param),
                    success: function (result) {
                    	showMessage('update_success', 'Flight');
                    },
                    error: function (error) {
                    	showMessage('update_error', 'Flight');
                    }
                })
            }
            
          
            
            
        </script>
</body>
</html>
