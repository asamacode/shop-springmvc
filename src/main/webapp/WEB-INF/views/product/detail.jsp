<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card">

	<img src="${product.image}" />
	
	<ul>
		<li>Name: ${product.name}</li>
		<li>Price: ${product.price}</li>
		<li>Date: ${product.productDate}</li>
		<li>Quantity: ${product.quantity}</li>
		<li>View count: ${product.viewCount}</li>
		<li>Description: ${product.description}</li>
		<li>Discount: ${product.discount}</li>
	</ul>
</div>