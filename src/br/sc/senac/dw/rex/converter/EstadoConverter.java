package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.EstadoDAO;
import br.sc.senac.dw.rex.db.model.entity.Estado;

@FacesConverter(value = "estadoConverter")
public class EstadoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
		EstadoDAO dao = new EstadoDAO();
		List<Estado> lista = dao.listarTodos();
		
			for(Estado objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (Estado)objeto;
				}
			}
		}
		return new Estado();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
