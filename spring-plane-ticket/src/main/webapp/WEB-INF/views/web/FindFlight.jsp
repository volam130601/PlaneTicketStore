<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport"
		content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>Find Flight</title>
</head>
<body>
	<jsp:include page="/common/web/header.jsp"></jsp:include>
	 <!-- Page Content-->
    <div  class="body-flight">
        <!-- Heading Row-->
        <div class="container">
            <div class="row">
                <div class="">
                    <div class="container text-dark text-center mt-5">
                        <h1>Danh Sách Chuyến Bay</h1>
                    </div>
                </div>
            </div>
            <div class="row m-5">
                <div class="col-lg-12">
                    <div class="card rounded-0 rounded-top">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-lg-9 "> 
                                    <b>
                                    	<c:forEach var="item"  items="${AIRPORT}">
                                    		<c:if test="${item.code == MODEL.codeFrom}">${item.country}</c:if>
                                    	</c:forEach>
                                         ( ${MODEL.codeFrom} )
                                        <i class="fa-solid fa-arrow-right"></i>
                                        <c:forEach var="item"  items="${AIRPORT}">
                                    		<c:if test="${item.code == MODEL.codeTo}">${item.country}</c:if>
                                    	</c:forEach>
                                         ( ${MODEL.codeTo} )</b>
                                    <p class="text-muted m-0"> ${MODEL.dateLeave} | 1 passengers | 
										<c:if test="${MODEL.typePassenger == 1}">Economy</c:if>
										<c:if test="${MODEL.typePassenger == 2}">Business</c:if>
										<c:if test="${MODEL.typePassenger == 3}">First Class</c:if>
									</p>
                                </div>
                                <div class="col-lg-3">
                                    <div class="btn-group float-end" role="group"
                                        aria-label="Basic mixed styles example">
                                        <a href="<c:url value="/web/home"/>" type="button" class="btn btn-danger btn-search-flight">
                                            <i class="fa-solid fa-magnifying-glass"></i> Đổi Chuyến Bay
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <b>Filter:</b>
                            <button class="btn btn-filter">Điểm dừng<i class="fa-solid fa-caret-down"></i></button>
                            <button class="btn btn-filter">Thời gian bay<i class="fa-solid fa-caret-down"></i></button>
                            <button class="btn btn-filter">Hãng Hàng Không<i
                                    class="fa-solid fa-caret-down"></i></button>
                            <button class="btn btn-filter float-end">Sắp xếp<i
                                    class="fa-solid fa-caret-down"></i></button>
                        </div>
                    </div>
                </div>
                <div id="list-flight">
                	<c:forEach var="item" items="${FLIGHT}">
	                    <div class="card mt-3">
	                        <div class="card-body">
	                            <div class="card-flight">
	                                <div class="row">
	                                    <div class="col-lg-9">
	                                        <div class="row">
	                                            <div class="col-lg-5">
	                                                <div class="card-body_airlines">
	                                                    <div class="airline-img">
	                                                        <img src="${item.getPlaneDTO().getAirlineDTO().getLogo()}" alt="Image Airlines">
	                                                    </div>
	                                                    <b class="ml-10px fs-5">${item.getPlaneDTO().getAirlineDTO().getName()}</b>
	                                                </div>
	                                            </div>
	                                            <div class="col-md-auto">
	                                                <div class="card-body_route-flight">
	                                                    <div class="route-content">
	                                                        <p>${item.dateStart.substring(11)}</p>
	                                                        <span>${item.getRouteDTO().getCodeFrom()}</span>
	                                                    </div>
	                                                    <div class="route-content_middle">
	                                                        <p>1h 25m</p>
	                                                        <div class="route-line"></div>
	                                                        <span>Bay thẳng</span>
	                                                    </div>
	                                                    <div class="route-content">
	                                                        <p>${item.dateEnd.substring(11)}</p>
	                                                        <span>${item.getRouteDTO().getCodeTo()}</span>
	                                                    </div>
	                                                </div>
	                                            </div>
	                                        </div>
	                                        <div class="row"></div>
	                                    </div>
	                                    <div class="col-md-auto flex-grow-1">
	                                        <div class="flight-body-right">
	                                            <div class="airline-money">
	                                                <p><b>$</b>/pax</p>
	                                                <p><b> $</b>/pax</p>
	                                            </div>
	                                            <a href="#" class="btn btn-success mt-2">Choose</a>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
                	
                	</c:forEach>
                </div>
            </div>
        </div>
	<jsp:include page="/common/web/footer.jsp"></jsp:include>	
    </div>
</body>
</html>