<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<c:url var="cssUrl" value="/css/"/>
<c:url var="actionUrl" value="/admin/member/update"/>

<layout:admin title="회원정보 수정">
    <h1>회원 정보 수정</h1>
    <section class="layout-width">
        <form name="frmSave" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <section class="readOnly">
            <dl>
                <dt>회원번호</dt>
                <dd>
                    <input type="text" name="userNo" value="${data.userNo}" readonly>
                </dd>
            </dl>
            <dl>
                <dt>아이디</dt>
                <dd>
                    <input type="text" name="userId" value="${data.userId}" readonly>
                </dd>
            </dl>
            </section>
            <dl>
                <dt>닉네임</dt>
                <dd>
                    <input type="text" name="nickName" value="${data.nickName}">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호</dt>
                <dd>
                    <input type="password" name="password" value="" placeholder="비밀번호를 변경할 경우에만 입력하시오.">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호 확인</dt>
                <dd>
                    <input type="password" name="confirmPassword" value="" placeholder="비밀번호를 변경할 경우에만 입력하시오.">
                </dd>
            </dl>
            <dl>
                <dt>권한</dt>
                <label><input type="radio" name="userType" value="admin" <c:if test="${data.userType == 'ADMIN'}">checked</c:if>> 관리자</label>
                <label><input type="radio" name="userType" value="user" <c:if test="${data.userType == 'USER'}">checked</c:if>> 회원</label>
            </dl>
            <div class="button-group">
                <a href="<c:url value="/admin/member"/>">뒤로가기</a>
                <button type="submit" onclick="return confirm('정말 수정하시겠습니까?')">수정</button>
            </div>
        </form>

    </section>
</layout:admin>