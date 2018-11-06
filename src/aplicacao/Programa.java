package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Programa que l� os dados (nome, email e sal�rio) de funcion�rios 
 * a partir de um arquivo em formato .csv.
 * Em seguida, mostrar, em ordem alfab�tica, 
 * o email dos funcion�rios cujo sal�rio seja superior 
 * a um dado valor fornecido pelo usu�rio.
 * Mostrar tamb�m a soma dos sal�rios dos funcion�rios cujo 
 * nome come�a com a letra 'M'.
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
