package com.mklee.accountutils.ZipOpen;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity openZipFile(@RequestParam("file") MultipartFile file) throws Throwable {
    System.out.println(file.getOriginalFilename());
    System.out.println(file.getName());
    System.out.println(file.getSize());
    if(file.getOriginalFilename().contains(".zip")) {
      zipService.unzip(file);
      return new ResponseEntity<>(HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }
}
