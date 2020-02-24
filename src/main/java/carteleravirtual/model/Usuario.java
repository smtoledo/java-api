package carteleravirtual.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import carteleravirtual.common.Perfil;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="usuario_id")
	private int id;	
	
	private String username;
	private String password;	
	private String nombre;
	private String apellido;
	private String email;	
	private int dni;	
	@Column(name="cuenta_activa")
	private int cuentaActiva=1;	
	@Column(name="notif_habilitadas")
	private int notificacionesHabilitadas=0;	
	@Column(name="notif_alt_habilitada")
	private int notificacionAlternativaHabilitada=0;
	@Column(name="notif_alt_mail")
	private String mailNotificacionAlternativa="";
	
	private Perfil perfil;
	
	@ManyToMany
	@JoinTable(name="alumno_carteleras",
	joinColumns=@JoinColumn(name="usuario_id",
			referencedColumnName="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="cartelera_id",
			referencedColumnName="cartelera_id")
	)
	private Set<CarteleraVirtual> cartelerasAlumno;
	
	@ManyToMany
	@JoinTable(name = "docente_carteleras",
	joinColumns = {@JoinColumn(name = "usuario_id", 
			referencedColumnName="usuario_id")},
	inverseJoinColumns = @JoinColumn(name = "cartelera_id", 
			referencedColumnName="cartelera_id")
	)
	private Set<CarteleraVirtual> cartelerasDocente;
	
	public Usuario() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getCuentaActiva() {
		return cuentaActiva;
	}

	public void setCuentaActiva(int cuentaActiva) {
		this.cuentaActiva = cuentaActiva;
	}

	public int getNotificacionesHabilitadas() {
		return notificacionesHabilitadas;
	}

	public void setNotificacionesHabilitadas(int notificacionesHabilitadas) {
		this.notificacionesHabilitadas = notificacionesHabilitadas;
	}

	public int getNotificacionAlternativaHabilitada() {
		return notificacionAlternativaHabilitada;
	}

	public void setNotificacionAlternativaHabilitada(int notificacionAlternativaHabilitada) {
		this.notificacionAlternativaHabilitada = notificacionAlternativaHabilitada;
	}

	public String getMailNotificacionAlternativa() {
		return mailNotificacionAlternativa;
	}

	public void setMailNotificacionAlternativa(String mailNotificacionAlternativa) {
		this.mailNotificacionAlternativa = mailNotificacionAlternativa;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Set<CarteleraVirtual> getCartelerasAlumno() {
		return cartelerasAlumno;
	}

	public void setCartelerasAlumno(Set<CarteleraVirtual> cartelerasAlumno) {
		this.cartelerasAlumno = cartelerasAlumno;
	}

	public Set<CarteleraVirtual> getCartelerasDocente() {
		return cartelerasDocente;
	}

	public void setCartelerasDocente(Set<CarteleraVirtual> cartelerasDocente) {
		this.cartelerasDocente = cartelerasDocente;
	}

	@Override
	public String toString() {
		return "usuario "+this.perfil+" { "+"nombre: "+this.nombre+", apellido: "+this.apellido+
				", email: "+this.email+", dni: "+this.dni+" }";		
	}
}
