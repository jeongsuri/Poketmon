<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='게시판' />
<c:url var="actionUrl" value="/board/boarding" />
<c:url var="cssUrl" value="/css/" />

<layout:main title="${pageTitle}">
    <div id="border-top" class="clear">
        <div class="_hd">
<%--      상단      --%>
            <div class="Li">
                <h1>
                    자유게시판
                </h1>
                <h5 class="mrg_t sub">자유로운 게시판입니다. <br> 해당 게시판에서 글 작성 해주세요</h5>
            </div>
        </div>
        <!-- // 목록 중단 - 게시물 표시 영역 -->
        <div class="border-body">
            <table class="_listA">
                <thead>
                    <th scope="col" class="no"><span>번호</span></th>
                    <th scope="col" class="title"><span>제목</span></th>
                    <th scope="col" class="name"><span>글쓴이</span></th>
                    <th scope="col" class="date"><span>날짜</span></th>
                </thead>
                <tbody>
                    <td>1433720</td>
                    <td class="title">
                        <a class="pjax" href="">제목</a>
                    </td>
                    <td class="name">
                        <span>
                            <div class="info">
                                글쓴이
                            </div>
                        </span>
                    <td>날짜</td>
                </tbody>
            </table>
        </div>
<%--    하단    --%>
        <div id="board-bottom">
            <form action="" method="get" class="search" onsubmit="return procFilter(this, search);"><input type="hidden" name="act" value="">
                <input class="keyword fr" type="text" name="search_keyword" value="" placeholder="검색어를 입력하세요." autocomplete="off">
                <div class="button">
                    <button type="submit">
                        <fmt:message key="검색"/>
                    </button>
                </div>
            </form>
        </div>
    </div>
</layout:main>

