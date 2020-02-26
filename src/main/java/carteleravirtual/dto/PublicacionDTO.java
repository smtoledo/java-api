package carteleravirtual.dto;

import java.util.Date;

public class PublicacionDTO {

	private int id;
	private String titulo;
	private String contenido;
	private Date ultimaModificacion;
	private Date alta;
	private UsuarioDTO autor;
	private CarteleraDTO cartelera;
	
	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	public UsuarioDTO getAutor() {
		return autor;
	}

	public void setAutor(UsuarioDTO autor) {
		this.autor = autor;
	}

	public CarteleraDTO getCartelera() {
		return cartelera;
	}

	public void setCartelera(CarteleraDTO cartelera) {
		this.cartelera = cartelera;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}
	
}
