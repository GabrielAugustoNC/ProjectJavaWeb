package mdm.minibiblioteca.models;

public class Livro {
	
	private int id;
	private String autor;
	private String Titulo;
	
	
	public Livro(int id, String autor, String titulo) {
		this.id = id;
		this.autor = autor;
		Titulo = titulo;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
	}
	
	
	
	
	
	
	
	
	

}
