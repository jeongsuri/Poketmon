<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='순위표' />
<c:url var="actionUrl" value="/rank" />
<c:url var="cssUrl" value="/css/" />


<layout:main title="${pageTitle}">
    <section class="content-box">
        <div class=title>${pageTitle}</div>
        <div class=subTitle>포켓몬 척척박사 트레이너들을 아래에서 확인해 보세요.</div>
        <div class="search">
        <input class="trainer_search" type="text" placeholder="아이디 검색">
        <button class="search_btn" type="submit">
            <fmt:message key="검색"/>
        </button>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">1</div>
            <div class="trainer">user01</div>
            <div class="score">95</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">2</div>
            <div class="trainer">user02</div>
            <div class="score">93</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">3</div>
            <div class="trainer">user03</div>
            <div class="score">90</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">4</div>
            <div class="trainer">user04</div>
            <div class="score">88</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">5</div>
            <div class="trainer">user05</div>
            <div class="score">86</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">6</div>
            <div class="trainer">user06</div>
            <div class="score">83</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">7</div>
            <div class="trainer">user07</div>
            <div class="score">79</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">8</div>
            <div class="trainer">user08</div>
            <div class="score">72</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">9</div>
            <div class="trainer">user09</div>
            <div class="score">68</div>
        </div>
        <div class="ranking">
            <div class="trainer_ranking">10</div>
            <div class="trainer">user10</div>
            <div class="score">63</div>
        </div>
    </section>
</layout:main>



