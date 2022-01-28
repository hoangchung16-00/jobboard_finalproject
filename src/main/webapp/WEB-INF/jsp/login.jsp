<!-- login section start -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="login-wrapper">
    <div class="container">
        <div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">
            <form:form action="/login" modelAttribute="loginForm" method="post">
                <c:if test="${param.error}">
                    <div class="danger">
                        Tên đăng nhập hoặc mật khẩu không hợp lệ
                    </div>
                </c:if>

                <form:input type="text" class="form-control input-lg" placeholder="Tên đăng nhập" path="username"/>

                <form:input type="password" class="form-control input-lg" placeholder="Mật khẩu" path="password"/>
                <label><a href="">Quên mật khẩu?</a></label>
                <button type="submit" class="btn btn-primary">Đăng nhập</button>
                <p>Chưa có tài khoản? <a href="/userType">Đăng ký ngay</a></p>
            </form:form>

            <a href="https://www.facebook.com/dialog/oauth?client_id=309386574033218&redirect_uri=https://https://jobdesk.herokuapp.com/signin/facebook" class="btn btn-lg btn-social btn-facebook">
                <i class="fa fa-facebook fa-fw"></i>Đăng nhập với Facebook
            </a>
            <a class="btn btn-lg btn-social btn-google">
                <i class="fa fa-google fa-fw"></i>Đăng nhập với Google
            </a>
        </div>
    </div>
</section>
<!-- login section End -->