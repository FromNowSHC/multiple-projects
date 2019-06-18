package com.research.file;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * 将html转为Pdf
 * 使用itextpdf的两个jar包；
 * 需要引入simsun.ttf字体处理中文；
 *
 * @author ....
 * @date 2018-06-18
 **/
public class HtmlToPdf {
    /**
     * 将html转化为pdf
     *
     * @param htmlString   html的字符串
     * @param outputStream 输出的文件路径
     */
    public static void htmlToPdf(String htmlString, OutputStream outputStream) throws Exception {
        Document document = null;
        try {
            document = new Document(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
            document.open();
            XMLWorkerHelper worker = XMLWorkerHelper.getInstance();
            InputStream inputStream = null;
            worker.parseXHtml(pdfWriter, document, new ByteArrayInputStream(htmlString.getBytes("UTF-8")), inputStream, Charset.forName("UTF-8"), new AsianFontProvider());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }


    public static void main(String[] args) {
        String htmlString = "<p style=\"color:red;font-size:12px;\">男|4 岁 (2015-09-03)|现居住北京|0年工作经验 </p>";
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream("E:\\tomcatLog\\test.pdf");
            htmlToPdf(htmlString, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
