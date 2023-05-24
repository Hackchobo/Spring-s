package com.green.board7.fileupload;

import com.green.board7.fileupload.model.FileEntity;
import com.green.board7.fileupload.model.FileuploadInsDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/fileupload")
public class FileUploadController {
    private final Logger LOGGER;
    private final FileUploadService service;

    @Autowired
    public FileUploadController(FileUploadService service) {
        LOGGER = LoggerFactory.getLogger(FileUploadController.class); //Di를 받기 위한구문
        this.service = service;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.MULTIPART_FORM_DATA_VALUE}) // 폼데이터로만 받았다면 () 안에 값은 필요가 없어진다. 그러나 JSON은 꼭 넣어 줘야 된다.
    public void fileupload(@RequestPart FileuploadInsDto dto
                            ,@RequestPart MultipartFile img){ // -> JSON에서 파일 받을 때는 @RequestPart를 사용해서 파일 데이터를 받는다.
        LOGGER.info("dto: " + dto);
        LOGGER.info("imgFileName: " + img.getOriginalFilename());
        service.fileUpload(dto,img);

    }

}
