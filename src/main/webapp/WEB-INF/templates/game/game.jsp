<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="포켓몬_게임" />
<c:url var="actionUrl" value="/game" />

<layout:main title="${pageTitle}">
    <div class="content-wrapper">
        <img src="images/o.png" class="o" >
        <section class="content-box">
            <img src="${data.frontDefault}" class="pokemon">
            <div>
                <div class="pokemonType">
                    <b class="type1 ${typeColor1}" id="type1">${data.type1}</b>
                    <b class="type2 ${typeColor2}" id="type2">${data.type2}</b><br>
                </div>
                    <span class="content">${fn:replace(data.flavorText, '\\n', '<br>')}</span><br>
                    <span class="weight">무게 : ${data.weight/10} kg</span><br>
                <form method="POST" autocomplete="off" autocomplete="off">
                    <input type="hidden" name="seq" value="${data.seq}">
                    <input type="hidden" name="image" value="${data.frontDefault}">
                    <input type="text" name="pokemonName" autofocus placeholder="정답 입력" class="pokemonName" >
                    <c:if test="${! empty errMessage}">
                        <div class="message">${errMessage}</div>
                    </c:if>

                    <button type="submit" class="submitBtn">포획!</button>
                </form>
            </div>
        </section>
        <button type="reset" class="reButton">
            <a href="game" ><img src="images/arrow.png" alt="Arrow" class="arrow"></a>
        </button>
    </div>
</layout:main>


