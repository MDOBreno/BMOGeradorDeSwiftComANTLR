
public class Entity {
	public String[][] atributes;
	public String name;
	
	public Entity(String nome, String[][] atributos) {
		// TODO Auto-generated constructor stub
		this.name = nome;
		this.atributes = new String[atributos.length][2];
		for (int i = 0; i < atributos.length; i++) {
			this.atributes[i][0] = atributos[i][0];
			this.atributes[i][1] = atributos[i][1];
		}
	}
	
}
