package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.mapper.FileInfoMapper;
import org.choongang.global.config.annotations.Service;

@Service
@RequiredArgsConstructor
public class FileInfoSaveService {

    private final FileInfoMapper mapper;
    private final FileInfoService infoService;

    public FileInfo save(FileInfo data){
        String gid = data.getGid();
        gid = gid == null ? "" : gid;
        data.setGid(gid);

        int result = mapper.register(data);
        if(result > 0 ){
            return infoService.get(data.getSeq()).orElse(null);
        }
        return null;
    }
}
