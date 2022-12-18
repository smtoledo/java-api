package carteleravirtual.model;

import carteleravirtual.common.Perfil;

public class Credentials {

    private String token;
    private int exp;
    private String username;
    private Perfil perfil;
    private Integer[] preferidas;
    private Integer[] carteleras;
    
    public Credentials() {
    }

    public Credentials(String token, int exp, String username, Perfil perfil, 
        Integer[] preferidas, Integer[] carteleras) {
        this.token = token;
        this.exp = exp;
        this.username = username;
        this.perfil = perfil;
        this.carteleras = carteleras;
        this.preferidas = preferidas;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
    }

    public Integer[] getPreferidas() {
        return preferidas;
    }

    public void setPreferidas(Integer[] preferidas) {
        this.preferidas = preferidas;
    }

    public Integer[] getCarteleras() {
        return carteleras;
    }

    public void setCarteleras(Integer[] carteleras) {
        this.carteleras = carteleras;
    }        
}
