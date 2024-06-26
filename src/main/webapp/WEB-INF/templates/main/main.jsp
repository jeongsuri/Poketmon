<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<fmt:setBundle basename="messages.commons" />
<fmt:message var="pageTitle" key='POKETMON' />
<c:url var="actionUrl" value="/main" />

<layout:main title="${pageTitle}">
    <section class="content-box">
        <h1>${pageTitle}</h1>
    </section>
</layout:main>