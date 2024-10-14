<%@page import="model.KhachHang"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
		+ request.getContextPath();
%>


<!-- start header-->
<nav class="navbar navbar-expand-lg bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"> <img
			src="https://bizweb.dktcdn.net/100/462/587/themes/880841/assets/logo.png?1724310613023"
			alt="Bootstrap" height="24">
		</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="<%=url%>/SanPhamController">Trang chủ</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Combo
						giảm giá</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Thể loại </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Thể loại 1</a></li>
						<li><a class="dropdown-item" href="#">Thể loại 1</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Thể loại 1</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" role="button"
					data-bs-toggle="dropdown" aria-expanded="false"> Thương hiệu </a>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">Quần Jean</a></li>
						<li><a class="dropdown-item" href="#">Áo thun</a></li>
						<li>
							<hr class="dropdown-divider">
						</li>
						<li><a class="dropdown-item" href="#">Áo sơ mi</a></li>
					</ul></li>
				<li class="nav-item"><a class="nav-link disabled">Hết hàng</a>
				</li>
			</ul>
			<form class="d-flex m-2" role="search"
				style="margin: 10px !important;">
				<input class="form-control me-2" type="search"
					placeholder="Nội dung tìm kiếm" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Tìm</button>
				<a href="#" class="btn btn-outline-success my-2 my-sm-0 mr-3"><i
					class="fas fa-shopping-cart fa-lg"></i></a>

				<%
				Object object = session.getAttribute("khachHang");
				KhachHang khachHang = null;
				if (object != null)
					khachHang = (KhachHang) object;
				if (khachHang == null) {
				%>
				<a class="btn btn-primary" href="<%=url%>/dangnhap.jsp"
					style="white-space: nowrap;"> Đăng nhập </a>
				<%
				} else {
				%>
				<div class="row text-center">
					<div>
						<b>Xin chào:<%=khachHang.getHoVaTen()%></b>
					</div>
					<div class="row">
						<a style="white-space: nowrap;" href="<%=url%>/login">Đăng xuất</a>
						<div></div>
						<%
						}
						%>
					
			</form>
		</div>
	</div>
</nav>
<!--end header-->

