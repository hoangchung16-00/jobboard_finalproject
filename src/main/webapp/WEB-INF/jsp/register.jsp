<!-- login section start -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="login-wrapper">
    <div class="container">
        <div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">
            <form:form action="/register" modelAttribute="registerForm" method="post">
                <img class="img-responsive" alt="logo" src="/image/logo.png">
                <input type="text" class="form-control input-lg" placeholder="User Name" name="username">
                <input type="password" class="form-control input-lg" placeholder="Password" name="password">
                <input type="password" class="form-control input-lg" placeholder="Repeat password" name="repassword">
                <label><a href="">Forget Password?</a></label>
                <button type="submit" class="btn btn-primary">Login</button>
                <p>Have't Any Account <a href="/register">Create An Account</a></p>
            </form:form>
        </div>
    </div>
</section>
<!-- login section End -->