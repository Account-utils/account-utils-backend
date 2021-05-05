package com.mklee.accountutils.ZipOpen;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ZipOpenService {
  @Value("${file.tmpDir}")
  private String pkgTmpPath;

  public void unzip(MultipartFile file) throws Throwable {
    Path targetPath = Paths.get(pkgTmpPath);
    Files.createDirectories(targetPath);
    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
    if(fileName.contains("..")) {
      throw new FileUploadException("파일명에 부적합 문자가 포함되어 있습니다. " + fileName);
    }
    Path zipFilePath = targetPath.resolve(fileName);

    storeFile(file, zipFilePath);
    String zipFileName = zipFilePath.toString();
    decompress(zipFilePath.toString(), zipFileName.substring(0, zipFileName.length() - ".zip".length()));
  }

  private String storeFile(MultipartFile file, Path targetLocation) throws FileUploadException {
    String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

    try {
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
      return fileName;
    }catch(Exception e) {
      throw new FileUploadException("["+fileName+"] 파일 업로드에 실패하였습니다. 다시 시도하십시오.",e);
    }
  }

  private void decompress(String zipFilePath, String unzipDirPath) throws Throwable {
    File zipFile = new File(zipFilePath);
    try(
        FileInputStream fis = new FileInputStream(zipFile);
        ZipInputStream zis = new ZipInputStream(fis);
    ) {
      ZipEntry zipentry = null;
      while ((zipentry = zis.getNextEntry()) != null) {
        String filename = zipentry.getName();
        File file = new File(unzipDirPath, filename);
        if (zipentry.isDirectory()) {
          file.mkdirs();
        } else {
          createFile(file, zis);
        }
      }
    } catch (Throwable e) {
      throw e;
    }
  }

  private void createFile(File file, ZipInputStream zis) throws Throwable {
    File parentDir = new File(file.getParent());
    if (!parentDir.exists()) {
      parentDir.mkdirs();
    }

    try (FileOutputStream fos = new FileOutputStream(file)) {
      byte[] buffer = new byte[256];
      int size = 0;
      while ((size = zis.read(buffer)) > 0) {
        fos.write(buffer, 0, size);
      }
    } catch (Throwable e) {
      throw e;
    }
  }
}
