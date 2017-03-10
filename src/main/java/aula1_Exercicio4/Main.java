package aula1_Exercicio4;

import java.util.*;

public class Main {

	public static Scanner sc =new Scanner (System.in);
	
	public static void main(String[] args) {
		
		 String Path_to_File = "numbers.txt";
		 ReadAndStore readandstore = new ReadAndStore(Path_to_File);
		 
		 ConversorPalavraParaNumero CPPN = new ConversorPalavraParaNumero(readandstore.ReadToMap());
	
		 String paraConverter="A list of numbers: eight million two hundred thousand five hundred twenty-four";
		 System.out.println(CPPN.converter_para_String(paraConverter)+"-> "+CPPN.converter_para_Numero(paraConverter));
	}

}
