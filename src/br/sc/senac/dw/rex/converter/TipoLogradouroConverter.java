package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.TipoLogradouroDAO;
import br.sc.senac.dw.rex.db.model.entity.TipoLogradouro;

@FacesConverter(value = "tipoLogradouroConverter")
public class TipoLogradouroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
			TipoLogradouroDAO dao = new TipoLogradouroDAO();
		List<TipoLogradouro> lista = dao.listarTodos();
		
			for(TipoLogradouro objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (TipoLogradouro)objeto;
				}
			}
		}
		return new TipoLogradouro();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
