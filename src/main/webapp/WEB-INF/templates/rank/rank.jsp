<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='순위표' />
<c:url var="actionUrl" value="/rank" />
<c:url var="cssUrl" value="/css/rank/rank.css" />

<layout:main title="${pageTitle}">
    <div class="rank">
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

        <div class="rankings">
            <c:forEach var="item" items="${rankingList}">
                <div class="ranking">
                    <div class="userRank">
                        ${item.ranking}위
                    </div>
                    <div class="userId">
                        ${item.userId}
                    </div>
                    <div class="userScore">
                        ${item.pokemonCount}점
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</layout:main>

<link rel="stylesheet" type="text/css" href="${cssUrl}">
