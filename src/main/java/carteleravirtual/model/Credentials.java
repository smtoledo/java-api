package carteleravirtual.model;

import carteleravirtual.common.Perfil;

public class Credentials {

    private String token;
    private int exp;
    private String username;
    private Perfil role;
    
    public Credentials() {
    }

    public Credentials(String token, int exp, String username, Perfil role) {
        this.token = token;
        this.exp = exp;
        this.username = username;
        this.role = role;
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

	public Perfil getRole() {
		return role;
	}

	public void setRole(Perfil role) {
		this.role = role;
	}
    
}
