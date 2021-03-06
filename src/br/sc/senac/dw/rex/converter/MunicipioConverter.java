package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.MunicipioDAO;
import br.sc.senac.dw.rex.db.model.entity.Municipio;

@FacesConverter(value = "municipioConverter")
public class MunicipioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
		MunicipioDAO dao = new MunicipioDAO();
		List<Municipio> lista = dao.listarTodos();
		
			for(Municipio objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (Municipio)objeto;
				}
			}
		}
		return new Municipio();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
