package org.choongang.board.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.services.config.BoardConfigInfoService;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PathVariable;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardConfigInfoService configInfoService;
    private final HttpServletRequest request;


    //게시판 리스트보기
    @GetMapping
    public String boardList() {
        List<Board> items = configInfoService.getList();
        request.setAttribute("items", items);
        request.setAttribute("addCss", List.of("board"));
        return "/board/boardList";
    }

    //게시글 리스트보기
    @GetMapping("/list/{bId}")
    public String list(@PathVariable("bId") String bId) {
        commonProcess(bId, "list");

        return "board/list";
    }

    //게시글보기
    @GetMapping("/view/{seq}")
    public String view(@PathVariable("seq") long seq) {

        return "board/view";
    }

    //게시글 작성
    @GetMapping("/write/{bId}")
    public String write(@PathVariable("bId") String bId) {
        commonProcess(bId, "write");

        return "board/write";
    }

    //게시글 수정
    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") long seq) {

        return "board/update";
    }

    /**
     * 모든 요청 처리 메서드에 공통 처리 부분
     *
     * @param bId : 게시판 설정 유지 / 게시판 설정 X -> 게시판이 없음(BoardConfigNotFoundException)
     * @param mode : 처리 모드 - write, update, list, view
     */
    private void commonProcess(String bId, String mode) {
        Board board = configInfoService.get(bId).orElseThrow(BoardConfigNotFoundException::new);

        // mode가 null이면 write로 기본값 설정
        mode = Objects.requireNonNullElse(mode, "write");

        List<String> addCss = new ArrayList<>();
        List<String> addScript = new ArrayList<>();

        addCss.add("board/style"); // 모든 게시판의 공통 스타일

        if (mode.equals("write") || mode.equals("update")) { // 쓰기, 수정
            addCss.add("board/form");
            addScript.add("ckeditor5/ckeditor");
            addScript.add("board/form");

        } else if (mode.equals("list")) { // 목록
            addCss.add("board/list");

        } else if (mode.equals("view")) { // 글보기
            addCss.add("board/view");

        }

        request.setAttribute("board", board);
        request.setAttribute("addCss", addCss);
        request.setAttribute("addScript", addScript);
    }
}