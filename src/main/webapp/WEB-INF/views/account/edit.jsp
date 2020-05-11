<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="card col-sm-12 div-wrapper d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<h2>Edit Account</h2>
<h4>${message}</h4>
	<form:form action="/account/edit" modelAttribute="form" enctype="multipart/form-data">
<div class="form-group">
	<label>Username: </label>
	<form:input path="id" type="text" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Fullname: </label>
	<form:input path="fullName" type="text" class="form-control" />
</div>

<div class="form-group">
	<label>Email: </label>
	<form:input path="email" type="text" class="form-control" readonly="true"/>
</div>

<div class="form-group">
	<label>Photo: </label>
	<img src="/resources/images/customers/${form.photo}" style="width: 80px;height: 90px" />
	<input type="file" name="photo_file" />
	<form:hidden path="photo" class="form-control" />
</div>

<div class="form-group">
	<form:hidden path="password" class="form-control" />
	<form:hidden path="actived" class="form-control" />
	<form:hidden path="admin" class="form-control" />
	<button class="btn btn-primary">Update</button>
</div>
</form:form>
</div>
</div>