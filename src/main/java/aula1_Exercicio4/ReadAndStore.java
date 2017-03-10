package aula1_Exercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ReadAndStore {
        public static Scanner sc = new Scanner (System.in);
	private String Caminho;
	private final List<String> ReadedFile;

	public ReadAndStore(String Caminho) {
		this.Caminho = Caminho;
		ReadedFile = new ArrayList<>();
		Ler();
	}

	// Lê uma linha do ficheiro
	private void Ler()
	{
		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(Caminho);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(Caminho));

			while ((sCurrentLine = br.readLine()) != null) {
				ReadedFile.add(sCurrentLine);
			}

		} catch ( IOException e) {
                        System.out.println("File Not Found. Where is The file? ");
                        Caminho = sc.nextLine();
                        Ler();
			

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {
                                
                                System.err.println("Erro ao Fechar o Ficheiro de Leitura");
                                System.exit(0);
				//ex.printStackTrace();

			}

			}
	}
	
	public Map<String, Integer > ReadToMap()
	{
		Map <String, Integer > myMap  = new HashMap <>();
		
			for(int i =0; i<ReadedFile.size(); i++)
			{
				String tmp []= ReadedFile.get(i).split(" - ");
				myMap.put(tmp[1], Integer.parseInt(tmp[0]));
			}
		
		return myMap;
	}

	
}


