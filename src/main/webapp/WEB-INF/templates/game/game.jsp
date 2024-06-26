<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="포켓몬_게임" />
<c:url var="actionUrl" value="/game" />

<layout:main title="${pageTitle}">
    <layout:game>
        <section class="content-box">
            <h1>${pageTitle}</h1>
            <h2>포켓몬 이름</h2>
            <span>포켓몬 설명@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@</span><br>
            <span>타입1</span><br>
            <span>타입2</span><br>
            <span>몸무게</span><br>
            <img src="images/2.png" class="pokemon">
        </section>
    </layout:game>
</layout:main>