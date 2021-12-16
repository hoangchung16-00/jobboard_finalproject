<!-- login section start -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<section class="login-wrapper">
    <div class="container">
        <div class="col-md-6 col-sm-8 col-md-offset-3 col-sm-offset-2">
            <form:form action="/register" modelAttribute="registerForm" method="post">
                <img class="img-responsive" alt="logo" src="/image/logo.png">
                <form:input type="text" class="form-control input-lg" placeholder="User Name" path="username"/>
                <form:errors path="username" cssClass="danger"/>
                <form:input type="password" class="form-control input-lg" placeholder="Password" path="password"/>
                <form:errors path="password" cssClass="danger"/>
                <form:input type="password" class="form-control input-lg" placeholder="Repeat password" path="repassword"/>
                <form:errors path="repassword" cssClass="danger"/>
                <form:input type="text" class="form-control input-lg" placeholder="Your name" path="name"/>
                <form:errors path="name" cssClass="danger"/>
                <form:input type="text" class="form-control input-lg" placeholder="Email" path="email"/>
                <form:errors path="email" cssClass="danger"/>
                <div>
                <button type="submit" class="btn btn-primary">Submit</button></div>
                <p>Have't Any Account <a href="/register">Create An Account</a></p>
            </form:form>
        </div>
    </div>
</section>
<!-- login section End -->