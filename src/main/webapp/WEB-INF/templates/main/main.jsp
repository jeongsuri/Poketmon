<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='포켓몬_도감' />
<c:url var="actionUrl" value="/main" />
<layout:main title="${pageTitle}">
    <section class="layout-width">
        <ul class="pokemon-list">
            <c:if test="${items == null || items.isEmpty()}">
                <li class="no-data">조회된 포켓몬이 없습니다!</li>
            </c:if>
            <c:if test="${items != null && !items.isEmpty()}">
                <c:forEach var="item" items="${items}">
                    <li>
                        <a href="<c:url value="/pokemon/${item.seq}" />">
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
</layout:main>