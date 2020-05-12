<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="base" value="/admin/product" scope="request"/>

<h2>Product Manager</h2>
<h5 class="badge badge-success">${message}${param.message}</h5>

<jsp:include page="_form.jsp" />

<jsp:include page="_table.jsp" />