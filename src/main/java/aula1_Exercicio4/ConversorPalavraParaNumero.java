package aula1_Exercicio4;

import java.util.Map;

public class ConversorPalavraParaNumero {

	private final Map<String, Integer > myMap;
	
	public ConversorPalavraParaNumero(Map<String, Integer> map)
	{
		this.myMap=map;
	}
	
	public String converter_para_String(String paraConverter)
	{
		String convertida;
		
		String [] Separada = SeparaString(paraConverter);
		
		convertida = TrocarLetrasPorNumeros(Separada);
		
		return convertida;
	}

	public String converter_para_Numero(String paraConverter)
	{
		String [] Separada = SeparaString(converter_para_String(paraConverter));
		
		int[] Somar = new int[Separada.length];
		int numero_somas=0;
		int tmp1 = -1, tmp2, resultado = 0;
		
		for(int i=0;i<Separada.length;i++)
		{
			try{
				
				if(tmp1==-1){
				tmp1 = Integer.parseInt(Separada[i]);}
				
				tmp2 = Integer.parseInt(Separada[i+1]);
			
				
				if (tmp1<tmp2)
				{
					tmp1 = tmp1*tmp2;
					
				}else
				{ 
					Somar [numero_somas] = tmp1;
					numero_somas++;
					tmp1=-1;
				}
				}catch(Exception e)
					{
						if((i+1)>=Separada.length)
						{
							Somar [numero_somas] = tmp1;
							numero_somas++;
							tmp1=-1;
						}
						continue;
					}
			
		}
		
		for(int i=0;i<numero_somas;i++){
			resultado += Somar[i];
			//System.out.println(resultado);
		}
		
		
		return  Integer.toString(resultado) ;
	}
	
	

	private String TrocarLetrasPorNumeros(String [] Separada) {
		
		String convertida = "";
		
		for(int i=0; i<Separada.length;i++)
		{
			//System.out.println(myMap.get("hundred"));
			
			if(myMap.containsKey(Separada[i])){
				
				convertida += myMap.get(Separada[i]);}
			else
			{
				convertida += Separada[i];
			}
			
			convertida += " ";
			
		}
		
		return convertida;
	}

	private String[] SeparaString(String paraConverter) {
		
		paraConverter = paraConverter.replaceAll("-", " ");
		String [] Separada = paraConverter.split(" ");
		
		return Separada;
	}
	
	
}
