<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ attribute name="title" %>
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="logoUrl" value="/images/logo.png" />

<layout:main title="mypokemon">
    <jsp:attribute name="header">
        <section class="site-top">
            <style>
                div {
                    text-align: center;
                }
            </style>
            <div>
                <img src="${logoUrl}" alt="<fmt:message key='로고' />">
            </div>
        </section>
        <nav>
           <div>
           </div>
        </nav>
    </jsp:attribute>
    <jsp:attribute name="footer">
        <h1>마이페이지 레이아웃 하단 영역!</h1>
    </jsp:attribute>
    <jsp:attribute name="mypokemon">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="Js">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:main>