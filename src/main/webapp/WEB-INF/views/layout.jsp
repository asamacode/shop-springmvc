<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!doctype html>
<html lang="en">

<head>
    <title>A SaMa Web</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="<c:url value='/resources/css/asama.css' />" rel="stylesheet" />
<link href="<c:url value='/resources/jqueryui/jquery-ui.min.css' />" rel="stylesheet" />
   	
</head>

<body>

    <div class="container-fluid">

        <header class="row">
            <tiles:insertAttribute name="head" />
        </header>

        <tiles:insertAttribute name="menu" />

        <div class="row">
        	<article class="col-sm-9">
        		<tiles:insertAttribute name="body" />
        	</article>

            <aside class="col-sm-3">
                
                <tiles:insertAttribute name="aside"/>
                
                <tiles:insertAttribute name="category" />
                
            </aside>
        </div>

        <footer class="row">
            <div class="footer text-center">
                <label>Copyright &copy A SaMa 2020</label>
            </div>
        </footer>
    </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->

    <script src="<c:url value='/resources/js/jquery-3.4.1.min.js' /> "></script>
    <script src="<c:url value='/resources/jqueryui/jquery-ui.min.js' /> "></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
        <script src="<c:url value='/resources/js/asama.js' /> "></script>
</body>

</html>