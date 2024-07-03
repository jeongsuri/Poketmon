<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<layout:popup>
    <section class="popup-view">
    <form method="post" action="<c:url value='/pokemon/popup' />" autocomplete="off" target="ifrmProcess">
        <input type="hidden" name="seq" value="${data.seq}">
        <img src="${data.frontDefault}" alt="${data.name}">
        <div>${data.name}</div>
        <div>${fn:replace(data.flavorText, '\\n', '<br>')}</div>
        <button type='submit'>프로필 이미지로 선택</button>
    </form>
    </section>
</layout:popup>