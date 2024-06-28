<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='회원가입' />
<c:url var="actionUrl" value="/member/join" />

<layout:memberMain title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
        <form class="form-container"  name="frmJoin" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
            <dl>
                <dd>
                    <input type="text" name="userId" autofocus placeholder="아이디">
                </dd>
            </dl>
            <p class="text-muted form-supple">* 영문자와 숫자로 구성된 8~20자의 아이디를 입력해주세요.</p>
            <dl>
            </dl>
            <dl>
                <dd>
                    <input type="password" name="password" autofocus placeholder="비밀번호">
                </dd>
            </dl>
            <p class="text-muted form-supple">* 영문자와 숫자로 구성된 8~20자의 비밀번호를 입력해주세요.</p>
            <dl>
                <dd>
                    <input type="password" name="confirmPassword" autofocus placeholder="입력한 비밀번호와 동일한 비밀번호를 입력해 주세요.">
                </dd>
            </dl>
            <dl>
                <dd>
                    <input type="text" name="nickName" autofocus placeholder="닉네임을 입력해 주세요.">
                </dd>
            </dl>
            <div class="button-group">
                <button type="submit" class="button">
                    <fmt:message key="가입" />
                </button>
            </div>
        </form>
    </section>
</layout:memberMain>