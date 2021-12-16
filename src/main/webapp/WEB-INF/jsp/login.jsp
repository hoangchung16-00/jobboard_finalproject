<!-- login section start -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section class="login-wrapper">
    <div class="container">
        <div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">
            <form:form action="/login" modelAttribute="loginForm" method="post">

                <img class="img-responsive" alt="logo" src="/image/logo.png">
                <c:if test="${param.error}">
                    <div class="danger">
                        Invalid username or password
                    </div>
                </c:if>

                <form:input type="text" class="form-control input-lg" placeholder="User Name" path="username"/>

                <form:input type="password" class="form-control input-lg" placeholder="Password" path="password"/>
                <label><a href="">Forget Password?</a></label>
                <button type="submit" class="btn btn-primary">Login</button>
                <p>Have't Any Account <a href="/register">Create An Account</a></p>
            </form:form>

            <a href="https://www.facebook.com/dialog/oauth?client_id=309386574033218&redirect_uri=https://localhost:8443/signin/facebook" class="btn btn-lg btn-social btn-facebook">
                <i class="fa fa-facebook fa-fw"></i> Sign in with Facebook
            </a>
            <a class="btn btn-lg btn-social btn-google">
                <i class="fa fa-google fa-fw"></i> Sign in with Google
            </a>
        </div>
    </div>
</section>
<!-- login section End -->