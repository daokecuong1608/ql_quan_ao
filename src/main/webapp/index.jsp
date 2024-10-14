<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

<style>
.product-card {
	position: relative;
}

.product-card .overlay-buttons {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -5%);
	display: none;
	flex-direction: row;
	gap: 10px;
}

.product-card:hover .overlay-buttons {
	display: flex;
}

.btn-small-text {
	font-size: 8px;
}

.price {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.price .cost-price {
	text-decoration: line-through;
	color: gray;
}

.price .sale-price {
	color: red;
	font-weight: bold;
}

.btn-info {
	position: relative;
}

.btn-info .tooltip-text {
	visibility: hidden;
	width: 80px;
	background-color: black;
	color: #fff;
	text-align: center;
	border-radius: 6px;
	padding: 5px;
	position: absolute;
	z-index: 1;
	bottom: 125%;
	/* Position the tooltip above the button */
	left: 50%;
	margin-left: -40px;
	opacity: 0;
	transition: opacity 0.3s;
}

.btn-info:hover .tooltip-text {
	visibility: visible;
	opacity: 1;
}

.policy-item__icon img {
	width: 50px;
	/* Quy định chiều rộng của hình ảnh */
	height: auto;
	/* Tự động điều chỉnh chiều cao để giữ tỷ lệ */
	display: block;
	/* Đảm bảo hình ảnh là một khối */
	margin: 0 auto;
	/* Căn giữa hình ảnh */
}

.policy-item__inner {
	display: flex;
	align-items: center;
	gap: 10px;
	/* Khoảng cách giữa icon và thông tin */
}

.policy-item__info {
	flex: 1;
	/* Chiếm toàn bộ không gian còn lại */
}

.divider {
	border: 1px solid #b7abab;
	margin: 30px;
	/* Adjust the margin to increase spacing */
}

.container .mainBody-theme-container, .container .another-div {
	margin-bottom: 20px;
	/* Additional spacing if needed */
}
</style>

</head>

<body>

	<%
	String url_1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
	%>

	<!-- start header-->
	<%@ include file="header.jsp"%>
	<!--end header-->

	<!-- start carousel-->
	<%@ include file="carousel.jsp"%>
	<!--end carousel-->

	<!--container-->
	<div class="container mt-5">
		<h2 class="mb-4">Danh Sách Sản Phẩm</h2>

		<div class="row">
			<c:forEach var="sp" items="${listSanPham}">
				<!-- Sản phẩm 1 -->
				<div class="col-md-3">
					<div class="card product-card">
						<img src="${sp.hinhAnh}" class="card-img-top"
							alt="Sản phẩm 1">
						<div class="overlay-buttons">
							<button class="btn btn-success btn-small-text">Thêm vào
								giỏ hàng</button>
							<button class="btn btn-info">
								<i class="fas fa-eye"> <span class="tooltip-text">Xem
										nhanh</span>
								</i>
							</button>
						</div>
						<div class="card-body">
							<h5 class="card-title">${sp.maSanPham}</h5>
							<p class="card-text">${sp.moTa}</p>
							<div class="price">
								<span class="cost-price">Giá nhập: ${sp.giaNhap}</span> <span
									class="sale-price">Giá bán: ${sp.giaBan}</span>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
				<hr class="divider">
			<nav>
				<ul class="pagination justify-content-center">
					<c:forEach var="i" begin="0" end="${totalPages - 1}">
						<li class="page-item ${currentPage == i ? 'active' : ''}"><a
							class="page-link" href="<%=url_1%>/SanPhamController?page=${i}">${i + 1}</a>
						</li>
					</c:forEach>
				</ul>
			</nav>


		</div>
	</div>
	<!-- layoutproduct_scroll -->
	<%@ include file="layoutproduct_scroll.jsp"%>
	<!-- end layoutproduct_scroll -->

	<!--end container-->


	<!-- Footer -->
	<%@ include file="footer.jsp"%>
	<!-- end Footer -->

	<script type="text/javascript" src="./js/carousel.js"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/js/bootstrap.min.js"></script>



</body>

</html>