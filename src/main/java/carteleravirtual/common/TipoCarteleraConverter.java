package carteleravirtual.common;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TipoCarteleraConverter implements AttributeConverter<TipoCartelera, String> {
 
    @Override
    public String convertToDatabaseColumn(TipoCartelera perfil) {
        return perfil.getNombre();
    }
    
	@Override
	public TipoCartelera convertToEntityAttribute(String nombre) {
		return TipoCartelera.fromNombre(nombre);
	}
}