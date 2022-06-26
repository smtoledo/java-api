package carteleravirtual.dto;

import java.util.Date;

public class CarteleraDTO {

	private int id;
	private String titulo;
	private String descripcion;
	private String tipoCartelera;
	private Date alta;
	private UsuarioDTO autor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTipoCartelera() {
		return tipoCartelera;
	}
	public void setTipoCartelera(String tipoCartelera) {
		this.tipoCartelera = tipoCartelera;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public UsuarioDTO getAutor() {
		return autor;
	}
	public void setAutor(UsuarioDTO autor) {
		this.autor = autor;
	}
}
