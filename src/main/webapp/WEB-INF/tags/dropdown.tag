<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="list" required="true" type="java.util.List<com.example.jobboard_final.entities.Status>" %>
<%@ attribute name="current" required="true" type="java.lang.String" %>

<!-- Navigation Start  -->
<nav class="navbar bootsnav" style="width: 9.9%">
    <div class="container">
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">${current}</a>
                    <ul class="dropdown-menu">
                        <c:forEach items="${list}" var="item">
                            <c:if test="${item.name != current}">
                                <li><a href="/approval/${item.name}">${item.name}</a></li>
                            </c:if>
                        </c:forEach>
                        <c:if test="${current != 'All'}">
                            <li><a href="/approval/All">All</a></li>
                        </c:if>
                    </ul>
                </li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div>
</nav>
<!-- Navigation End  -->