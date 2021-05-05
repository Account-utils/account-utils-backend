package com.mklee.accountutils.PdfSorter.PdfToText;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimplePdfBoxPdfToText implements PdfToText{
  public List<String> linesFromPdf(File f) throws IOException {
    PDDocument doc = PDDocument.load(f);
    PDFTextStripper textStripper = new PDFTextStripper();

    StringWriter textWriter = new StringWriter();
    textStripper.writeText(doc, textWriter);
    doc.close();

    String text = textWriter.toString();

    return Arrays.stream(text.split("\n"))
        .map(line -> line.replaceAll("[ ,\t]+", "")).collect(Collectors.toList());
  }
}
