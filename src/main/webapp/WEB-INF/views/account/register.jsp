<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<h2>Register</h2>
<h4>${message}</h4>
	<form:form action="/account/register" modelAttribute="form" enctype="multipart/form-data">
<div class="form-group">
	<label>Username: </label>
	<form:input path="id" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Password: </label>
	<form:input path="password" type="password" class="form-control" />
</div>

<div class="form-group">
	<label>Fullname: </label>
	<form:input path="fullName" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Email: </label>
	<form:input path="email" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Photo: </label>
	<input type="file" name="photo_file" />
	<form:hidden path="photo" class="form-control" />
</div>

<div class="form-group">
	<button class="btn btn-primary">Register</button>
</div>
</form:form>
</div>
</div>