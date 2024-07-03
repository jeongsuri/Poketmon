<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="cssUrl" value="/css/"/>
<layout:main title="커뮤니티">
    <div class="board-container">
        <div class="board">
                <%--   게시판헤더     --%>
            <div class="board-top">
                <div class="title">커뮤니티</div>
                <div class="subTitle">포켓몬 트레이너들의 커뮤니티를 위한 공간입니다. <br> 게시판에서 글을 작성해 주세요.</div>
            </div>

                <%--   게시판바디     --%>
            <div class="table-rows">게시판 목록📌</div>
                <c:if test="${items == null || items.isEmpty()}">
                    <div class="boardList" class="no-data">등록된 게시판이 없습니다.</div>
                </c:if>
                <div class="boards">
                    <c:if test="${items != null && !items.isEmpty()}">
                        <c:forEach var="item" items="${items}">
                            <div class="boardList">
                                <a href="<c:url value='/board/list/${item.BId}'/>">
                                        ${item.BName}
                                </a>
                            </div>
                        </c:forEach>
                    </c:if>
                </div>
        </div>
    </div>
</layout:main>