package erick.br.algoritimo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class AlgoritimoAnalisadorImagem {

	private static String CAMINHO_IMAGEM = "C:/Projetos/analisador-imagem-console/analisador-imagem/src/main/resources/imagem.jpg";
	private static String PASTA_TREINAMENTO = "C:\\Program Files\\Tesseract-OCR\\tessdata";

	public static void main(String[] args) throws IOException {

		try {
			Tesseract tesseract = new Tesseract();
			/* define o caminho onde a imagem vai ser treinada */
			tesseract.setDatapath(PASTA_TREINAMENTO);

			/* define a linguagem */
			tesseract.setLanguage("por");

			File file = new File(CAMINHO_IMAGEM);

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
