<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<h2>Login</h2>
<h4>${message}${param.message}</h4>
	<form action="/account/login" method="post">
<div class="form-group">
	<label>Username: </label>
	<input name="id" type="text" class="form-control" value="${uid}" />
</div>

<div class="form-group">
	<label>Password: </label>
	<input name="password" type="password" class="form-control" value="${upw}" />
</div>

<div class="form-group">
	<input name="rm" type="checkbox" />
	<label> Remember me</label>
</div>

<div class="form-group">
	<button class="btn btn-primary">Login</button>
</div>
</form>
</div>
</div>