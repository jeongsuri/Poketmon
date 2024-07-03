<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="cssUrl" value="/css/"/>

<layout:admin title="회원정보 수정">
    <h1>회원 정보 수정</h1>
    <section class="layout-width">
            <dl>
                <dt>회원번호</dt>
                <dd>
                    <label>${data.userNo}</label>
                </dd>
            </dl>
            <dl>
                <dt>아이디</dt>
                <dd>
                    <label>${data.userId}</label>
                </dd>
            </dl>
        <form name="frmSave" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <dl>
                <dt>닉네임</dt>
                <dd>
                    <input type="text" name="nickName" value="${data.nickName}">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호</dt>
                <dd>
                    <input type="text" name="password" value="" placeholder="비밀번호를 변경할 경우에만 입력하시오.">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호 확인</dt>
                <dd>
                    <input type="text" name="password" value="" placeholder="비밀번호를 변경할 경우에만 입력하시오.">
                </dd>
            </dl>
            <dl>
                <dt>권한</dt>
                <label><input type="radio" name="role" value="admin" <c:if test="${data.userType == 'ADMIN'}">checked</c:if>> 관리자</label>
                <label><input type="radio" name="role" value="user" <c:if test="${data.userType == 'USER'}">checked</c:if>> 회원</label>
            </dl>
            <div class="button-group">
                <a href="<c:url value="/admin/member"/>">뒤로가기</a>
                <button type="submit">수정</button>
            </div>
        </form>

    </section>
</layout:admin>