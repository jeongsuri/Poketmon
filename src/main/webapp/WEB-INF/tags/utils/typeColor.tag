<%@ tag body-content="empty" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ tag import="org.choongang.game.services.TypeColor" %>
<%@ attribute name="value" %>
<%
    if (value != null) {
        TypeColor typeColor = new TypeColor();
        out.write(typeColor.getTypeColor(value));
    }
%>