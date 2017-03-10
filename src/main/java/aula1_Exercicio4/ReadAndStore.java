package aula1_Exercicio4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadAndStore {

	private final String Caminho;
	private List<String> ReadedFile;

	public ReadAndStore(String Caminho) {
		this.Caminho = Caminho;
		ReadedFile = new ArrayList<String>();
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

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

			}
	}
	
	public Map<String, Integer > ReadToMap()
	{
		Map <String, Integer > myMap  = new HashMap <String, Integer>();
		
			for(int i =0; i<ReadedFile.size(); i++)
			{
				String tmp []= ReadedFile.get(i).split(" - ");
				myMap.put(tmp[1], Integer.parseInt(tmp[0]));
			}
		
		return myMap;
	}

	
}


