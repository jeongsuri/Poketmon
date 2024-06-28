<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="포켓몬_게임" />
<c:url var="actionUrl" value="/game" />

<layout:main title="${pageTitle}">
        <section class="content-box">
                <b class="headText">${answerName}을(를) 잡았다 !</b>
                <img src="${answerImage}" class="pokemon">
                <form>
                       <span class="nick">별명을 지어주세요.</span>
                <input type="text" name="pokemonNick" autofocus placeholder="정답 입력" class="pokemonNick" >
                        <div class="buttons">
                                <button type="submit" class="myPageBtn">박스로 이동</button>
                                <button type="submit" class="mainBtn">한 번 더 하기</button>
                        </div>
                </form>
        </section>
</layout:main>
