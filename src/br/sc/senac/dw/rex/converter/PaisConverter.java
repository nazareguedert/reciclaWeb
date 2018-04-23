package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.PaisDAO;
import br.sc.senac.dw.rex.db.model.entity.Pais;

@FacesConverter(value = "paisConverter")
public class PaisConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
		PaisDAO dao = new PaisDAO();
		List<Pais> lista = dao.listarTodos();
		
			for(Pais objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (Pais)objeto;
				}
			}
		}
		return new Pais();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
