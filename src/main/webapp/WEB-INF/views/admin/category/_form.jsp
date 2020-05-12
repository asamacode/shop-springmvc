<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-12 d-flex justify-content-center align-items-center">
	<div class="col-sm-4">
	<form:form action="${base}/index" modelAttribute="entity">
	
		<div class="form-group">
			<label>Id: </label> 
			<form:input path="id" type="text" class="form-control" readonly="true" />
		</div>
		
		<div class="form-group">
			<label>Name: </label> 
			<form:input path="name" type="text" class="form-control" />
		</div>
	
		<div class="form-group">
			<label>Name VN: </label> 
			<form:input path="nameVN" type="text" class="form-control" />
		</div>
	
		<div class="form-group col text-center">
			<button class="btn btn-primary" formaction="${base}/create">Create</button>
			<button class="btn btn-warning" formaction="${base}/update">Update</button>
			<button class="btn btn-danger" formaction="${base}/delete">Delete</button>
			<a class="btn btn-info" href="${base}/index">Reset</a>
		</div>
	</form:form>
</div>
</div>
