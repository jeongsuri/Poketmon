<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='검색결과' />
<c:url var="actionUrl" value="/rank" />
<c:url var="cssUrl" value="/css/rank.css" />

<layout:main title="${pageTitle}">
    <div class="searchResult">
        <div class="title">${pageTitle}</div>
        <c:if test="${not empty userRank}">
                <div>
                    <p>User ID: ${userRank.userId}</p>
                    <p>Rank: ${userRank.ranking}</p>
                    <p>Score: ${userRank.pokemonCount}</p>
                </div>
            </c:if>
            <c:if test="${empty userRank}">
                <div>
                    <p>No record found for the given User ID.</p>
                </div>
            </c:if>
    </div>
</layout:main>