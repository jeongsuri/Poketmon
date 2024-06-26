package org.choongang.board.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.board.entities.Board;
import org.choongang.board.entities.BoardData;
import org.choongang.board.exceptions.BoardConfigNotFoundException;
import org.choongang.board.exceptions.BoardNotFoundException;
import org.choongang.board.services.BoardInfoService;
import org.choongang.board.services.BoardSaveService;
import org.choongang.board.services.config.BoardConfigInfoService;
import org.choongang.global.config.annotations.*;
import org.choongang.global.exceptions.AlertException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardConfigInfoService configInfoService;
    private final HttpServletRequest request;
    private final BoardSaveService saveService;
    private final BoardInfoService infoService;
    private BoardData boardData;


    //게시판 리스트보기
    @GetMapping
    public String boardList() {
        List<Board> items = configInfoService.getList();
        request.setAttribute("items", items);
        request.setAttribute("addCss", List.of("board"));
        return "board/boardList";
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
        commonProcess(seq, "view");
        return "board/view";
    }

    //게시글 작성
    @GetMapping("/write/{bId}")
    public String write(@PathVariable("bId") String bId) {
        commonProcess(bId, "write");
        RequestBoardData data = new RequestBoardData();
        data.setBId(bId);

        request.setAttribute("data",data);
        return "board/write";
    }

    //게시글 수정
    @GetMapping("/update/{seq}")
    public String update(@PathVariable("seq") long seq) {
        commonProcess(seq, "update");
        RequestBoardData data = infoService.getForm(boardData);
        request.setAttribute("data",data);
        return "board/update";
    }

    @PostMapping("/save")
    public String save(RequestBoardData form) {
        String mode = form.getMode();
        String modeStr = mode.equals("update") ? "수정":"등록";
        String message = "게시글 " + modeStr + "에 실패하였습니다";

        BoardData data = saveService.save(form).orElseThrow(() -> new AlertException(message, HttpServletResponse.SC_BAD_REQUEST));

        // 게시글 등록, 수정이 완료 되면 - 게시글 보기로 이동
        String url = request.getContextPath() + "/board/view/" + data.getSeq();
        String script = String.format("parent.location.replace('%s');", url);
        request.setAttribute("script", script);

        return "commons/execute_script";
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

    /**
     * 게시글 번호가 있는 페이지 URL
     * 게시글 보기. 게시글 수정
     * @param seq
     * @param mode
     */
    private void commonProcess(long seq, String mode){
        boardData = infoService.get(seq).orElseThrow(BoardNotFoundException::new);
        String bId = boardData.getBId();
        commonProcess(bId, mode);

        request.setAttribute("data", boardData);

    }
}