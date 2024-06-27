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
        <div class=title>${pageTitle}</div>
        <div class=subTitle>포켓몬 척척박사 트레이너들을 아래에서 확인해 보세요.</div>
        <div class="search">
        <input class="trainer_search" type="text" placeholder="아이디 검색">
        <button class="search_btn" type="submit">
            <fmt:message key="검색"/>
        </button>
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
        <div class="ranking">
        </div>
    </section>
</layout:main>



