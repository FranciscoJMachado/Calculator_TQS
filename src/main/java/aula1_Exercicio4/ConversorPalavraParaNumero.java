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
		
		String [] Separada = separaString(paraConverter);
		
		convertida = trocarLetrasPorNumeros(Separada);
		
		return convertida;
	}

	public String converter_para_Numero(String paraConverter)
	{
		String [] Separada;
            Separada = separaString(converter_para_String(paraConverter));
		
		int[] Somar = new int[Separada.length];
		int numero_somas=0;
		int tmp1 = -1, tmp2=0, resultado = 0;
		
		for(int i=0;i<Separada.length;i++)
		{
			try{
				
				if(tmp1==-1){
				tmp1 = Integer.parseInt(Separada[i]);}
				
                                try{
				tmp2 = Integer.parseInt(Separada[i+1]);
                                }catch(ArrayIndexOutOfBoundsException ss)
                                {
                                    System.out.println("Ultimo calculo");
                                }
				
				if (tmp1<tmp2)
				{
					tmp1 = tmp1*tmp2;
					
				}else
				{ 
					Somar [numero_somas] = tmp1;
					numero_somas++;
					tmp1=-1;
				}
				}catch(NumberFormatException e)
					{
						if((i+1)>=Separada.length)
						{
							Somar [numero_somas] = tmp1;
							numero_somas++;
							tmp1=-1;
						}
					}
			
		}
		
		for(int i=0;i<numero_somas;i++){
			resultado += Somar[i];
			//System.out.println(resultado);
		}
		
		
		return  Integer.toString(resultado) ;
	}
	
	

	private String trocarLetrasPorNumeros(String [] Separada) {
		
		String convertida = "";
		StringBuilder buf = new StringBuilder();
            for (String Separada1 : Separada) {
                //System.out.println(myMap.get("hundred"));
                if (myMap.containsKey(Separada1)) {
                    //convertida += myMap.get(Separada1);
                    buf.append(myMap.get(Separada1));
                } else {
                    buf.append(Separada1);
                }
                buf.append(" ");
                
             
                        }
		
		return  buf.toString();
	}

	private String[] separaString(String paraConverter) {
		
		paraConverter = paraConverter.replaceAll("-", " ");
		String [] Separada = paraConverter.split(" ");
		
		return Separada;
	}
	
	
}
