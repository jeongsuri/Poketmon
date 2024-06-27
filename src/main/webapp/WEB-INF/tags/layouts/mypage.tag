<%@ tag body-content="scriptless" %>
<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" %>
<fmt:setBundle basename="messages.commons" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="logoUrl" value="/images/logo.png" />
<c:url var="footerlogoUrl" value="/images/footerlogo.png" />


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
