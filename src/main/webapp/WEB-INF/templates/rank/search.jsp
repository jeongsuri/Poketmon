<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='검색결과' />
<c:url var="actionUrl" value="/rank" />
<c:url var="cssUrl" value="/css/rank/search.css" />

<layout:main title="${pageTitle}">
    <div class="searchResult">
        <div class="title">${pageTitle}</div>
        <div class="subTitle">포켓몬 척척박사 트레이너들을 아래에서 확인해 보세요.</div>
        <div class="search">
            <form name="frmSearch" method="get" action="${pageContext.request.contextPath}/rank/search" autocomplete="off" class="search-form">
                <label for="userId"></label>
                <input type="text" name="userId" value="${param.userId}" class="trainer_search" placeholder="아이디 검색">
                <button class="search_btn" type="submit">
                    <fmt:message key="검색"/>
                </button>
            </form>
        </div>
        <c:if test="${not empty userRank}">
                <div class="result1">
                    <div>
                        <p>
                            ${userRank.userId} 님의 순위는
                            ${userRank.ranking}위이며, 잡은 포켓몬 수는
                            ${userRank.pokemonCount}입니다.
                        </p>
                        <div>
                            <img src="<c:url value='/images/pikachoo.png' />" class="image1">
                        </div>
                    </div>
                </div>
            </c:if>
            <c:if test="${empty userRank}">
                <div class="result2">
                    <div>
                        <p>해당하는 사용자가 없습니다.</p>
                        <div>
                             <img src="<c:url value='/images/psyduck.png' />" class="image2">
                        </div>
                    </div>
                </div>
            </c:if>

        <div class="buttons">
            <a href="${actionUrl}">
                <button type="button" class="goRankBtn">순위표로 이동</button>
            </a>
        </div>
    </div>
</layout:main>

<link rel="stylesheet" type="text/css" href="${cssUrl}">