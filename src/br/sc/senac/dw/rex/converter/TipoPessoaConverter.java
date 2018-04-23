package br.sc.senac.dw.rex.converter;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.sc.senac.dw.rex.db.model.TipoPessoaDAO;
import br.sc.senac.dw.rex.db.model.entity.TipoPessoa;

@FacesConverter(value = "tipoPessoaConverter")
public class TipoPessoaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
		
		if(string != null) {
			TipoPessoaDAO dao = new TipoPessoaDAO();
		List<TipoPessoa> lista = dao.listarTodos();
		
			for(TipoPessoa objeto : lista) {
				if(objeto.toString().equalsIgnoreCase(string)) {
					return (TipoPessoa)objeto;
				}
			}
		}
		return new TipoPessoa();
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
		
		if(objeto != null) {
			return objeto.toString();
		}
		return "";
	}

}
