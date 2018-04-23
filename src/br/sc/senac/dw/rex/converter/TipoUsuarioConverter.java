package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.NivelAcessoDAO;
import br.sc.senac.dw.rex.db.model.entity.NivelAcesso;

@FacesConverter(value = "tipoUsuarioConverter")
public class TipoUsuarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
			NivelAcessoDAO dao = new NivelAcessoDAO();
		List<NivelAcesso> lista = dao.listarTodos();
		
			for(NivelAcesso objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (NivelAcesso)objeto;
				}
			}
		}
		return new NivelAcesso();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
