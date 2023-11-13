package erick.br.algoritimo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class AlgoritimoAnalisadorImagem {
	public static void main(String[] args) throws IOException {

		try {
			Tesseract tesseract = new Tesseract();
			tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");
			tesseract.setLanguage("por");
			File file = new File(
					"C:/Projetos/analisador-imagem-console/analisador-imagem/src/main/resources/imagem.jpg");

			BufferedImage bufferedImage = ImageIO.read(file);
			
			
			String imagemAnalisada = tesseract.doOCR(bufferedImage);

			System.out.println(imagemAnalisada.toString());

		} catch (TesseractException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
