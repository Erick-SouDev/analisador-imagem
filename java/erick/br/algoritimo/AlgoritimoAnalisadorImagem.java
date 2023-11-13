package erick.br.algoritimo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.PdfBoxUtilities;

public class AlgoritimoAnalisadorImagem {

	private static String CAMINHO_IMAGEM = "C:/Projetos/analisador-imagem-console/analisador-imagem/src/main/resources/ap.pdf";
	private static String PASTA_TREINAMENTO = "C:\\Program Files\\Tesseract-OCR\\tessdata";

	public static void main(String[] args) throws IOException {

		try {
			Tesseract tesseract = new Tesseract();
			/* define o caminho onde a imagem vai ser treinada */
			tesseract.setDatapath(PASTA_TREINAMENTO);

			/* define a linguagem */
			tesseract.setLanguage("por");

			File file = new File(CAMINHO_IMAGEM);

			file = PdfBoxUtilities.convertPdf2Tiff(file);

			String imagemAnalisada = tesseract.doOCR(file);

			System.out.println(imagemAnalisada.toString());

		} catch (TesseractException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
