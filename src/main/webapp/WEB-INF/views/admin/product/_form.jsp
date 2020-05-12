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
					<form:input path="id" type="text" class="form-control" readonly="true" placeholder="Auto number"/>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Name: </label> 
					<form:input path="name" type="text" class="form-control" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Price: </label> 
					<form:input path="price" class="form-control" />
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<label>Quantity: </label> 
					<form:input path="quantity" type="number" class="form-control" />
				</div>
			</div>
		</div>
	
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<div class="form-group">
					<label>Discount: </label> 
					<form:input path="discount" type="number" class="form-control" />
				</div>
				</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
					<div class="form-group">
						<label>Date: </label> 
						<form:input path="productDate" class="form-control" />
					</div>
			</div>
		</div>
		</div>
		
		<div class="row">
			<div class="col-sm-6">
				<div class="form-group">
					<label>Special? </label> 
					<div class="form-control">
					<form:radiobutton path="special" value="true" label="Special" />
					<form:radiobutton path="special" value="false" label="Normal" />
				</div>
		</div>
			</div>
			<div class="col-sm-6">
				<div class="form-group">
			<label>Available? </label> 
					<div class="form-control">
						<form:radiobutton path="available" value="true" label="Available"  />
						<form:radiobutton path="available" value="false" label="Not Available"  />
					</div>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-sm-4">
				<div class="form-group">
					<div class="form-group">
					<label>View count: </label> 
					<form:input path="viewCount" type="number" class="form-control" />
				</div>
				</div>
			</div>
			<div class="col-sm-4">
				<div class="form-group">
					<div class="form-group">
					<label>Category: </label> 
					<form:select path="category.id" class="form-control">
						<form:options items="${cates}" itemLabel="nameVN" itemValue="id"/>
					</form:select>
				</div>
				</div>
			</div>
			<div class="col-sm-4">
				<label>Image: </label> 
				<img src="/resources/images/products/${entity.image}" style="width: 80px;height: 90px" />
				<input name="photo_file" type="file" class="form-control" />
				<form:hidden path="image" />
			</div>
		</div>
		
		<div class="form-group col-sm-12">
			<div class="form-group">
					<div class="form-group">
						<label>Description: </label> 
						<form:textarea path="description" class="form-control" rows="5"/>
					</div>
			</div>
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

