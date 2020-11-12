import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class entityGenerator {
	
	static void generate(Entity entidade) {

		// Copy Entity template
		Path fileFrom = Paths.get(Main.concatPath("templates//Entity.swift")); 
		Path fileTo = Paths.get(Main.concatPath("generated", entidade.name, ".swift")); 
		try {
			Files.copy(fileFrom, fileTo, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Charset charset = StandardCharsets.UTF_8;

		String content = null;
		try {
			content = new String(Files.readAllBytes(fileTo), charset);
		} catch (IOException e2) {
			// Erro ao ler o conteudo
			e2.printStackTrace();
		}
		content = content.replaceAll("Entidade", entidade.name);
		content = content.replaceAll("entidade", entidade.name.toLowerCase());
		content = content.replaceAll("ENTIDADE", entidade.name.toUpperCase());
		content = content.replaceAll("varAtributosDaStruct", varAtributosDaStruct(entidade));
		content = content.replaceAll("atributosDaStruct", atributosDaStruct(entidade));
		content = content.replaceAll("atributosDaExtension", atributosDaExtension(entidade));
		content = content.replaceAll("contrutorNaExtension", contrutorNaExtension(entidade));
		try {
			Files.write(fileTo, content.getBytes(charset));
		} catch (IOException e1) {
			// Erro ao escrever o conteudo
			e1.printStackTrace();
		}
		
		
		
	}

	private static String varAtributosDaStruct(Entity entidade) {
		String atributesFromStruct = "";
		for (int i = 0; i < entidade.atributes.length; i++) {
			atributesFromStruct += "    var " + entidade.atributes[i][0] + ":" + entidade.atributes[i][1];  
			if (i<(entidade.atributes.length-1)) {
				atributesFromStruct += "\n";
			}
		}
		return atributesFromStruct;
	}
	
	private static String atributosDaStruct(Entity entidade) {
		String atributesFromStruct = "";
		for (int i = 0; i < entidade.atributes.length; i++) {
			atributesFromStruct += "            \"" + entidade.atributes[i][0] + "\":" + entidade.atributes[i][0];  
			if (i<(entidade.atributes.length-1)) {
				atributesFromStruct += ",";
			}
			atributesFromStruct += "\n";
		}
		return atributesFromStruct;
	}
	
	
	private static String atributosDaExtension(Entity entidade) {
		String atributesFromExtension = "";
		boolean isFirstExecution = true;
		for (int i = 0; i < entidade.atributes.length; i++) {
			if (!isFirstExecution) {
				atributesFromExtension += "        ";
			}
			atributesFromExtension += "let " + entidade.atributes[i][0] + " = dictionary[\"" + entidade.atributes[i][0] + "\"] as? " + entidade.atributes[i][1];  
			if (i<(entidade.atributes.length-1)) {
				atributesFromExtension += ",";
				atributesFromExtension += "\n";
			}
			isFirstExecution = false;
		}
		return atributesFromExtension;
	}
	
	
	private static String contrutorNaExtension(Entity entidade) {
		String atributesFromExtension = "";
		for (int i = 0; i < entidade.atributes.length; i++) {
			atributesFromExtension += entidade.atributes[i][0] + ":" + entidade.atributes[i][0];
			if (i<(entidade.atributes.length-1)) {
				atributesFromExtension += ", ";
			}
		}
		return atributesFromExtension;
	}
	
	
}
