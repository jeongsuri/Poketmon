<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="cssUrl" value="/css/"/>

<layout:admin title="회원정보 수정">
    <h1>회원 정보 수정</h1>
    <section class="layout-width">
        <form name="frmSave" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <dl>
                <dt>회원번호</dt>
                <dd>
                    <input type="text" name="userNo" value="${data.userNo}">
                </dd>
            </dl>
            <dl>
                <dt>아이디</dt>
                <dd>
                    <input type="text" name="userId" value="${data.userId}">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호</dt>
                <dd>
                    <input type="text" name="password" value="">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호 확인</dt>
                <dd>
                    <input type="text" name="password" value="">
                </dd>
            </dl>
            <dl>
                <dt>권한</dt>
                <dd>
                </dd>
            </dl>
            <dl>
                <dt>닉네임</dt>
                <dd>
                    <input type="text" name="nickName" value="${data.nickName}">
                </dd>
            </dl>
            <div class="button-group">
                <button type="reset">뒤로가기</button>
                <button type="submit">수정</button>
            </div>
        </form>

    </section>
</layout:admin>