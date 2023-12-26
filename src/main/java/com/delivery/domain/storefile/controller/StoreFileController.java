package com.delivery.domain.storefile.controller;

import com.delivery.domain.storefile.entity.StoreFileEntity;
import com.delivery.domain.storefile.repository.StoreFileRepository;
import com.delivery.domain.storefile.service.StoreFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StoreFileController {

    private final StoreFileService storeFileService;
    private final StoreFileRepository storeFileRepository;


//    @GetMapping("/upload")
//    public String testUploadForm(){
//        return "layouts/testImage";
//    }
//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile file, @RequestParam("files") List<MultipartFile> files) throws IOException {
//        storeFileService.saveFile(file);
//
//        for (MultipartFile multipartFile : files) {
//            storeFileService.saveFile(multipartFile);
//        }
//
//        return "redirect:/";
//    }

    @GetMapping("/view")
    public String view(Model model) {

        List<StoreFileEntity> files = storeFileRepository.findAll();
        model.addAttribute("all",files);
        return "layouts/view";
    }


    //   이미지 출력
    @GetMapping("/images/{fileId}")
    @ResponseBody
    public Resource downloadImage(@PathVariable("fileId") Long id, Model model) throws IOException{

        StoreFileEntity file = storeFileRepository.findById(id).orElse(null);
        return new UrlResource("file:" + file.getSavedPath());
    }

    // 첨부 파일 다운로드
    @GetMapping("/attach/{id}")
    public ResponseEntity<Resource> downloadAttach(@PathVariable Long id) throws MalformedURLException {

        StoreFileEntity file = storeFileRepository.findById(id).orElse(null);

        UrlResource resource = new UrlResource("file:" + file.getSavedPath());

        String encodedFileName = UriUtils.encode(file.getOrgNm(), StandardCharsets.UTF_8);

        // 파일 다운로드 대화상자가 뜨도록 하는 헤더를 설정해주는 것
        // Content-Disposition 헤더에 attachment; filename="업로드 파일명" 값을 준다.
        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
    }
}
