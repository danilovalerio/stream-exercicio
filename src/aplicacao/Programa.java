package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
			double salCriterio = 3000;
			String linha = br.readLine();
			List<Funcionario> lista = new ArrayList<>();
			
			while(linha != null) {
				String[] campos = linha.split(",");
				lista.add(new Funcionario(campos[0],campos[1],Double.parseDouble(campos[2])));
				
				linha = br.readLine();
			}
			
			//Exibe o conte�do do arquivo 
			Stream<Funcionario> st1 = lista.stream(); 
			System.out.println(Arrays.toString(st1.toArray()));
						
			//Mostrar em ordem alfab�tica e com sal�rio acima do crit�rio fornecido
			List<String> funcs = lista.stream()
					.filter(f -> f.getSalario() > salCriterio) //filtra sal�rio acima de salCriterio
					.map(f ->f.getNome() +" - "+ f.getEmail() + " - " + f.getSalario())//aplica lambda que d� um get nos dados
					.sorted((f1, f2) -> f1.toUpperCase().compareTo(f2.toUpperCase()))//ordena com um Comparator
					.collect(Collectors.toList());//converte novamente o Stream para uma lista
			
			funcs.forEach(System.out::println); //Exibe a lista usando como refer�ncia o m�todo println
			
			System.out.println("Soma dos sal�rio de quem come�a com a letra 'M':");
			double somaSal = lista.stream()
					.filter(f -> f.getNome().charAt(0) == 'M')//filtra pelos nomes que iniciam com a letra M
					.map(f -> f.getSalario()) //com a express�o lambda pega o salario de cada item
					.reduce(0.0, (x,y) -> x + y);  //encontra valores concatenados ou cumulativos
			System.out.println("Soma dos sal�rios: R$ "+ String.format("%.2f", somaSal) );
					
		} catch (Exception e) {
			System.out.println("Erro: "+e.getMessage());
		}
		
		

	}

}
