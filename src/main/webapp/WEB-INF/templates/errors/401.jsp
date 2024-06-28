<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<fmt:message var="pageTitle" key='401error' />

<layout:memberMain title="${pageTitle}">
    <img src="<c:url value='/images/401error.png' />" alt="401" >
</layout:memberMain>