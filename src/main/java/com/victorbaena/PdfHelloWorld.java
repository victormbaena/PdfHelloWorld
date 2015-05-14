package main.java.com.victorbaena;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Created by VictorManuel on 14/05/2015.
 */
public class PdfHelloWorld {

    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
            document.open();
            document.add(new Paragraph("A Hello World PDF document."));
            //Set attributes here
            document.addAuthor("Victor Baena");
            document.addCreationDate();
            document.addCreator("HowToDoInJava.com");
            document.addTitle("Set Attribute Example");
            document.addSubject("An example to show how attributes can be added to pdf files.");

            //Add new Paragraph
            document.add(new Paragraph("Image Example"));
            //Add Image  D:\My Documents\Workspace\Intellij\PdfHelloWorld\src\main\resources\AddImageExample.jpg
            Image image = Image.getInstance("src\\main\\resources\\AddImageExample.jpg");
            //Fixed Positioning
            image.setAbsolutePosition(100f, 550f);
            //Scale to new height and new width of image
            image.scaleAbsolute(200, 200);
            //Add to document
            document.add(image);

            document.close();
            writer.close();
        } catch (DocumentException | FileNotFoundException | MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

