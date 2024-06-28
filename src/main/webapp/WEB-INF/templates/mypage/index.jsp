<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons"/>
<fmt:message var="pageTitle" key='마이페이지'/>
<c:url var="actionUrl" value="/mypage"/>
<c:url var="cssUrl" value="/css/"/>

<layout:main title="${pageTitle}">

    <%--  상단  --%>
    <div class="mypage">
        <div class="mypage-top">
            <h1>나의포켓몬</h1>
            </div>
            </div>
 </layout:main>
