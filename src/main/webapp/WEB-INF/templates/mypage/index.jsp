<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons"/>
<fmt:message var="pageTitle" key='마이페이지'/>
<c:url var="actionUrl" value="/mypage"/>
<c:url var="cssUrl" value="/css/"/>


<layout:main title="${pageTitle}">

    <h1>Welcome to My Page</h1>


</layout:main>