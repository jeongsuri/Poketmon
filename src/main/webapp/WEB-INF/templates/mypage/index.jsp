<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="layout" tagdir="/WEB-INF/tags/layouts" %>
<fmt:setBundle basename="messages.commons"/>
<fmt:message var="pageTitle" key='마이페이지'/>
<c:url var="actionUrl" value="/mypage"/>
<c:url var="cssUrl" value="/css/"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Page</title>
</head>
<body>
    <h1>Welcome to My Page</h1>

    <%-- 예시로 사용자 아이디가 "testUser"라고 가정 --%>
    <% String userId = "testUser"; %>

    <%-- MyBatis Mapper를 사용하여 사용자 정보 조회 --%>
    <%
        try {
            // MyBatis Mapper 인터페이스 가져오기
            org.example.mapper.MyPageMapper mapper = org.example.mapper.MyBatisSessionFactory.getSqlSession().getMapper(org.example.mapper.MyPageMapper.class);

            //  로그인된 내 아이디로 맴버 테이블에서 유저 넘버를 찾음
            int userNumber = mapper.findUserNumberByUserId(userId);

            //  찾은 유저 넘버로 마이 포켓몬 테이블에서 잡은 포켓몬 번호를 그룹화하여 조회
            List<Integer> caughtPokemonNumbers = mapper.findCaughtPokemonNumbers(userNumber);

            // 출력 예시: 잡은 포켓몬 번호들을 쉼표로 구분하여 출력
            out.println("<h2>Caught Pokemon Numbers:</h2>");
            for (Integer pokemonNo : caughtPokemonNumbers) {
                out.println(pokemonNo + ", ");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error occurred while fetching data.</h2>");
        }
    %>

</body>