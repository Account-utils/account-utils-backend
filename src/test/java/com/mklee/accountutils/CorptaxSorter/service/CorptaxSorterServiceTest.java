package com.mklee.accountutils.CorptaxSorter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class CorptaxSorterServiceTest {
  @Test
  public void simplePyRunTest() throws IOException, InterruptedException {
    String dirpath = "/Users/mk/Projects/account-utils/src/test/resources/pdfsorter/test";
    String pdfpath = "/Users/mk/Projects/account-utils/src/test/resources/pdfsorter/test.pdf";

    if(new File(pdfpath).exists()) {
      new File(pdfpath).delete();
      assertThat(new File(pdfpath).exists()).isFalse();
    }

    CorptaxSorterService corptaxSorterService = new CorptaxSorterService();
    corptaxSorterService.sorterAction(dirpath, pdfpath);

    assertThat(new File(pdfpath).exists()).isTrue();
  }
}