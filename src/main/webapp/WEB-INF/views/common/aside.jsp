<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<c:set var="cart" value="${sessionScope['scopedTarget.cartService']}" />
<div class="card-columns-3">
	<div class="card">
		<h4 class="card-header">Giỏ hàng</h4>
		<div class="card-body">
			<div class="row">
				<img id="cart-img" style=" width: 100px;" class="col-sm-5"
					src="https://img.icons8.com/plasticine/2x/favorite-cart.png" />
				<ul class="col-sm-7 ml-auto">
					<li><b id="cart-count">${cart.count}</b> mặt hàng</li>
					<li><b id="cart-amount"> <f:formatNumber
								value="${cart.amount}" pattern="###,###,###" />
					</b> VNĐ</li>
					<li><a href="/cart/view">Xem giỏ hàng</a></li>
				</ul>
			</div>

		</div>
	</div>
</div>
<style id="cart-css">

</style>