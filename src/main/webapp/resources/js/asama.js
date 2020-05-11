$(document).ready(function() {
	$("tr[data-id] input").on("input", function() {
		var id = $(this).closest("tr").attr("data-id");
		var price = $(this).closest("tr").attr("data-price");
		var discount = $(this).closest("tr").attr("data-discount");
		var quantity = $(this).val();
		$.ajax({
			url: `/cart/update/${id}/${quantity}`,
			success: function(response) {
				$("#cart-count").html(response[0]);
				$("#cart-amount").html(response[1]);
			}
		});
		var amt = quantity * price * (1 - discount);
		$(this).closest("tr").find("#amount").html(amt);
	});
	
	$(".btn-star").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url : "/product/add-to-fav/" + id,
			success : function(response) {
				if (response) {
					alert("Đã thêm vào thành công");
				} else {
					alert("Đã có sẵn");
				}
			}
		});
	});

	$(".btn-add-to-cart").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$.ajax({
			url : "/cart/add/" + id,
			success : function(response) {
				$("#cart-count").html(response[0]);
				$("#cart-amount").html(response[1]);
			}
		});
		
		var img = $(this).closest(".thumbnail").find("a>img");
		var cart_css = '.cart-fly {background-image: url("'+img.attr("src")+'");background-size: 100% 100%;}';
		var options = {to: '#cart-img', className: 'cart-fly'}
		$("style#cart-css").html(cart_css);
		img.effect('transfer', options, 1000);
	});

	$(".btn-open-dialog").click(function() {
		var id = $(this).closest("div").attr("data-id");
		$("#exampleModal #id").val(id);
	});

	$("#btn-send").click(function() {
		var form = {
			id : $("#exampleModal #id").val(),
			to : $("#exampleModal #email").val(),
			body : $("#exampleModal #comments").val(),
			from : $("#exampleModal #sender").val()
		}

		$.ajax({
			url : "/product/send-to-friend/",
			data : form,
			success : function(response) {
				if (response) {
					$("[data-dismiss]").click();
					alert("Đã gửi thành công");
				} else {
					alert("Lỗi gửi mail");
				}
			}
		});

	});
	
	$(".btn-cart-clear").click(function() {
		$.ajax({
			url: "/cart/clear",
			success: function(response) {
				$("#cart-count").html(0);
				$("#cart-amount").html(0);
				$("table>tbody").html("");
			}
		});
	});
	
	$(".btn-cart-remove").click(function() {
		var id = $(this).closest("tr").attr("data-id");
		$.ajax({
			url: "/cart/remove/"+id,
			success: function(response) {
				$("#cart-count").html(response[0]);
				$("#cart-amount").html(response[1]);
			}
		});
		$(this).closest("tr").remove();
	});
});