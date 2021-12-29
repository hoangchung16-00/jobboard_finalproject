<!-- login section start -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="login-wrapper">
    <div class="container">
        <div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">
            <form:form action="/register" modelAttribute="registerForm" method="post">
                <img class="img-responsive" alt="logo" src="/image/logo.png">
                <form:input type="text" class="form-control input-lg" placeholder="Tên đăng nhập" path="username"/>
                <form:errors path="username" cssClass="danger"/>
                <form:input type="password" class="form-control input-lg" placeholder="Mật khẩu" path="password"/>
                <form:errors path="password" cssClass="danger"/>
                <form:input type="password" class="form-control input-lg" placeholder="Xác nhận mật khẩu" path="repassword"/>
                <form:errors path="repassword" cssClass="danger"/>
                <form:input type="text" class="form-control input-lg" placeholder="Họ tên" path="name"/>
                <form:errors path="name" cssClass="danger"/>
                <form:input type="text" class="form-control input-lg" placeholder="Email" path="email"/>
                <form:errors path="email" cssClass="danger"/>
                <div>
                <button type="submit" class="btn btn-primary">Đăng ký</button></div>
            </form:form>
        </div>
    </div>
</section>
<!-- login section End -->