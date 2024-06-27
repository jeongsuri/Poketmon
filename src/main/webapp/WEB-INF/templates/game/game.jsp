<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key="포켓몬_게임" />
<c:url var="actionUrl" value="/game" />

<layout:main title="${pageTitle}">
    <div class="content-wrapper">
        <img src="images/o.png" class="o" >
        <section class="content-box">
            <img src="https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png" class="pokemon">
            <div>
                <div class="pokemonType">
                    <b class="type1">타입1</b>
                    <b class="type2">타입2</b><br>
                </div>
                    <span class="content">태어났을 때부터 등에 이상한 씨앗이 심어져 있으며 몸과 함께 자란다고 한다.</span><br>
                    <span class="weight">무게 : 100 kg</span><br>
                <form>
                    <input type="text" name="pokemonName" autofocus placeholder="정답 입력" class="pokemonName" >
                    <button type="submit" class="submitBtn">포획!</button>
                </form>
            </div>
        </section>
    <img src="images/arrow.png" class="arrow" >
    </div>
</layout:main>

