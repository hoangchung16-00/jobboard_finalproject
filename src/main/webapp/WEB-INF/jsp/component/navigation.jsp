<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation Start  -->
<nav class="navbar navbar-default navbar-sticky bootsnav">

    <div class="container">
        <!-- Start Header Navigation -->
        <div class="navbar-header">

            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand" href="index.html"><img src="/image/logo.png" class="logo" alt=""></a>
        </div>
        <!-- End Header Navigation -->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                <li><a href="/">Home</a></li>
                <c:if test="${!isLogin}">
                    <li><a href="/login">Login</a></li>
                </c:if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Browse</a>
                    <ul class="dropdown-menu animated fadeOutUp" style="display: none; opacity: 1;">
                        <li class="active"><a href="browse-job.html">Browse Jobs</a></li>
                        <c:if test="${isLogin}">
                            <c:if test="${account.accountrole.name=='User'}">
                                <li><a href="/profile?id=${account.user.id}">Profile</a></li>
                            </c:if>
                            <c:if test="${account.accountrole.name=='Company'}">
                                <li><a href="/company?id=${account.company.id}">Company infor</a></li>
                            </c:if>
                        </c:if>
                        <li><a href="resume.html">Resume Detail</a></li>
                        <c:if test="${isLogin}">
                            <li><a href="/logout">Logout</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>
<!-- Navigation End  -->