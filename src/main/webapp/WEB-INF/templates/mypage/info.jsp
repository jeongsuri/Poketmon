<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<c:url var="actionUrl" value="/mypage/info" />

<layout:main title="회원정보 수정">
    <section class="layout-width">
        <form name="frmSave" method="POST" action="${actionUrl}" target="ifrmProcess" autocomplete="off">
            <div class="form-row">
                <label for="userId">아이디 :</label>
                <input type="text" id="userId" name="userId" value="${loggedMember.userId}" readonly>
            </div>
            <div class="form-row">
                <label for="nickName">닉네임 :</label>
                <input type="text" id="nickName" name="nickName" value="${loggedMember.nickName}">
            </div>
            <div class="form-row">
                <label for="password">비밀번호 :</label>
                <input type="password" id="password" name="password">
            </div>
            <div class="form-row">
                <label for="confirmPassword">비밀번호 확인 :</label>
                <input type="password" id="confirmPassword" name="confirmPassword">
            </div>
            <dl>
                <dt>프로필 이미지</dt>
                <dd>
                    <c:if test="${myProfile != null}">
                        <div class='profile' style="cursor: pointer;">
                            <img src="${myProfile.frontDefault}" alt="${myProfile.name}">
                            <div>${empty myProfile.nickname ? myProfile.name : myProfile.nickname}</div>
                        </div>
                    </c:if>
                    <button class="profile-button" type='button' id="generate-profile-image" style="cursor: pointer;">
                        랜덤 프로필 이미지
                    </button>
                </dd>
            </dl>
            <div class='button-group'>
                <button type="reset" style="cursor: pointer;">다시입력</button>
                <button type="submit" style="cursor: pointer;">수정하기</button>
            </div>
        </form>
        <jsp:include page="_my_pokemon.jsp" />
    </section>
</layout:main>