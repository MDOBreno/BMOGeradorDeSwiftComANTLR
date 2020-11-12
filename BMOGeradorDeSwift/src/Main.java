import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	
	private Entity preprocessEntity(String entrada) {
		//TODO: Implementar metodo 
		return new Entity("nome", new String[1][1]);
	}

	public static void main(String[] args) throws IOException {
		Scanner ler = new Scanner(System.in);
		int i, n;
		
		String fname = "Tabuada.txt";
		String WORKSPACE_PATH = "//Volumes//Macintosh SATA//ProgramasBMO//LPOO - Java//BMOGeradorDeSwift//BMOGeradorDeSwift//src//generated";
		File file= new File (WORKSPACE_PATH, fname);
		/*FileWriter arq;
		if (file.exists()){
			arq = new FileWriter(file,true);//if file exists append to file. Works fine.
		} else{
			arq = new FileWriter(file);// If file does not exist. Create it. This throws a FileNotFoundException. Why? 
		}*/
		
		FileWriter arq = new FileWriter(file);
		
		PrintWriter gravarArq = new PrintWriter(arq);

		n = 9;
		gravarArq.printf("+--Resultado--+%n");
		for (i=1; i<=10; i++) {
		  gravarArq.printf("| %2d X %d = %2d |%n", i, n, (i*n));
		}
		gravarArq.printf("+-------------+%n");
		
		arq.close();
		
		System.out.printf("\nTabuada do %d foi gravada com sucesso", n);
	}
	
	private void generateEntity(Entity entidade) {
		//TODO: Implementar metodo 
	}

	private void generateRepository(Entity entidade) {
		//TODO: Implementar metodo 
	}

} 