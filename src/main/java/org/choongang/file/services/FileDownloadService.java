package org.choongang.file.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.exceptions.FileNotFoundException;
import org.choongang.global.config.annotations.Service;
import org.choongang.global.config.containers.BeanContainer;

import java.io.*;

@Service
@RequiredArgsConstructor
public class FileDownloadService {

    private final FileInfoService infoService;

    /**
     * 1. 파일 정보 조회
     * 2. 파일이 있는지 체크
     * 3. 응답 헤더 : Content-Disposition ...
     * 4. 응답 바디 : 파일 데이터 출력
     * @param seq
     */
    public void download(long seq){
        FileInfo data = infoService.get(seq).orElseThrow(FileNotFoundException::new);
        String filePath = data.getFilePath();
        File file = new File(filePath);

        if(!file.exists()){
            throw new FileNotFoundException();
        }

        HttpServletResponse response = BeanContainer.getInstance().getBean(HttpServletResponse.class);

        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file)))
        {
            String fileName = new String(data.getFileName().getBytes(), "ISO8859-1");
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setIntHeader("Expires", 0); //세션 만료시간 제거
            response.setHeader("Cache-Control", "no-cache");
            response.setContentLengthLong(file.length());

            OutputStream out = response.getOutputStream();
            out.write(bis.readAllBytes());


        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
