<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/mypage/info" />

<layout:main title="회원정보 수정">
    <section class="layout-width">
        <form name="frmSave" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <dl>
                <dt>아이디</dt>
                <dd>${loggedMember.userId}</dd>
            </dl>
            <dl>
                <dt>닉네임</dt>
                <dd>
                    <input type="text" name="nickName" value="${loggedMember.nickName}">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호</dt>
                <dd>
                    <input type="password" name="password">
                </dd>
            </dl>
            <dl>
                <dt>비밀번호 확인</dt>
                <dd>
                    <input type="password" name="confirmPassword">
                </dd>
            </dl>
            <dl>
                <dt>프로필 이미지</dt>
                <dd>
                    <c:if test="${myProfile != null}">
                       <div class='profile'>
                            <img src="${myProfile.frontDefault}" alt="${myProfile.name}">
                            <div>${empty myProfile.nickname ? myProfile.name : myProfile.nickname}</div>
                       </div>
                    </c:if>
                </dd>
            </dl>
            <div class='button-group'>
                <button type="reset">다시입력</button>
                <button type="submit">수정하기</button>
            </div>
        </form>
         <jsp:include page="_my_pokemon.jsp" />
    </section>
</layout:main>