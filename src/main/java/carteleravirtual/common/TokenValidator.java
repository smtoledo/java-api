package carteleravirtual.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import carteleravirtual.dao.UsuarioDAO;
import carteleravirtual.excepcion.TokenInvalidoException;
import carteleravirtual.model.Usuario;

@Component
public class TokenValidator {

	@Autowired
	UsuarioDAO usuarioDao;
	
    public Boolean validarToken(String token) throws TokenInvalidoException {
        if(token.endsWith("123456")){          
            String idUsuario = token.substring(0, token.length() - 6);            
            Usuario usuario = usuarioDao.recuperarPorId(Integer.parseInt(idUsuario));
            if (usuario!=null) 
            	return true;
            else 
            	return false;
        }else {
        	throw new TokenInvalidoException();
        }        
    }  
    
    public int parseIdUsuario(String token) {
    	return (token.endsWith("123456")?Integer.parseInt(token.substring(0, token.length() - 6)):-1);
    }
}
