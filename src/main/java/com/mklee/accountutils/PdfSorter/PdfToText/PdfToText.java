package com.mklee.accountutils.PdfSorter.PdfToText;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface PdfToText {
  List<String> linesFromPdf(File f) throws IOException;
}
