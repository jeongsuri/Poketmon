<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:main title="${data.name}">
    <section class="pokemon-view">
        <img src="${data.frontDefault}" alt="이미지">

        <div class="p-name">
                ${data.name}
        </div>
        <div class="p-desc">
        </div>

    </section>

</layout:main>