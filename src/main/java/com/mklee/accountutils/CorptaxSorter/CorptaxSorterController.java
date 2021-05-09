package com.mklee.accountutils.CorptaxSorter;

import com.mklee.accountutils.CorptaxSorter.service.CorptaxPdfFileService;
import com.mklee.accountutils.CorptaxSorter.service.CorptaxSorterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Validated
@RestController
@RequestMapping("/corptax")
public class CorptaxSorterController {
  @Autowired
  CorptaxPdfFileService pdfFileService;

  @Autowired
  CorptaxSorterService sorterService;

  @GetMapping
  public ResponseEntity<InputStreamResource> getSoredCorptaxPdf(@RequestParam(name="id") String id) throws IOException {
    File pdfFile = pdfFileService.get(id);
    if(!pdfFile.exists()) {
      return new ResponseEntity<>(HttpStatus.OK);
    }

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.parseMediaType("application/pdf"));
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Methods", "GET, POST, PUT");
    headers.add("Access-Control-Allow-Headers", "Content-Type");
    headers.add("Content-Disposition", "attachment; filename=" + id + ".pdf");
    headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
    headers.add("Pragma", "no-cache");
    headers.add("Expires", "0");
    headers.setContentLength(pdfFile.length());

    FileInputStream is = new FileInputStream(pdfFile);
    InputStreamResource isr = new InputStreamResource(is);

    return new ResponseEntity<>(isr, headers, HttpStatus.OK);
  }

  @PostMapping
  public CorptaxSorterDto.simpleDto doCorptaxSorterAction(@RequestParam(name="id") String id) {
    CorptaxSorterDto.simpleDto simpleDto = new CorptaxSorterDto.simpleDto();

    String targetFilePath = pdfFileService.pdfFilePath(id);
    String dirPath = targetFilePath.substring(0, targetFilePath.length() - ".pdf".length());

    try {
      sorterService.sorterAction(dirPath, targetFilePath);
      simpleDto.setSuccess("Y");
    } catch (Exception e) {
      e.printStackTrace();
      simpleDto.setMessage(e.getMessage());
      simpleDto.setSuccess("N");
    }

    return simpleDto;
  }

  @GetMapping("/list")
  public List<String> getCorptaxPdfList() {
    return pdfFileService.pdfFileList();
  }

  @GetMapping("/check")
  public CorptaxSorterDto.simpleDto checkResultExists(@RequestParam(name="id") String id){
    CorptaxSorterDto.simpleDto simpleDto = new CorptaxSorterDto.simpleDto();
    simpleDto.setSuccess(
        pdfFileService.checkExists(id)? "Y" : "N"
    );
    return simpleDto;
  }
}
