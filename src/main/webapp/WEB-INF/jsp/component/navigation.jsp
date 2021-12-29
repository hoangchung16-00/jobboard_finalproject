<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!-- Navigation Start  -->
<nav class="navbar navbar-default navbar-sticky bootsnav">
    <div class="container">
        <!-- Start Header Navigation -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                <i class="fa fa-bars"></i>
            </button>
           <img id="logo" width="405px" height="85px" src="/image/logo.png" class="logo" alt="">
        </div>
        <!-- End Header Navigation -->

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="navbar-menu">
            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                <li><a href="/">Trang chủ</a></li>
                <c:if test="${!isLogin}">
                    <li><a href="/login">Đăng nhập</a></li>
                </c:if>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Mở rộng</a>
                    <ul class="dropdown-menu animated fadeOutUp" style="display: none; opacity: 1;">
                        <li><a href="/findJob/All">Tìm kiếm công việc</a></li>
                        <c:if test="${isLogin}">
                            <c:if test="${account.accountrole.name=='User'}">
                                <li><a href="/profile/${account.user.id}">Hồ sơ ứng viên</a></li>
                                <li><a href="/applyList">Danh sách ứng tuyển</a></li>
                            </c:if>
                            <c:if test="${account.accountrole.name=='Company'}">
                                <li><a href="/company/${account.company.id}">Hồ sơ nhà tuyển dụng</a></li>
                                <li><a href="/approval/All">Yêu cầu ứng tuyển</a></li>
                                <li><a href="/createJob">Đăng tin tuyển dụng</a></li>
                            </c:if>
                            <li><a href="/logout">Đăng xuất</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>
<!-- Navigation End  -->