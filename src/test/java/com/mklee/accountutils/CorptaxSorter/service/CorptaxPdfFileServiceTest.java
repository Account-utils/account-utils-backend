package com.mklee.accountutils.CorptaxSorter.service;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CorptaxPdfFileServiceTest {

  static final String id = "testfile";
  static final String tmpPath = "tmp";

  @Test
  void simplePdfListTest() throws IOException {
    CorptaxPdfFileService pdfFileService = new CorptaxPdfFileService();
    pdfFileService.setPkgTmpPath(tmpPath);

    pdfFileService.save("1", filepath -> {
      File file = new File(filepath);
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write("-");
      }
    });
    File f = new File(tmpPath + "/2");
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
      writer.write("-");
    }
    f = new File(tmpPath + "/3");
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
      writer.write("-");
    }

    List<String> fileList = pdfFileService.pdfFileList();
    assertThat(fileList).contains("1.pdf").doesNotContain("2").doesNotContain("3");
  }

  @Test
  void simpleTest() throws IOException {
    CorptaxPdfFileService pdfFileService = new CorptaxPdfFileService();
    pdfFileService.setPkgTmpPath(tmpPath);
    {
      File f = pdfFileService.get(id);
      if(f.exists()) {
        f.delete();
      }
    }
    assertThat(pdfFileService.checkExists(id)).isFalse();

    pdfFileService.save(id, filepath -> {
      File file = new File(filepath);
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        writer.write("-");
      }
    });

    assertThat(pdfFileService.checkExists(id)).isTrue();

    File pdfFile = pdfFileService.get(id);
    assertThat(pdfFile).isNotNull();
    assertThat(pdfFile.getName()).isNotNull();
  }
}