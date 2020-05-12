<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="col-sm-12 d-flex justify-content-center align-items-center">
	<div class="col-sm-8">
	<form:form action="${base}/index" modelAttribute="entity" enctype="multipart/form-data">
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Id: </label> 
					<form:input path="id" type="text" class="form-control" readonly="${!empty entity.id}"/>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Password: </label> 
					<form:input path="password" type="password" class="form-control" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Name: </label> 
					<form:input path="fullName" type="text" class="form-control" />
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Email: </label> 
					<form:input path="email" type="email" class="form-control" />
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Role: </label> 
					<div class="form-control">
					<form:radiobutton path="admin" value="true" label="Admin" />
					<form:radiobutton path="admin" value="false" label="User" />
				</div>
		</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
			<label>Activated: </label> 
					<div class="form-control">
						<form:radiobutton path="actived" value="true" label="Yes"  />
						<form:radiobutton path="actived" value="false" label="No"  />
					</div>
				</div>
			</div>
		</div>
		
		<div class="form-group col-sm-12">
			<label>Photo: </label> 
			<img src="/resources/images/customers/${entity.photo}" style="width: 80px;height: 90px" />
			<input name="photo_file" type="file" class="form-control" />
			<form:hidden path="photo" />
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
