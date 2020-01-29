package carteleravirtual.common;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PerfilConverter implements AttributeConverter<Perfil, String> {
 
    @Override
    public String convertToDatabaseColumn(Perfil perfil) {
        return perfil.getNombre();
    }
    
	@Override
	public Perfil convertToEntityAttribute(String nombre) {
		return Perfil.fromNombre(nombre);
	}
}