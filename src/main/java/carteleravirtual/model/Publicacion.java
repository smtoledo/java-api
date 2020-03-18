package carteleravirtual.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "publicacion")
public class Publicacion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="publicacion_id")
	private int id;
	
	private String titulo;
	private String contenido;
	private byte[] imagen;
	private byte[] archivo;
	private String link;
	
	@CreationTimestamp
	private Date alta;
	
	@Column(name="ultima_modificacion")
	@UpdateTimestamp
	private Date ultimaModificacion;

	@OneToOne(cascade = CascadeType.MERGE)
	private Usuario autor;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="cartelera_id")
	private CarteleraVirtual cartelera;	
	
	@OneToMany(mappedBy="publicacion", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
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
	public void addComentario(Comentario c) {
		this.comentarios.add(c);
	}
	public void removeComentario(Comentario c) {
		this.comentarios.remove(c);
	}
	public Date getAlta() {
		return alta;
	}
	public void setAlta(Date alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return "publicacion '"+this.titulo+"' { cartelera: "+this.cartelera.getTitulo()
		+", contenido: "+this.contenido+", autor: "+this.autor.getUsername()+", ult.mod: "+this.ultimaModificacion+" }";
	}
}
