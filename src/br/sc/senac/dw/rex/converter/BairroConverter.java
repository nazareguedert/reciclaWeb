package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.BairroDAO;
import br.sc.senac.dw.rex.db.model.entity.Bairro;

@FacesConverter(value = "bairroConverter")
public class BairroConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {

		if (string != null) {
			BairroDAO dao = new BairroDAO();
			List<Bairro> lista = dao.listarTodos();

			for (Bairro objeto : lista) {
				if (objeto.toString().equalsIgnoreCase(string)) {
					return (Bairro) objeto;
				}
			}
		}
		return new Bairro();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {

		if (objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
