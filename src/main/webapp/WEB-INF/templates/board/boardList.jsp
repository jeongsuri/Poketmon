<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="cssUrl" value="/css/"/>
<layout:main title="게시판 목록">
    <div class="board-container">
        <div class="board">
                <%--   게시판헤더     --%>
            <div class="board-top">
                <h1>커뮤니티</h1>
                <h3 class="mrg_t sub">포켓몬 트레이너들의 커뮤니티를 위한 공간입니다. <br> 게시판에서 글 작성 해주세요.</h3>
            </div>

                <%--   게시판바디     --%>
            <table class="table-rows">
                <thead>
                <tr>
                    <th width="150">게시판 이름</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${items == null || items.isEmpty()}">
                    <tr>
                        <td colspan="3" class="no-data">등록된 게시판이 없습니다.</td>
                    </tr>
                </c:if>
                <c:if test="${items != null && !items.isEmpty()}">
                    <c:forEach var="item" items="${items}">
                        <tr>
                            <td>
                                <a href="<c:url value='/board/list/${item.BId}'/>">
                                        ${item.BName}
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div>
</layout:main>