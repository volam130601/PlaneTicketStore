<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include  file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no" />
		<meta name="description" content="" />
		<meta name="author" content="" />
		<title></title>
</head>
<body>
    <jsp:include page="/common/web/header.jsp"></jsp:include>
    <!-- Page Content-->
    <div class="content-img">
        <!-- Heading Row-->
        <div class="container">
            <div class="row">
                <div class="">
                    <div class="container text-white text-center mt-5">
                        <h1>Tìm Kiếm Chuyến Bay</h1>
                    </div>
                </div>
            </div>
            <div class="row m-5">
                <div class="">
                    <div class="card">
                        <div class="card-body">
                            <div class="card-header bg-white">
                                <div class="row">
                                    <div class="col-lg-6 position-relative">
                                        <div class="btn-group" role="group"
                                            aria-label="Basic radio toggle button group">
                                            <input type="radio" class="btn-check" name="btnradio" id="btnMotChieu"
                                                autocomplete="off" checked>
                                            <label class="btn btn-outline-primary" for="btnMotChieu">Một Chiều</label>

                                            <input type="radio" class="btn-check" name="btnradio" id="btnKhuHoi"
                                                autocomplete="off">
                                            <label class="btn btn-outline-primary" for="btnKhuHoi">Khứ Hồi</label>
                                        </div>
                                    </div>
                                    <div class="col-lg-6 d-grid gap-2">
                                        <a href="#" class="btn btn-map">
                                            <i class="fa-solid fa-location-dot"></i>
                                            Mở bản đồ</a>
                                    </div>
                                </div>
                            </div>
                            <form id="formSearch">
	                            <div class="card-body">
	                                <div class="row">
	                                    <div class="col-lg-7">
	                                        <div class="row">
	                                            <div class="col-lg-6">
	                                                <label for=""><strong>From</strong> </label>
	                                                <div class="input-group">
	                                                    <span class="input-group-text">
	                                                        <i class="fa-solid fa-plane-departure"></i></span>
	                                                     <select id="codeFrom" name="codeFrom" class="form-select">
	                                                       <c:forEach var="item" items="${AIRPORT}">
	                                                       		<option value="${item.code}">${item.country} ( ${item.code} )</option>
	                                                       </c:forEach>
	                                                    </select>
	                                                </div>
	                                                <div id="messageFrom" class="text-danger"></div>
	                                            </div>
	                                            <div class="col-lg-6">
	                                                <label for=""><strong>To</strong> </label>
	                                                <div class="input-group">
	                                                    <span class="input-group-text"><i class="fa-solid fa-plane-arrival"></i></span>
	                                                      <select id="codeTo" name="codeTo" class="form-select">
	                                                       <c:forEach var="item" items="${AIRPORT}">
	                                                       		<option value="${item.code}">${item.country} ( ${item.code} )</option>
	                                                       </c:forEach>
	                                                    </select>
	                                                </div>
	                                                <div id="messageTo" class="text-danger"></div>
	                                            </div>
	                                        </div>
	                                        <div class="row mt-2">
	                                            <div class="col-lg-6">
	                                                <label for="datetime-local">Date Leave</label>
	                                                <input id="dateLeave" name="dateLeave" class="form-datetime text-muted" type="datetime-local"/>
	                                            	<div id="messageDateGo" class="text-danger"></div>
	                                            </div>
	                                            <div class="col-lg-6 dateTo d-none">
	                                                <label for="datetime-local">Date Come Back</label>
	                                                <input id="dateComeBack" name="dateComeBack" class="form-datetime text-muted" type="datetime-local"/>
	                                            </div>
	                                        </div>
	                                    </div>
	                                    <div class="col-lg-5">
	                                        <label for=""><strong>Loại Khách</strong> </label>
	                                        <div class="input-group">
	                                            <span class="input-group-text"><i class="fa-solid fa-user"></i></span>
	                                            <select id="typePassenger" name="typePassenger" class="form-select" aria-label="Default select example">
	                                                <option selected value="1">Người Lớn</option>
	                                                <option value="2">Trẻ Em</option>
	                                                <option value="3">Em Bé</option>
	                                            </select>
	                                        </div>
	                                        <label class="mt-2"><strong>Hạng Ghế</strong> </label>
	                                        <div class="input-group">
	                                            <span class="input-group-text"><i class="fas fa-chair"></i></span>
	                                            <select id="typeSeat" name="typeSeat" class="form-select" aria-label="Default select example">
	                                                <option selected value="1">Phổ Thông</option>
	                                                <option value="2">Thương Gia</option>
	                                                <option value="3">Hạng Nhất</option>
	                                            </select>
	                                        </div>
	                                    </div>
	                                </div>
	
	                                <div class="row mt-3">
	                                    <div class="col-lg-9"></div>
	                                    <div class="col-lg-3">
	                                        <div class="btn-group" role="group" aria-label="Basic mixed styles example">
	                                            <button id="btnSearch" type="button" class="btn btn-danger btn-search-flight">
	                                                <i class="fa-solid fa-magnifying-glass"></i> Tìm Chuyến Bay
	                                            </button>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<jsp:include page="/common/web/footer.jsp"></jsp:include>
    	
    <script type="text/javascript" src="<c:url value="/template/admin/js/toast.js" />"></script>
	<script type="text/javascript" src="<c:url value="/template/admin/js/format-date-1.js" />"></script>
	<c:url  value="/api/search-flight" var="searchFlightAPI"/>
	<c:url  value="/web/find-flight" var="findFlight"/>
	<c:url  value="/web/setCookie" var="setCookie"/>
    <script>
        $('input:radio[id="btnMotChieu"]').change(function () {
            $('.dateTo').addClass('d-none');
        });
        $('input:radio[id="btnKhuHoi"]').change(function () {
            $('.dateTo').removeClass('d-none');
        });
    </script>
    <script type="text/javascript">
	    $("#codeTo option:nth-child(2)").prop("selected", true)
	    $("#btnSearch").click(function() {
	    	var codeFrom = $('#codeFrom').val();
	    	var codeTo = $('#codeTo').val();
	    	var dateLeave = $('#dateLeave').val();
	    	var data = {};
		     var formData = $('#formSearch').serializeArray();
		     $.each(formData, function (i, v) {
		    	 if(v.name == 'dateLeave') {
		    		 v.value = formatDateLocal(v.value);
		    	 } 
		    	 if(v.name == 'dateComeBack') {
		    		 if(v.value != '') {
			    		 v.value = formatDateLocal(v.value);
		    		 } else {
		    			v.value = ""; 
		    		 }
		    	 } 
		        data[""+v.name+""] = v.value;
		     });
		     /* console.log(data); */
		     var flag = 0;
	    	 if(codeFrom == codeTo) {
	                $('#messageFrom').html('Not Same Airport!');
	                $('#messageTo').html('Not Same Airport!');
	                flag = 1;
	          } else if(codeFrom != codeTo){
	                $('#messageFrom').html('');
	                $('#messageTo').html('');
	                flag = 0
	          }
	       	  if(dateLeave == "") {
	        	  $('#messageDateGo').html('Date Go is not valid!')
	        	  flag = 1;
	          } else {
	        	  $('#messageDateGo').html('')
	        	  flag = 0
	          }
	    	 
	    	 if(flag == 0) {
	        	searchFlight(data); 
	        	/* window.location.href = "${findFlight}"; */
	         } else {
	        	 console.log('Error');
	         }
	    });
	     function searchFlight(param) {
	    	 var flag = 0;
	    	 $.ajax({
                url: "${setCookie}",
                method: "POST",
                contentType: 'application/json',
                dataType: 'json',
                data: JSON.stringify(param),
                success: function (result, txtStatus) {
                },
                error: function (error) {
                	console.log(error)
                	/* showMessage('add_error', 'Flight'); */
                }
            });
	    	 var i = 1;
	         setInterval(() => {
	             console.log(i++);
	         }, 100);
	         setTimeout(() => {
	        	 window.location.href = "${findFlight}";
	         }, 1000);
	    } 
    </script>
</body>

</html>