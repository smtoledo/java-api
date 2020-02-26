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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import carteleravirtual.common.TipoCartelera;

@Entity
@Table(name = "cartelera")
public class CarteleraVirtual implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartelera_id")
	private int id;

	private String titulo;
	
	private String descripcion;

	@Column(name = "tipo")
	private TipoCartelera tipoCartelera;

	@OneToOne(optional=true)
	private Asignatura asignatura;

	@CreationTimestamp
	private Date alta;
	
	@OneToOne(cascade = CascadeType.MERGE)
	private Usuario autor;
	
	@Column(name="ultima_modificacion")
	@UpdateTimestamp
	private Date ultimaModificacion;
	
	@OneToMany(mappedBy = "cartelera", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<Publicacion> publicaciones;

	@ManyToMany(mappedBy = "cartelerasAlumno")
	private Set<Usuario> interesados;

	@ManyToMany(mappedBy = "cartelerasDocente")
	private Set<Usuario> docentes;
	
	private int habilitada = 1;

	public CarteleraVirtual(){}

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

	public void setDescripcion(String contenido) {
		this.descripcion = contenido;
	}

	public TipoCartelera getTipoCartelera() {
		return tipoCartelera;
	}

	public void setTipoCartelera(TipoCartelera tipoCartelera) {
		this.tipoCartelera = tipoCartelera;
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}

	public Usuario getAutor() {
		return autor;
	}

	public void setAutor(Usuario autor) {
		this.autor = autor;
	}

	public Set<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(Set<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}
	
	public void addPublicacion(Publicacion publicacion) {
		this.publicaciones.add(publicacion);
	}

	public void removePublicacion(Publicacion publicacion) {
		this.publicaciones.remove(publicacion);
	}
	
	public Set<Usuario> getInteresados() {
		return interesados;
	}

	public void setInteresados(Set<Usuario> interesados) {
		this.interesados = interesados;
	}
	
	public void addInteresado(Usuario usuario) {
		this.interesados.add(usuario);
	}
	
	public void removeInteresado(Usuario usuario) {
		this.interesados.remove(usuario);
	}

	public Set<Usuario> getDocentes() {
		return docentes;
	}

	public void setDocentes(Set<Usuario> docentes) {
		this.docentes = docentes;
	}

	public int getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(int habilitada) {
		this.habilitada = habilitada;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Date getUltimaModificacion() {
		return ultimaModificacion;
	}

	public void setUltimaModificacion(Date ultimaModificacion) {
		this.ultimaModificacion = ultimaModificacion;
	}

	@Override
	public String toString() {
		return "cartelera "+this.tipoCartelera+" { titulo: "+this.titulo
		+", publicaciones: "+this.publicaciones.size()+", alta: "+this.alta+" }";
	}
}
