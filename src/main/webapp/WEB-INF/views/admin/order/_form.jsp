<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-12 d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<form:form action="${base}/index" modelAttribute="entity">
	
		<div class="form-group">
			<label>Order Id: </label> 
			<form:input path="id" type="text" class="form-control" readonly="true" placeholder="Auto number" />
		</div>
		
		<div class="form-group">
			<label>Customer: </label> 
			<form:input path="customer.id" type="text" class="form-control" />
		</div>
	
		<div class="form-group">
			<label>Order Date: </label> 
			<form:input path="orderDate" class="form-control" />
		</div>
		
		<div class="form-group">
			<label>Shipping Address: </label> 
			<form:input path="address" class="form-control" />
		</div>
		
		<div class="form-group">
			<label>Total Amount: </label> 
			<form:input path="amount" class="form-control" />
		</div>
		
		<div class="form-group">
			<label>Note: </label> 
			<form:input path="description" class="form-control" />
		</div>
	
		<div class="form-group col text-center">
			<button class="btn btn-primary" formaction="${base}/create">Create</button>
			<button class="btn btn-warning" formaction="${base}/update">Update</button>
			<button class="btn btn-danger" formaction="${base}/delete">Delete</button>
			<a class="btn btn-info" href="${base}/index">Reset</a>
		</div>
	</form:form>
</div>
	<c:if test="${!empty details}">
		<jsp:include page="_detail.jsp" />
	</c:if>
</div>
