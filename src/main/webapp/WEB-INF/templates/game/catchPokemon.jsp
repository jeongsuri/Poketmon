<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="포켓몬_게임" />
<c:url var="gameurl" value="/game" />
<c:url var="actionUrl" value="/game/catch" />
<layout:main title="${pageTitle}">
        <section class="content-box">
                <b class="headText">야호! ${param.pokemonName}을(를) 잡았다 !</b>
                <img src="${param.image}" class="pokemon">
                <form method="POST" name="frmCatch" autocomplete="off" action="${actionUrl}" target="ifrmProcess">
                        <input type="hidden" name="pokemonNo" value="${param.seq}">
                        <input type="hidden" name="pokemonName" value="${param.pokemonName}">
                        <input type="hidden" name="userNo" value="0">
                          <span class="nick">별명을 지어주세요.</span>

                        <input type="text" name="nickName" autofocus placeholder="별명 입력" class="pokemonNick">
                        <div class="buttons">
                                <button type="submit" class="myPageBtn">박스로 이동</button>
                                <a href="${gameUrl}"><button type="button" class="mainBtn">다시 &nbsp;하기</button></a>
                        </div>
                </form>

        </section>
</layout:main>
