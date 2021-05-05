package com.mklee.accountutils.PdfSorter.PdfToText;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CopyStrtgyPdfToText implements PdfToText{
  @Override
  public List<String> linesFromPdf(File f) throws IOException {
    PDDocument pdDocument = PDDocument.load(f);
    pdDocument.save("temp_copy.pdf");
    pdDocument.close();

    pdDocument = PDDocument.load(new File("temp_copy.pdf"));
    PDFTextStripper textStripper = new PDFTextStripper();
    StringWriter textWriter = new StringWriter();
    textStripper.writeText(pdDocument, textWriter);
    pdDocument.close();

    String text = textWriter.toString();
    return Arrays.stream(text.split("\n"))
        .map(line -> line.replaceAll("[ ,\t]+", "")).collect(Collectors.toList());
  }
}
