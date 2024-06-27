<%@ tag description="Custom tag for displaying mypage layout" pageEncoding="UTF-8" %>
<%@ attribute name="title" required="true" type="java.lang.String" description="Page title" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/css/" />

<div class="content-box large">
    <form action="${pageContext.request.contextPath}/member/mypage" method="get">
        <c:if test="${! empty param.redirectUrl}">
            <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
        </c:if>
        <input class="search" type="text" name="userId" placeholder="<fmt:message key='아이디를_입력하세요' />">
        <div class="button-group">
            <button class="push" type="submit" class="button">
                <fmt:message key="나의포켓몬_조회하기" />
            </button>
        </div>
    </form>
</div>
