<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag import="org.choongang.game.services.TypeColorService" %>
<%@ attribute name="value" %>
<%
    if (value != null) {
        TypeColorService typeColor = new TypeColorService();
        out.write(typeColor.getTypeColor(value));
    }
%>