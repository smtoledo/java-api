package carteleravirtual.dto;

import java.util.Date;

public class ComentarioDTO {

	private int id;
	private String contenido;
	private int habilitado;
	private Date alta;
	private UsuarioDTO autor;
	private PublicacionDTO publicacion;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public int getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
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
	public PublicacionDTO getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(PublicacionDTO publicacion) {
		this.publicacion = publicacion;
	}
		
}
