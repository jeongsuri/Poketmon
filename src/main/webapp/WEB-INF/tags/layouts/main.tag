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

<layout:common title="${title}">
    <jsp:attribute name="header">
        <section class="site-top">
            <style>
                div {
                    text-align: center;
                }
            </style>
            <a href="<c:url value="/main" />">
            <div>
                <img src="${logoUrl}" alt="<fmt:message key='로고' />">
            </div>
            </a>
        </section>
        <nav>
            <div class="layout-width inner">
                <a href="http://localhost:3000/project/board">커뮤니티</a>
                <a href="http://localhost:3000/project/main">도감 보기</a>
                <a href="http://localhost:3000/project/mypage">내 포켓몬</a>
                <a href="http://localhost:3000/project/game">포켓몬 잡기</a>
                <a href="http://localhost:3000/project/rank">순위표</a>
                <c:if test="${isAdmin}">
                    <a href="<c:url value='/admin' />" target="_blank">
                        <fmt:message key="사이트_관리" />
                    </a>
                </c:if>
                <a href="<c:url value="/member/logout" />">로그아웃</a>
<%--                <c:if test="${isLogin}">--%>
<%--                    <a href="<c:url value='/member/login' />" target="_blank">--%>
<%--                        <fmt:message key="로그아웃" />--%>
<%--                    </a>--%>
<%--                </c:if>--%>
            </div>
        </nav>
    </jsp:attribute>

    <jsp:attribute name="footer">
        <section class="site-bottom">
            <style>
                div {
                    text-align: center;
                }
            </style>
            <div>
                <img src="${footerlogoUrl}" alt="<fmt:message key='푸터 로고' />">
            </div>
        </section>
    </jsp:attribute>

    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>