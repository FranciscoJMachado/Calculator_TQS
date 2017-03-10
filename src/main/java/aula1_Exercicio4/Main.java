package aula1_Exercicio4;

import java.util.*;

public class Main {

	private static final Scanner sc =new Scanner (System.in);
	
	public static void main(String[] args) {
		
		 String Path_to_File = "numbers.txt";
		 ReadAndStore readandstore = new ReadAndStore(Path_to_File);
		 
		 ConversorPalavraParaNumero CPPN = new ConversorPalavraParaNumero(readandstore.ReadToMap());
                 
                 System.out.println("Numero Pretendido");
                 String paraConverter= sc.nextLine();
                   
                 System.out.println("Pretende o resultado da Soma? (Y/N)");
                 String tmp = sc.nextLine();
                 
            switch (tmp) {
                case "N":
                case "No":
                    System.out.println(CPPN.converter_para_String(paraConverter)+"-> "+CPPN.converter_para_Numero(paraConverter));
                    break;
                case "Y":
                case "Yes":
                    System.out.println("Segundo Numero Pretendido");
                    String paraConverter2 = sc.nextLine();
                    //BUG: Troca do + pelo -
                    int resultado = Integer.parseInt(CPPN.converter_para_Numero(paraConverter)) + Integer.parseInt(CPPN.converter_para_Numero(paraConverter2));
                    System.out.println(CPPN.converter_para_Numero(paraConverter) +"+"+ CPPN.converter_para_Numero(paraConverter2) +"= "+resultado);
                    break;
                default:
                    System.err.println("Nenhuma resposta válida");
                    break;
            }
               
    
		
	}

}
