package dev.simplesolution;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

public class InsertImagePdfDocument {
	
	public static void main(String... args) {
		try(PDDocument document = new PDDocument()) {
			PDPage page = new PDPage();
			document.addPage(page);
			
			PDPageContentStream pageContentStream = new PDPageContentStream(document, page);
			PDImageXObject imageXObject = PDImageXObject.createFromFile("D:\\SimpleSolution\\simple_solution.png", document);
			pageContentStream.drawImage(imageXObject, 100, 400);
            pageContentStream.close();
			
			document.save("D:\\SimpleSolution\\ImageDocument.pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
