<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='순위표' />
<c:url var="actionUrl" value="/rank" />
<c:url var="cssUrl" value="/css/" />


<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
        <div class="search">
        <input class="trainer_search" type="text" placeholder="아이디 검색">
        <button class="search_btn">검색</button>
        </div>
    </section>
</layout:main>



