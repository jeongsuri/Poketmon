<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='로그인' />
<c:url var="actionUrl" value="/member/login" />

<layout:memberMain title="${pageTitle}">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <div class="content-box small">
        <img src="<c:url value='/images/logo2.png' />" alt="Company Logo" width="200">
        <form class="form-container" name="frmLogin" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <c:if test="${! empty param.redirectUrl}">
                <input type="hidden" name="redirectUrl" value="${param.redirectUrl}">
            </c:if>
            <dl>
                <dd>
            <input type="text" name="userId" placeholder="<fmt:message key='아이디' />">
                </dd>
            </dl>
            <dl>
                <dd>
            <input type="password" name="password" placeholder="<fmt:message key='비밀번호' />">
                </dd>
            </dl>
            <div class="button-group">
            <button type="submit" class="button">
                <fmt:message key="로그인" />
            </button>

            <button type="submit" class="button2">
                <fmt:message key="아직_회원이_아니신가요?" />
                <i class="xi-angle-right"></i>
            </button>
            </div>
        </form>
    </div>
</layout:memberMain>