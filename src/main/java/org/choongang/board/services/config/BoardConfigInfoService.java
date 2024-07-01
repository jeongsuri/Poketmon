package org.choongang.board.services.config;


import lombok.RequiredArgsConstructor;
import org.choongang.admin.board.controllers.RequestBoard;
import org.choongang.board.entities.Board;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.mapper.BoardMapper;
import org.choongang.global.config.annotations.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardConfigInfoService {
    private final BoardMapper mapper;

    public Optional<Board> get(String bid){
        Board board = mapper.get(bid);

        return Optional.ofNullable(board);
    }

    public RequestBoard getForm(String bId){
        Board board = get(bId).orElseThrow(BoardConfigNotFoundException::new);

        RequestBoard form = new RequestBoard();
        form.setMode("update");
        form.setBId(board.getBId());
        form.setBName(board.getBName());
        form.setBName(board.getBName());
        form.setRowsPerPage(board.getRowsPerPage());
        form.setBName(board.getBName());
        form.setActive(board.getActive()==1);
        form.setActiveCategory(board.getActiveCategory() == 1);
        form.setCategory(board.getCategory());
        form.setAuthority(board.getAuthority().name());

        return form;
    }

    //게시판 목록 조회
    public List<Board> getList(){

        return mapper.getList();
    }


}
