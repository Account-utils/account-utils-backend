package com.mklee.accountutils.CorptaxSorter.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Paths;

@Service
public class CorptaxSorterService {
  public void sorterAction(String dirPath, String targetFilePath) throws IOException, InterruptedException {
      pySorterAction(dirPath);
  }

  private void pySorterAction(String dirPath) throws IOException, InterruptedException {
    String[] commands = new String[4];
    commands[0] = "python3";
    commands[1] = Paths.get("/", "pyservice", "bin.py").toString();
    commands[2] = "-d";
    commands[3] = dirPath;

    ProcessBuilder builder = new ProcessBuilder(commands);
    builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
    builder.redirectError(ProcessBuilder.Redirect.INHERIT);
    System.out.println(builder.command());
    Process p = builder.start();
    p.waitFor();
  }
}
