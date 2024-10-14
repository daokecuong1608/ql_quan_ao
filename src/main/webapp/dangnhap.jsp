<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập - Cửa hàng quần áo</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
    integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
    crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
    integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
    crossorigin="anonymous"></script>
</head>
<body>

    <%@ include file="./../header.jsp"%>

    <%
    String baoLoi = request.getAttribute("baoLoi") + "";
    if (baoLoi.equals("null")) {
        baoLoi = "";
    }
    String url_1 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + request.getContextPath();
    %>
    <div class="container d-flex justify-content-center align-items-center vh-100">
        <div class="col-md-6">
            <div class="text-center mt-5">
                <img src="https://invietnhat.vn/wp-content/uploads/2023/08/nhung-luu-y-ve-noi-dung.jpg"
                    alt="Logo" class="img-fluid mb-4" style="max-width: 250px;">
            </div>
            <div class="text-center">
                <span class="red"><%=baoLoi%></span>
            </div>
            <h2 class="text-center mt-5">Đăng nhập</h2>
            
            <form action="login" method="post">
                <div class="mb-3">
                    <label for="tenDangNhap" class="form-label">Tên Đăng Nhập</label>
                    <input type="text" class="form-control" name="tenDangNhap" id="tenDangNhap" placeholder="Nhập tên đăng nhập">
                </div>
                <div class="mb-3">
                    <label for="matKhau" class="form-label">Mật khẩu</label>
                    <input type="password" class="form-control" id="matKhau" name="matKhau" placeholder="Nhập mật khẩu của bạn">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="rememberMe">
                    <label class="form-check-label" for="rememberMe">Nhớ mật khẩu</label>
                </div>
                <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
            </form>
            <p class="text-center mt-3">
                Chưa có tài khoản? <a href="#">Đăng ký</a>
            </p>
        </div>
    </div>
    <%@ include file="./../footer.jsp"%>

</body>
</html>