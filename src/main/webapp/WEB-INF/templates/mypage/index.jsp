<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='마이페이지' />
<c:url var="actionUrl" value="member/mypage" />
<c:url var="cssUrl" value="/css/"/>


 <link rel="stylesheet">
<layout:memberMain title="${pageTitle}">
    <div class="content-box large">
        <form action="${actionUrl}" method="get">
            <c:if test="${not empty param.redirectUrl}">
                <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
            </c:if>
            <input type="text" name="userId" placeholder="<fmt:message key='아이디를_입력하세요' />">
            <div class="button-group">
                <button type="submit" class="button-large">
                    <fmt:message key="나의포켓몬_조회하기" />
                </button>
            </div>
        </form>
    </div>
</layout:memberMain>
