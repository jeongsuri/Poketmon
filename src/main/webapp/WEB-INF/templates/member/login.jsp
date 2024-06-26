<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='로그인' />
<c:url var="actionUrl" value="/member/join" />

<layout:memberMain title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
        <form name="frmJoin" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <dl>
                <dd>
                    <input type="text" name="userId" autofocus placeholder="아이디">
                </dd>
            </dl>
            <dl>
                <dd>
                    <input type="password" name="password" autofocus placeholder="비밀번호">
                </dd>
            </dl>
            <div class="button-group">
                <button type="submit">
                    <fmt:message key="로그인" />
                </button>
            </div>
            <div class="button-group">
                <button type="submit">
                    <fmt:message key="아직_회원이_아니신가요?" />
                </button>
            </div>
        </form>
    </section>
</layout:memberMain>