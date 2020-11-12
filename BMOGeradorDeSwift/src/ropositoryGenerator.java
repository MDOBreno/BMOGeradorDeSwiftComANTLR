import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ropositoryGenerator {
	
	static void generate(Entity entidade) {

		// Copy Entity template
		Path fileFrom = Paths.get(Main.concatPath("templates//EntityRepository.swift")); 
		Path fileTo = Paths.get(Main.concatPath("generated", entidade.name, "Repository.swift")); 
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
		try {
			Files.write(fileTo, content.getBytes(charset));
		} catch (IOException e1) {
			// Erro ao escrever o conteudo
			e1.printStackTrace();
		}
		
		
		
	}
	
	
}
