import"javax.servlet.http.HttpSession"
function addToCart(productId) {
	const isLoggedIn = session.getAttribute("khachHang") != null;

	    if (!isLoggedIn) {
	        alert("Vui lòng đăng nhập để thêm sản phẩm vào giỏ hàng.");
	        return;
	    }

	    const form = document.createElement('form');
	    form.method = 'post';
	    form.action = 'AddToCartServlet';

	    const input = document.createElement('input');
	    input.type = 'hidden';
	    input.name = 'maSanPham';
	    input.value = maSanPham;

	    form.appendChild(input);
	    document.body.appendChild(form);
	    form.submit();
}