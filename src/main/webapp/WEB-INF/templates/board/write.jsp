<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons"/>
<fmt:message var="pageTitle" key='글쓰기'/>
<c:url var="cssUrl" value="/css/"/>

<layout:main title="${pageTitle}">
    <h1>글쓰기</h1>
</layout:main>

