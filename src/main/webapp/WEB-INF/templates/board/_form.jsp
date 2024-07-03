<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/utils" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='게시글_작성' />
<c:url var="actionUrl" value="/board" />

<input type="hidden" name="bId" value="${data.BId}">
<input type="hidden" name="gId" value="${data.GId}">

<c:if test="${board.activeCategory == 1}">
    <div class="category-container">
        <span class="category-title">분류 선택</span>
        <div class="category-options">
            <c:forEach var="category" items="${board.categories}" varStatus="status">
                <input type="radio" name="category" value="${category}" id="category-${status.index}"${data.category != null && category.trim().equals(data.category) ? ' checked':''}>
                <label for="category-${status.index}">${category}</label>
            </c:forEach>
        </div>
    </div>
</c:if>

<div class="form-group">
    <span class="form-label">작성자</span>
    <div class="input-container">
        <c:if test="${data.mode == 'update'}">
            <input type="text" name="poster" value="${data.poster}">
        </c:if>
        <c:if test="${data.mode != 'update'}">
            <input type="text" name="poster" value="${loggedMember != null ? loggedMember.nickName : ''}">
        </c:if>
        <c:if test="${isAdmin}">
            <input type="checkbox" name="notice" value="true" id="notice"${data.notice ? ' checked':''}>
            <label for="notice">공지글</label>
        </c:if>
    </div>
</div>
<util:guestOnly>
    <dl>
        <dt>비밀번호</dt>
        <dd>
            <input type="password" name="guestPassword" placeholder="글 수정, 삭제 비밀번호">
        </dd>
    </dl>
</util:guestOnly>
<div class="form-group-title">
    <span class="form-label-title">제목</span>
    <span class="input-container-title">
        <input type="text" name="subject" value="${data.subject}">
    </span>
</div>
<div class="form-group-content">
    <span class="form-label-content">내용</span>
    <span class="input-container-content">
        <textarea name="content" id="content">${data.content}</textarea>
    </span>
</div>
<div class="form-group-image">
    <span class="form-label-image">이미지 첨부</span>
    <span class="input-container-image">
        <button type="button">이미지 선택</button>
    </span>
</div>
<div class="form-group-file">
    <span class="form-label-file">파일 첨부</span>
    <span class="input-container-file">
        <button type="button">파일 선택</button>
    </span>
</div>