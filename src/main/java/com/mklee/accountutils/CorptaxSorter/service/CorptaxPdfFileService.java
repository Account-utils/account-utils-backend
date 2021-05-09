package com.mklee.accountutils.CorptaxSorter.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@Service
public class CorptaxPdfFileService {
  public interface PdfFileSave {
    void save(String filepath) throws IOException;
  }

  @Value("${file.tmpDir}")
  private String pkgTmpPath;

  public void save(String id, PdfFileSave pdfFileSave) throws IOException {
    Path path = Paths.get(pdfDirPath());
    try {
      Files.createDirectories(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    pdfFileSave.save(pdfFilePath(id));
  }

  public File get(String id) {
    return new File(pdfFilePath(id));
  }

  public boolean checkExists(String id) {
    File f = new File(pdfFilePath(id));
    return f.exists();
  }

  public List<String> pdfFileList(){
    File dir = new File(pdfDirPath());
    return Arrays.stream(Objects.requireNonNull(dir.listFiles()))
        .map(File::getName)
        .filter(fileName -> fileName.contains(".pdf"))
        .collect(Collectors.toList());
  }

  public String pdfFilePath(String id){
    return Paths.get(pdfDirPath(), id + ".pdf").toString();
  }

  private String pdfDirPath(){
    return Paths.get(pkgTmpPath).toString();
  }
}
