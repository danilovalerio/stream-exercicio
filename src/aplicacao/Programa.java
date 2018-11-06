package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Programa que lê os dados (nome, email e salário) de funcionários 
 * a partir de um arquivo em formato .csv.
 * Em seguida, mostrar, em ordem alfabética, 
 * o email dos funcionários cujo salário seja superior 
 * a um dado valor fornecido pelo usuário.
 * Mostrar também a soma dos salários dos funcionários cujo 
 * nome começa com a letra 'M'.
 */

public class Programa {

	public static void main(String[] args) {
		
		String path = "C:\\Users\\dsilva\\Documents\\funcionarios.csv";
		
		//efetua a leitura do arquivo
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String linha = br.readLine();
			
			while(linha != null) {
				System.out.println("teste");
				
				linha = br.readLine();
			}
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		

	}

}
