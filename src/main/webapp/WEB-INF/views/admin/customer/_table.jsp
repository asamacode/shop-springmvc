<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="row">

	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Activated</th>
				<th>Role</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="c" items="${list}">
			<tr>
				<td>${c.id}</td>
				<td>${c.fullName}</td>
				<td>${c.email}</td>
				<td>${c.actived?'Yes':'No'}</td>
				<td>${c.admin?'Admin':'User'}</td>
				<td>
					<a class="btn btn-sm btn-info" href="${base}/edit/${c.id}" >Edit</a>
					<a class="btn btn-sm btn-danger" href="${base}/delete/${c.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>