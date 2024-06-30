<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="cssUrl" value="/css/"/>

<layout:admin title="회원 목록">
    <h1>회원 목록</h1>

    <table class="table-rows">
        <thead>
        <tr>
            <th width=70>회원번호</th>
            <th width=200>회원 ID</th>
            <th width=100>유형</th>
            <th width=200>닉네임</th>
            <th width=200">작업</th>
        </tr>
        </thead>
        <tbody>
        <c:if test="${items} == null || items.isEmpty()}">
            <tr>
                <td>
                <td colspan="3" class="no-data">등록된 회원이 없습니다.</td>
                </td>
            </tr>
        </c:if>
        <c:if test="${items != null && !items.isEmpty()}">
            <c:forEach var="item" items="${items}">
                <tr>
                    <td>${item.userNo}</td>
                    <td>${item.userId}</td>
                    <td>${item.userType}</td>
                    <td>${item.nickName}</td>
                    <td>
                        <a href="<c:url value="/admin/member/update/${item.userId}"/>">
                            정보수정
                        </a>
                        <a href="<c:url value="/admin/member/delete/${item.userId}"/>">
                            회원탈퇴
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</layout:admin>