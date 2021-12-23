<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<section class="profile-detail">
    <div class="container">
        <div class="col-md-12">
            <div class="row">
                <div class="basic-information">
                    <div class="col-md-3 col-sm-3">
                        <img src="/image/${job.company.image}" alt="" class="img-responsive">
                    </div>
                    <div class="col-md-9 col-sm-9">
                        <div class="profile-content">
                            <c:if test="${account.accountrole.name=='User'}">
                                <button onclick="apply(${job.id},${isLogin});" id="applyjob" type="button" class="btn btn-primary">
                                    Ứng tuyển
                                </button>
                            </c:if>
                            <c:if test="${account.accountrole.name!='User'}">
                                <p class="danger">Vui lòng đăng nhập để ứng tuyển</p>
                            </c:if>
                            <h2>${job.company.name}<span>${job.name} (${job.jobStatus.name})</span></h2>
                            <p>Số lượng tuyển dụng: (${job.number})</p>
                            <ul class="information">
                                <li><span>Công việc:</span>${job.shortdescription}</li>
                                <li><span>Địa chỉ làm việc:</span>${job.address}</li>
                                <li><span>Website:</span><a href="${job.company.website}" target="_blank">${job.company.website}</a></li>
                                <li><span>Mail:</span>${job.company.email}</li>
                            </ul>
                        </div>
                    </div>
                    <%--<ul class="social">
                        <li><a href="" class="facebook"><i class="fa fa-facebook"></i>Facebook</a></li>
                        <li><a href="" class="google"><i class="fa fa-google-plus"></i>Google Plus</a></li>
                        <li><a href="" class="twitter"><i class="fa fa-twitter"></i>Twitter</a></li>
                        <li><a href="" class="linkedin"><i class="fa fa-linkedin"></i>Linked In</a></li>
                        <li><a href="" class="instagram"><i class="fa fa-instagram"></i>Instagram</a></li>
                    </ul>--%>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-user fa-fw"></i> Mô tả công việc
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <p>${job.description}</p>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-leaf fa-fw"></i> Yêu cầu kỹ năng:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul>
                                <c:forEach items="${job.skillJobList}" var="skill">
                                    <li>${skill.name} -  ${skill.levelType.name}</li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>

                    <%--<div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-coffee fa-fw"></i> Minimum qualifications:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <p>Rapid growth since incorporation has triggered a chain of products.</p>
                            <ul>
                                <li>Software testing in a Web Applications/Mobile environment.</li>
                                <li>Software Test Plans from Business Requirement Specifications for test engineering group.</li>
                                <li>Software testing in a Web Applications environment.</li>
                                <li>Translate designs into responsive web interfaces</li>
                                <li>Software testing in a Web Applications/Mobile environment.</li>
                                <li>Software testing in a Web Applications environment.</li>
                                <li>Translate designs into responsive web interfaces</li>
                                <li>Software Test Plans from Business Requirement Specifications for test engineering group.</li>
                                <li>Run production tests as part of software implementation; Create, deliver and support test plans for testing group to execute.</li>
                                <li>Run production tests as part of software implementation; Create, deliver and support test plans for testing group to execute.</li>
                            </ul>
                        </div>
                    </div>

                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-graduation-cap fa-fw"></i> Preferred qualifications:
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul>
                                <li>Software testing in a Web Applications/Mobile environment.</li>
                                <li>Software Test Plans from Business Requirement Specifications for test engineering group.</li>
                                <li>Software testing in a Web Applications environment.</li>
                                <li>Translate designs into responsive web interfaces</li>
                                <li>Software testing in a Web Applications/Mobile environment.</li>
                                <li>Software testing in a Web Applications environment.</li>
                                <li>Translate designs into responsive web interfaces</li>
                                <li>Software Test Plans from Business Requirement Specifications for test engineering group.</li>
                                <li>Run production tests as part of software implementation; Create, deliver and support test plans for testing group to execute.</li>
                                <li>Run production tests as part of software implementation; Create, deliver and support test plans for testing group to execute.</li>
                            </ul>
                        </div>
                    </div>--%>


                </div>
            </div>
        </div>
    </div>
</section>
