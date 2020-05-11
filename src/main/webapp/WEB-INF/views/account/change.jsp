<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<h2>Change password</h2>
	<h4>${message}</h4>
	<form action="/account/forget" method="post">
<div class="form-group">
	<label>Username: </label>
	<input name="id" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Current password: </label>
	<input name="password" type="password" class="form-control" />
</div>

<div class="form-group">
	<label>New password: </label>
	<input name="pw1" type="password" class="form-control" />
</div>

<div class="form-group">
	<label>Confirm New password: </label>
	<input name="pw2" type="password" class="form-control" />
</div>

<div class="form-group">
	<button class="btn btn-primary">Change Password</button>
</div>
</form>
</div>
</div>