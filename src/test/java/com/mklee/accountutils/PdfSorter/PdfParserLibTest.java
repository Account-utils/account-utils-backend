package com.mklee.accountutils.PdfSorter;

import com.mklee.accountutils.PdfSorter.PdfToText.CopyStrtgyPdfToText;
import com.mklee.accountutils.PdfSorter.PdfToText.PdfToText;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class PdfParserLibTest {

  class PdfSorterJsonIndex {
    String filename;
    String title;
    PdfSorterJsonIndex(String filename, String title) {
      this.filename = filename;
      this.title = title;
    }
    @Override public String toString() {
      return "{" + "filename='" + filename + '\'' + ", title='" + title + '\'' + '}';
    }
  }

  @Test
  public void simplePdfToTextTest() {
    //PdfToText pdfToText = new SimplePdfBoxPdfToText();
    PdfToText pdfToText = new CopyStrtgyPdfToText();

    List<PdfSorterJsonIndex> pdfSorterIndexList = Arrays.asList(
        new PdfSorterJsonIndex("103-0.pdf", "법인세신고서접수증"),
        new PdfSorterJsonIndex("103-1.pdf", "손익계산서"),
        new PdfSorterJsonIndex("103-2.pdf", "결산자료입력내역"),
        new PdfSorterJsonIndex("103-3.pdf", "고정자산관리대장")
    );

    pdfSorterIndexList.forEach(jsonObj -> {
      try {
        File f = getFile("/pdfsorter/test/" + jsonObj.filename);
        List<String> lines = pdfToText.linesFromPdf(f);
        assertThat(lines.contains(jsonObj.title)).isTrue();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  @Test
  public void simplePdfToTextPrintTest() throws IOException {
    //PdfToText pdfToText = new SimplePdfBoxPdfToText();
    PdfToText pdfToText = new CopyStrtgyPdfToText();

    List<File> files = getFiles("/pdfsorter/test2");
    files.forEach(file -> {
      List<String> lines = null;
      System.err.printf("=== Parse %s ===%n", file);
      try {
        lines = pdfToText.linesFromPdf(file);
      } catch (IOException e) {
        e.printStackTrace();
      }
      System.out.println(lines);
    });
  }

  private File getFile(String path) throws FileNotFoundException {
    return ResourceUtils.getFile(Objects.requireNonNull(this.getClass().getResource(path)));
  }

  private List<File> getFiles(String path) throws FileNotFoundException {
    File dir = getFile(path);
    return Arrays.asList(Objects.requireNonNull(dir.listFiles()));
  }
}
