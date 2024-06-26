<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons"/>
<fmt:message var="pageTitle" key='게시판'/>
<c:url var="actionUrl" value="/board/write"/>
<c:url var="cssUrl" value="/css/"/>

<layout:main title="${pageTitle}">

    <%--  상단  --%>
    <div class="board">
        <div class="board-top">
            <h1>자유게시판</h1>
            <h3 class="mrg_t sub">자유로운 게시판입니다. <br> 해당 게시판에서 글 작성 해주세요</h3>
            <div class="button-write">
                <form action="${actionUrl}" method="get">
                    <button type="submit">
                        <fmt:message key="글쓰기"/>
                    </button>
                </form>
            </div>
        </div>


        <!--게시물 표시 영역 -->
        <div class="border-body">
            <div class="border-body">
                <table>
                    <thead>
                    <tr>
                        <th scope="col" class="no"><span>번호</span></th>
                        <th scope="col" class="title"><span>제목</span></th>
                        <th scope="col" class="name"><span>글쓴이</span></th>
                        <th scope="col" class="date"><span>날짜</span></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td class="seq">
                            <div>1</div>
                        </td>
                        <td class="title">
                            <a class="pjax" href="">제목어쩌고저저꼬</a>
                        </td>
                        <td class="name">
                            <div>글쓴이</div>
                        </td>
                        <td class="date">
                            <div>2024.04.05</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="seq">
                            <div>2</div>
                        </td>
                        <td class="title">
                            <a class="pjax" href="">제목어쩌고저저꼬</a>
                        </td>
                        <td class="name">
                            <div>글쓴이</div>
                        </td>
                        <td class="date">
                            <div>2024.04.06</div>
                        </td>
                    </tr>
                    <tr>
                        <td class="seq">
                            <div>3</div>
                        </td>
                        <td class="title">
                            <a class="pjax" href="">제목어쩌고저저꼬</a>
                        </td>
                        <td class="name">
                            <div>글쓴이</div>
                        </td>
                        <td class="date">
                            <div>2024.04.07</div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>

            <%--    하단    --%>
        <div id="board-bottom">
            <form action="" method="get" class="search" onsubmit="return procFilter(this, search);"><input type="hidden" name="act" value="">
                <input class="keyword" type="text" name="search_keyword" value="" placeholder="검색어를 입력하세요." autocomplete="off">
                <div class="button-search">
                    <button type="submit">
                        <fmt:message key="검색"/>
                    </button>
                </div>
            </form>
        </div>
    </div>
</layout:main>

