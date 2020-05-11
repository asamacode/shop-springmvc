<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<h2>Shopping Cart</h2>
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
		<c:forEach var="product" items="${sessionScope['scopedTarget.cartService'].items}">
			<tr data-id="${product.id}" data-price="${product.price}" data-discount="${product.discount}">
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.price}</td>
				<td>${product.discount}</td>
				<td>
					<input min="1" type="number" value="${product.quantity}" style="width:70px;" />
				</td>
				<td id="amount">${product.quantity * product.price * (1-p.discount)}</td>
				<td>
					<button class="btn btn-sm btn-warning btn-cart-remove">
						<i class="fa fa-trash" aria-hidden="true"></i>
					</button>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<button class="btn btn-sm btn-danger btn-cart-clear">Clear</button>
<button class="btn btn-sm btn-info">Continue</button>
<button class="btn btn-sm btn-success">Check out</button>