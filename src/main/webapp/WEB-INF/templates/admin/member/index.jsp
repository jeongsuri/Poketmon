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
                        <a href="<c:url value='/admin/member/delete/${item.userId}' />" onclick="return confirm('정말 탈퇴하시겠습니까?');">회원탈퇴</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>
</layout:admin> ㅊ스캔되었으나 아무 것도 찾지 못했습니다. 스캔했으나 TLD가 없는 JAR들의 전체 목록을 보시려면, 로그 레벨을 디버그 레벨로 설정하십시오. 스캔 과정에서 불필요한 JAR들을 건너뛰면, 시스템 시작 시간과 JSP 컴파일 시간을 단축시킬 수 있습니다.
03-Jul-2024 09:23:20.499 INFO [main] org.apache.catalina.startup.HostConfig.deployDescriptor 배치 descriptor [/Users/oreo/.SmartTomcat/project/project.main/co