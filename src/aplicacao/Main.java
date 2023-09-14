package aplicacao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String gravacaoSaida;
		Double valor;
		Integer quantidade;

		File arquivo = new File("arquivos/arquivoEntrada.csv");
		File arquiSaida = new File("arquivos/relatorio.csv");
arquivo.createNewFile();
		System.out.println(arquivo.getAbsolutePath());
		System.out.println(arquiSaida.getAbsolutePath());
		System.out.println(arquivo.exists());

		// lendo arquivo e separando as informações,
		try (Scanner entrada = new Scanner(arquivo);
				BufferedWriter saida = new BufferedWriter(new FileWriter(arquiSaida))) {

			while (entrada.hasNextLine()) {

				String[] linha = entrada.nextLine().split(",");
				System.out.println(linha[0] + " " + linha[1] + " " + linha[2]);

				linha[0] = linha[0].replace("\"", "");
				linha[2] = linha[2].replace("\"", "");

				// convertendo para seus respectivos tipos.

				valor = Double.valueOf(linha[1]);
				quantidade = Integer.valueOf(linha[2]);
				valor *= quantidade;

				// Montando a String

				gravacaoSaida = linha[0] + "," + valor;

				// Gravando no arquivo

				saida.write(gravacaoSaida);
				saida.newLine();
				gravacaoSaida = null;

			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		System.out.println();
		System.out.println("fim arquivo entrada");
		System.out.println();
		System.out.println("");
		System.out.println();
		System.out.println("Arquivo saida");
		System.out.println();

		// exibindo o arquivo de saida.
		try (Scanner entrada = new Scanner(arquiSaida)) {
			while (entrada.hasNext()) {
				System.out.println(entrada.nextLine());

			}

		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2.getMessage());
		}

	}

}
