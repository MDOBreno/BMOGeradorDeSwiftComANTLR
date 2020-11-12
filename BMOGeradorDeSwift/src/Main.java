import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
	

	
	static String WORKSPACE_PATH = "//Volumes//Macintosh SATA//ProgramasBMO//LPOO - Java//BMOGeradorDeSwift//BMOGeradorDeSwift//src";
	static String comand = "Evento{nome:String, data: String, local: String, descricao: String, imagem: String)";
	
	
	

	public static void main(String[] args) throws IOException {

		System.out.println("------- Swift 5 Code Generator -------");
		
		System.out.println("1) Pre processing input data");
		Entity entidade = preprocessEntity(comand);
		System.out.println("2) Generating Entity");
		entityGenerator.generate(entidade);
		System.out.println("3) Generating Repository");
		ropositoryGenerator.generate(entidade);
		
		
		System.out.println("Swift Entity and Repository successfully generated!");
	}
	
	private static Entity preprocessEntity(String entrada) {
		//TODO: Implementar metodo
		entrada = entrada.replace(" ", "");
		int indexOpen = entrada.indexOf("{");
		if (indexOpen != -1) {
			Entity entidade = new Entity(entrada.substring(0, indexOpen));
			entrada = entrada.substring(indexOpen+1, entrada.length()-1);
			String[] parts = entrada.split("\\,");
			String[][] atributos = new String[parts.length][2];
			if (parts.length>=2) {
				String[] atributo;
				for (int i = 0; i < parts.length; i++) {
					atributo = (parts[i]).split("\\:");
					atributos[i][0] = atributo[0];
					atributos[i][1] = atributo[1];
				}
				entidade.atributes = atributos;
				return entidade;
			}
		}
		
		//Não possui os criterios minimos
		String[][] stg = { {"",""}, {"",""}};
		return new Entity("Nome", stg);
	}

	static String concatPath(String second) {
		return (WORKSPACE_PATH + "//" + second);
	}

	static String concatPath(String second, String third, String fourth) {
		return (WORKSPACE_PATH + "//" + second + "//" + third + fourth);
	}
	

} 