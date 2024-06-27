<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='포켓몬_도감' />
<c:url var="actionUrl" value="/main" />

<layout:main title="${pageTitle}">
    <section class="layout-width">
        <div class="pokemon-title-container"> <!-- Wrapper for title -->
            <h1 class="pokemon-title">도감 목록 보기</h1>
        </div>
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class="no-data">조회된 포켓몬이 없습니다!</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <li>
                        <a href="<c:url value='/pokemon/${item.seq}' />">
                            <img src="${item.frontDefault}" alt="${item.name}">
                            <div class="p-name">
                                    ${item.name}
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
    </section>

    <!-- Pagination Section -->
    <div class="pagination">
        <c:if test="${page > 1}">
            <a href="<c:url value='?page=${page - 1}' />">&laquo;</a>
        </c:if>
        <c:forEach var="i" begin="1" end="${totalPages}">
            <a href="<c:url value='?page=${i}' />" class="${page == i ? 'active' : ''}">${i}</a>
        </c:forEach>
        <c:if test="${page < totalPages}">
            <a href="<c:url value='?page=${page + 1}' />">&raquo;</a>
        </c:if>
    </div>
</layout:main>
