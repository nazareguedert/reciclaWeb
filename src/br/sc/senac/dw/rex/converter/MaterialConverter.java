package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.MaterialDAO;
import br.sc.senac.dw.rex.db.model.entity.Material;

@FacesConverter(value = "materialConverter")
public class MaterialConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
			MaterialDAO dao = new MaterialDAO();
		List<Material> lista = dao.listarTodos();
		
			for(Material objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (Material)objeto;
				}
			}
		}
		return new Material();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
