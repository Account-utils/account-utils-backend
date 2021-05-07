package com.mklee.accountutils.CorptaxSorter.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CorptaxSorterService {
  public void sorterAction(String dirPath, String targetFilePath) throws IOException, InterruptedException {
      pySorterAction(dirPath);
  }

  @Value("${pyaction.command}")
  String pyCommand;

  @Value("${pyaction.actor}")
  String pyActor;

  private void pySorterAction(String dirPath) throws IOException, InterruptedException {
    String[] commands = new String[4];
    commands[0] = pyCommand;
    commands[1] = pyActor;
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
