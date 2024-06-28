<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='검색결과' />
<c:url var="actionUrl" value="/rank" />
<c:url var="cssUrl" value="/css/" />

<layout:main title="${pageTitle}">
    <div class="searchResult">
        <div class="title">${pageTitle}</div>
        <div class="searchedUser">
            검색된 사용자: ${searchedUserId} 님
        </div>
        <div class="rankings">
            <c:if test="${not empty rankingList}">
                <div class="rankTable">
                    <table>
                        <thead>
                            <tr>
                                <th>순위</th>
                                <th>유저 아이디</th>
                                <th>잡은 포켓몬 수</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="item" items="${rankingList}">
                                <tr>
                                    <td>${item.ranking}</td>
                                    <td>${item.userId}</td>
                                    <td>${item.pokemonCount}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:if>
            <c:if test="${empty rankingList}">
                <div class="noResult">
                    검색 결과가 없습니다.
                </div>
            </c:if>
        </div>
    </div>
</layout:main>