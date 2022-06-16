package services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Espiao {

	/**
	 * Insere uma linha no arquivo log.txt
	 * @param append: o conteúdo que será inserido no arquivo
	 */
	public static void writeln(String append){
		try {																	
			FileWriter fw = new FileWriter("log.txt",true);
			PrintWriter p = new PrintWriter(fw);
			p.println(append);
			p.close();
		} 
		catch (IOException erro) {}
	}
}
