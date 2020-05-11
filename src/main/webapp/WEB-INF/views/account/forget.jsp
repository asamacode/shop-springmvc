<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<h2>Forget password</h2>
<h4>${message}</h4>
	<form action="/account/forget" method="post">
<div class="form-group">
	<label>Username: </label>
	<input name="id" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Email: </label>
	<input name="email" type="email" class="form-control" />
</div>

<div class="form-group">
	<button class="btn btn-primary">Retrieve Password</button>
</div>
</form>
</div>
</div>