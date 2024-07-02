<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='포켓몬_도감' />
<c:url var="actionUrl" value="/main" />

<layout:main title="${pageTitle}">
    <section class="layout-width">
        <div class="pokemon-title-container"> <!-- 도감 목록 제목 -->
            <h1 class="pokemon-title">도감 목록 보기</h1>
        </div>
        <form name="frmSearch" method="get" action="${searchUrl}" autocomplete="off" class="search-form"> <!-- 포켓몬 검색창 -->
            <img src="<c:url value='/images/pikachoo.png' />" class="image">
            <label for="skey">포켓몬 검색 : </label>
            <input type="text" name="skey" value="${param.skey}" autofocus placeholder="포켓몬 이름을 입력하세요!" class="pokemonName">
            <button type="submit">검색</button>
        </form>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class="no-data">조회된 포켓몬이 없습니다!</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <li>
                        <a href="<c:url value='/pokemon/${item.seq}' />">
                                <div class="p-number">
                                        No. ${item.seq}
                                </div>
                            <img src="${item.frontDefault}" alt="${item.name}">
                            <div class="p-name">
                                    ${item.name}
                            </div>
                            <div class="p-types">
                                <div class="p-type1 p-type <util:typeColor value="${item.type1}" />">
                                    Type1 : ${item.type1}
                                </div>
                                <div class="p-type2 p-type <util:typeColor value="${item.type2}" />">
                                    Type2 : ${item.type2}
                                </div>
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
        <util:pagination />
    </section>
</layout:main>