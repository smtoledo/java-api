package carteleravirtual.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comentario_id")
	private int id;
	
	private String contenido;
	
	@CreationTimestamp
	private Date alta;
	private int habilitado=1;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Usuario autor;
	
	@ManyToOne(optional = false)
	@JoinColumn(name="publicacion_id")
	private Publicacion publicacion;
	
	public Comentario() {}
	
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
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario user) {
		this.autor = user;
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}
	public int getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(int habilitado) {
		this.habilitado = habilitado;
	}
	public Publicacion getPublicacion() {
		return publicacion;
	}
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	@Override
	public String toString() {
		return "comentario de "+this.autor.getUsername()+" { contenido: "+this.contenido+" } fecha: "+this.alta;
	}
}
