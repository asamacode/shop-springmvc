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
		<tbody id="tbody">
		
		</tbody>
	</table>
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	        <span class="sr-only">First</span>
	      </a>
	    </li>
	    <li class="page-item"><a class="page-link" href="#">Pre</a></li>
	    <li class="page-item"><a class="page-link" href="#"><span id="page-info"></span></a></li>
	    <li class="page-item"><a class="page-link" href="#">Next</a></li>
	    <li class="page-item">
	      <a class="page-link" href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	        <span class="sr-only">Last</span>
	      </a>
	    </li>
	  </ul>
</nav>
</div>
<script>
$(function() {
	var pageNum = 0;
	var pageCount = 0;
	var pageSize = 8;
	
	$.ajax({
		url:"/pager/customer/page-count",
		success: function(res) {
			pageCount = res;
			$(".pagination a:eq(0)").click();
		}
	})
	
	$(".pagination a:eq(0)").click(function(){
		pageNum = 0;
		$.ajax({
			url:"/pager/customer/page/"+pageNum,
			success: fnSuccess
		})
		return false;
	});
	
	$(".pagination a:eq(1)").click(function(){
		if (pageNum > 0) {
			pageNum--;
			$.ajax({
				url:"/pager/customer/page/"+pageNum,
				success: fnSuccess
			})	
		}
		return false;
	});
	
	$(".pagination a:eq(3)").click(function(){
		if (pageNum < pageCount - 1) {
			pageNum++;
			$.ajax({
				url:"/pager/customer/page/"+pageNum,
				success: fnSuccess
			})	
		}
		return false;
	});
	$(".pagination a:eq(4)").click(function(){
		pageNum = pageCount - 1;
		$.ajax({
			url:"/pager/customer/page/"+pageNum,
			success: fnSuccess
		})
		return false;
	});
	
	function fnSuccess(res) {
		$("#tbody").html("");
		$(res).each(function(index, user) {
			var tr = $("<tr/>");
			$("<td/>").html(user.id).appendTo(tr);
			$("<td/>").html(user.fullName).appendTo(tr);
			$("<td/>").html(user.email).appendTo(tr);
			$("<td/>").html(user.actived?'Yes':'No').appendTo(tr);
			$("<td/>").html(user.admin?'Admin':'User').appendTo(tr);
			
			var s = `<td>
				<a class="btn btn-sm btn-info" href="${base}/edit/`+user.id+`" >Edit</a>
				<a class="btn btn-sm btn-danger" href="${base}/delete/`+user.id+`">Delete</a>
			</td>`;
			
			$(s).appendTo(tr);
			tr.appendTo("#tbody");
			
			$("#page-info").html((pageNum + 1)+"/"+pageCount);
		})
	}
});

</script>