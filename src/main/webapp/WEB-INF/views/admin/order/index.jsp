<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="base" value="/admin/order" scope="request" />

<h2>Order Manager</h2>
<h5 class="badge badge-success">${message}${param.message}</h5>

<nav>
	<div class="nav nav-tabs" id="nav-tab" role="tablist">
		<a class="nav-item nav-link active" id="nav-home-tab"
			data-toggle="tab" href="#nav-home" role="tab"
			aria-controls="nav-home" aria-selected="true">View Order</a> <a
			class="nav-item nav-link" id="nav-profile-tab" data-toggle="tab"
			href="#nav-profile" role="tab" aria-controls="nav-profile"
			aria-selected="false">List Order</a>
	</div>
</nav>
<div class="tab-content" id="nav-tabContent">
	<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
		aria-labelledby="nav-home-tab">
		<jsp:include page="_form.jsp" />
	</div>
	<div class="tab-pane fade" id="nav-profile" role="tabpanel"
		aria-labelledby="nav-profile-tab">
		<jsp:include page="_table.jsp" />
	</div>
</div>
