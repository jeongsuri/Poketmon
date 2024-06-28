package org.choongang.mypage.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

public interface MyPageMapper {

    //  로그인된 내 아이디로 맴버 테이블에서 유저 넘버를 찾음
    @Select("SELECT USER_NO FROM MEMBER WHERE USER_ID = #{userId}")
    int findUserNumberByUserId(@Param("userId") String userId);

    //  찾은 유저 넘버로 마이 포켓몬 테이블에서 잡은 포켓몬 번호를 그룹화하여 조회
    @Select("SELECT DISTINCT POKEMON_NO FROM MYPOKEMON WHERE USER_NO = #{userNumber}")
    List<Integer> findCaughtPokemonNumbers(@Param("userNumber") int userNumber);
}

