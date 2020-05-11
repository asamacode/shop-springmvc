<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">

<div class="col-sm-4">
	<h2>ORDER INFO</h2>
<h4>${message}</h4>
	<form:form action="/order/checkout" modelAttribute="order">
<div class="form-group">
	<label>Order Id: </label>
	<form:input path="id" type="text" class="form-control" readonly="true" />
</div>
	
<div class="form-group">
	<label>Customer: </label>
	<form:input path="customer.id" type="text" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Order date: </label>
	<form:input path="orderDate" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Shipping address: </label>
	<form:input path="address" type="text" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Total amount: </label>
	<form:input path="amount" type="text" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Note: </label>
	<form:textarea path="description" rows="3" class="form-control" readonly="true"/>
</div>

</form:form>
</div>
<h2>ORDER DETAIL</h2>
<table class="table">
	<thead>
	<tr>
		<th scope="col">Id</th>
	    <th scope="col">Name</th>
	    <th scope="col">Price</th>
	    <th scope="col">Discount</th>
		<th scope="col">Quantity</th>
		<th scope="col">Amount</th>
	</tr>
	</thead>
	<tbody>
		<c:forEach var="d" items="${details}">
			<tr data-id="${product.id}" data-price="${product.price}" data-discount="${product.discount}">
				<td>${d.product.id}</td>
				<td>${d.product.name}</td>
				<td>${d.unitPrice}</td>
				<td>${d.discount}</td>
				<td>${d.quantity}</td>
				<td id="amount">${product.quantity * product.price * (1-p.discount)}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</div>