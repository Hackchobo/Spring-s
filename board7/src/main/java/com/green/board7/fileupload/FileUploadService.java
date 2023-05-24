package com.green.board7.fileupload;

import com.green.board7.fileupload.model.FileEntity;
import com.green.board7.fileupload.model.FileuploadInsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileUploadService {

    private FileUploadMapper mapper;

    @Autowired
    public FileUploadService(FileUploadMapper mapper) {
        this.mapper = mapper;
    }

    @Value("${file.dir}")
    private String fileDir;

    public void fileUpload(FileuploadInsDto dto ,MultipartFile img) {
        System.out.println("filrDir : " + fileDir);

        //원래 파일 이름 추출
        String originfileName = img.getOriginalFilename();

        //파일 이름으로 사용할 uuid 생성
        String uuid = UUID.randomUUID().toString();

        String ext = originfileName.substring(originfileName.lastIndexOf(".")); // 확장자명을 알아내는 구문(확장자를 뽑아내는것)

        String savedFileName = uuid +ext; // 경로가 내가 정확 한지 알경우 이걸 쓰면 된다.
        String savedFilePath = fileDir + savedFileName; // 내가 경로를 잘모를 때 사용

        File file = new File(savedFilePath); //객체를 만드는 이유는 경로만 주면 되는게 아니라 객체의 주소값을 주어야 파일을 찾아서
        try {
            img.transferTo(file);

            FileEntity entity =FileEntity.builder()
                    .path(savedFilePath)
                    .uploader(dto.getUploader())
                    .levelValue(dto.getLevelValue())
                    .build();
            mapper.insFile(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
