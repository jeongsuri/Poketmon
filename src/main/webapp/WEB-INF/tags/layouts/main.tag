<%@ tag pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:message var="pageTitle" key='마이페이지' />
<c:url var="actionUrl" value="/member/mypage" />
<c:url var="cssUrl" value="/css/" />
<c:url var="jsUrl" value="/js/" />
<c:url var="logoUrl" value="/images/logo.png" />

<layout:mypage title="${title}">

      <section class="content-box">
              <h1>${pageTitle}</h1>
              <form name="frmSearch" method="POST" action="${actionUrl}" autocomplete="off" target="ifrmProcess">
                  <dl>
                      <dd>
                          <input type="text" name="userIdSearch" autofocus placeholder="아이디">
                      </dd>
                  </dl>

    <jsp:attribute name="footer">
        <h1>메인 레이아웃 하단 영역!</h1>
    </jsp:attribute>
    <jsp:attribute name="commonCss">
        <link rel="stylesheet" type="text/css" href="${cssUrl}main.css">
    </jsp:attribute>
    <jsp:attribute name="commonJs">
        <script src="${jsUrl}main.js"></script>
    </jsp:attribute>
    <jsp:body>
        <jsp:doBody />
    </jsp:body>
</layout:common>