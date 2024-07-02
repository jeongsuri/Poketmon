<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="searchUrl" value='/board/list/${board.BId}' />
<layout:main title="${board.BName}">
    <section class="layout-width">
        <jsp:include page="_header.jsp"/>
        <div class="btns">
            <a href="<c:url value="/board/write/${board.BId}"/>"/>글쓰기</a>
        </div>

        </div>
        <jsp:include page="_list.jsp"/>
    </section>
</layout:main>