package carteleravirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="publicacion_id")
	private int id;
	
	private String titulo;
	private String contenido;
	private byte[] imagen;
	private byte[] archivo;
	private String link;
	@Column(name="ultima_modificacion")
	private Date ultimaModificacion;

	@ManyToOne(optional = false)
	@JoinColumn(name="usuario_id")
	private Usuario autor;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cartelera_id")
	private CarteleraVirtual cartelera;	
	
	@OneToMany(mappedBy="publicacion",cascade=CascadeType.ALL)
	private Set<Comentario> comentarios;
	
	public Publicacion() {}
	
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
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public CarteleraVirtual getCartelera() {
		return cartelera;
	}
	public void setCartelera(CarteleraVirtual cartelera) {
		this.cartelera = cartelera;
	}
	public Usuario getAutor() {
		return autor;
	}
	public void setAutor(Usuario autor) {
		this.autor = autor;
	}
	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}
	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}
	public Set<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	
	@Override
	public String toString() {
		return "publicacion '"+this.titulo+"' { cartelera: "+this.cartelera.getTitulo()
		+", contenido: "+this.contenido+", autor: "+this.autor.getUsername()+", ult.mod: "+this.ultimaModificacion+" }";
	}
}
