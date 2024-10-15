<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông báo</title>
<meta http-equiv="refresh" content="3;url=<%= request.getContextPath() %>/SanPhamController">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
     <div class="container mt-5">
        <div class="alert alert-success" role="alert">
            <%
                String message = request.getParameter("message");
                if (message != null) {
                    message = java.net.URLDecoder.decode(message, "UTF-8");
                    out.print(message);
                }
            %>
        </div>
        <p>Bạn sẽ được chuyển hướng về trang chủ sau 3 giây...</p>
    </div>
</body>
</html>