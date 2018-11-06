package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import entities.Funcionario;

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
			List<Funcionario> lista = new ArrayList<>();
			
			while(linha != null) {
				String[] campos = linha.split(",");
				lista.add(new Funcionario(campos[0],campos[1],Double.parseDouble(campos[2])));
				
				linha = br.readLine();
			}
			
			Stream<Funcionario> st1 = lista.stream(); 
			System.out.println(Arrays.toString(st1.toArray()));
			
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		

	}

}
