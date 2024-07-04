<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<layout:main title="${data.name}">
    <section class="pokemon-view">
        <div class="box">
        <div class="each-pokemon">
            <img src="${data.frontDefault}" alt="이미지">
        </div>

        <div class="pokemon-info">
            <div class="p-item p-name">
                &lt;이름&gt; ${data.name}
            </div>

            <div class="p-item p-weight">
                &lt;몸무게&gt;${data.weight/10}kg
            </div>

            <div class="p-item p-type">
                &lt;속성 타입 1&gt; ${data.type1} / <속성 타입 2> ${data.type2}
            </div>

            <div class="p-item p-desc">
                <div class="inner">
                &lt;특징&gt; ${fn:replace(data.flavorText, '\\n', ' ')}
                </div>
            </div>
        </div>
        </div>
    </section>
</layout:main>