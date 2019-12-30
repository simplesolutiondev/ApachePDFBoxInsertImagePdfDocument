package dev.simplesolution;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class InsertCenterImagePdfDocument {
	public static void main(String... args) {
		try(PDDocument document = new PDDocument()) {
			PDPage page = new PDPage();
			document.addPage(page);
			
			PDPageContentStream pageContentStream = new PDPageContentStream(document, page);
			PDRectangle mediaBox = page.getMediaBox();
			PDImageXObject imageXObject = PDImageXObject.createFromFile("D:\\SimpleSolution\\simple_solution.png", document);
			float startX = (mediaBox.getWidth() - imageXObject.getWidth()) / 2;
            float startY = (mediaBox.getHeight() - imageXObject.getHeight()) / 2;
            pageContentStream.drawImage(imageXObject, startX, startY);
            pageContentStream.close();
			
			document.save("D:\\SimpleSolution\\CenterImageDocument.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
