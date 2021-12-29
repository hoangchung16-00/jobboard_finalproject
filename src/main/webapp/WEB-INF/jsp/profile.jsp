<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="tag-date" tagdir="/WEB-INF/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<section class="profile-detail">
    <div class="container">
        <div class="col-md-12">
            <div class="row">
                <div class="basic-information">
                    <div class="col-md-3 col-sm-3">
                        <img src="/image/${user.image}" alt="" class="img-responsive">
                    </div>
                    <div class="col-md-9 col-sm-9">
                        <div class="profile-content">
                            <c:if test="${account.user.id == user.id}">
                                <a href="/editProfile" type="button" class="btn btn-primary">
                                    Chỉnh sửa hồ sơ
                                </a>
                            </c:if>
                            <h2>${user.name}<span>${user.description}</span></h2>
                            <ul class="information">
                                <li><span>Địa chỉ:</span>${user.address}</li>
                                <li><span>Số điện thoại:</span>${user.phonenumber}</li>
                                <li><span>Mail:</span>${user.email}</li>
                                <li><span>Giới tính:</span>${user.gender}</li>
                                <li><span>Ngày sinh:</span><tag-date:date date="${user.dob}"></tag-date:date></li>
                            </ul>
                        </div>
                    </div>
                    <ul class="social">
                        <c:forEach items="${user.linkUsersList}" var="link">
                            <li><a href="${link.link}" class="${link.linkType.name}"><i class="fa fa-${link.linkType.name}"></i>Facebook</a></li>
                        </c:forEach>
                    </ul>
<%--                    <div class="panel panel-default">--%>
<%--                        <div class="panel-heading">--%>
<%--                            <i class="fa fa-user fa-fw"></i> Job description--%>
<%--                        </div>--%>
<%--                        <!-- /.panel-heading -->--%>
<%--                        <div class="panel-body">--%>
<%--                            <p>${job.description}</p>--%>
<%--                        </div>--%>
<%--                    </div>--%>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-leaf fa-fw"></i> Kỹ năng:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">

                            <ul>
                                <c:forEach items="${user.skillUsersList}" var="skill">
                                    <li>${skill.name} -  ${skill.experience}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-coffee fa-fw"></i> Sở thích:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <p>${user.hobby}</p>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-graduation-cap fa-fw"></i> Học vấn:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <p>${user.education}</p>
                        </div>
                    </div>


                </div>
            </div>
        </div>
    </div>
</section>