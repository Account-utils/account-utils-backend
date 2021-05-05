package com.mklee.accountutils.ZipOpen;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Validated
@RestController
@RequestMapping("/zip-open")
public class ZipOpenController {
  @Autowired
  ZipOpenService zipService;

  @PostMapping
  public void openZipFile(@RequestParam("file") MultipartFile file) throws Throwable {
    System.out.println(file.getOriginalFilename());
    System.out.println(file.getName());
    System.out.println(file.getSize());
    // TODO zip 아니면 쳐내기
    zipService.unzip(file);
  }
}
