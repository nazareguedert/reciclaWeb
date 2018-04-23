package br.sc.senac.dw.rex.db.model.bo;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.sc.senac.dw.rex.db.model.entity.Doacao;
import br.sc.senac.dw.rex.db.model.entity.Telefone;
import br.sc.senac.dw.rex.db.model.entity.Usuario;

public class Validador implements Validator {
	//continuar métodos de validação
	private Boolean validarUsuario(String nomeusuario) {
		
		return true;
	}

	public Boolean validarData(Date date) {
		
		//método necessário?
		return true;
	}
	
	public Boolean validarCPF(String CPF) {
	    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
	        CPF.equals("22222222222") || CPF.equals("33333333333") ||
	        CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999") ||
	       (CPF.length() != 11))
	    {	
	       return(false);
	    }

	    char dig10, dig11;
	    int sm, i, r, num, peso;

	    try {
	      sm = 0;
	      peso = 10;
	      for (i=0; i<9; i++) {              
	        num = (int)(CPF.charAt(i) - 48); 
	        sm = sm + (num * peso);
	        peso = peso - 1;
	      }

	      r = 11 - (sm % 11);
	      if ((r == 10) || (r == 11))
	         dig10 = '0';
	      else dig10 = (char)(r + 48);
	   
	      sm = 0;
	      peso = 11;
	      for(i=0; i<10; i++) {
	        num = (int)(CPF.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso - 1;
	      }

	      r = 11 - (sm % 11);
	      if ((r == 10) || (r == 11))
	         dig11 = '0';
	      else dig11 = (char)(r + 48);

	      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
	         return(true);
	      }else{
	    	  return(false);
	      }
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
	}
	

	public Boolean validarEmail(String email) {
			Integer indiceEmail;
		try{
			indiceEmail = email.indexOf('@');
			if (indiceEmail > 0)
				return(true);
			else
				return(false); 
		}catch(Exception e) {
			return false;
		}
	   
	}
	public Boolean validarParagrafo(String sl) {
		
		return true;
	}
	
	public Boolean isConsistente(Doacao doacao) {
		Boolean isConsistente = true;
		
		try {
			if(doacao.getDoador()==null ||
					doacao.getDoador().getPessoa()==null ||
					doacao.getDoador().getPessoa().getTipoPessoa()==null ||
					doacao.getDoador().getNivelAcesso() == null ||
//					doacao.getDoador().getPessoa().getEndereco()==null ||
//					doacao.getDoador().getPessoa().getEndereco().getLogradouro()==null ||
//					doacao.getDoador().getPessoa().getEndereco().getBairro() ==null ||
//					doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio() == null ||
//					doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getEstado() == null ||
//					doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getPais() == null ||
					doacao.getEndereco()==null ||
					doacao.getEndereco().getLogradouro()==null ||
					doacao.getEndereco().getBairro()== null ||
					doacao.getEndereco().getBairro().getMunicipio() == null ||
					doacao.getEndereco().getBairro().getMunicipio().getEstado() == null ||
					doacao.getEndereco().getBairro().getMunicipio().getEstado().getPais() == null ||
					doacao.getEndereco().getLogradouro().getTipoLogradouro() == null ||
					doacao.getMaterial() == null ||
					doacao.getMaterial().getUnidadeMedida() == null ||
					doacao.getStatusDoacao() == null
					) {
				System.out.println("Algum bean vazio");
				return false;
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return false;
		}
		
//		if(!this.validarCPF(doacao.getDoador().getPessoa().getDoc())) {
//			isConsistente = false;
//			System.out.println("Documento invalido");
//		}
		
//		if(!this.validarEmail(doacao.getDoador().getPessoa().getEmail())) {
//			isConsistente = false;
//			System.out.println("Email invalido");
//		}
		
		if(!this.validarUsuario(doacao.getDoador().getUsuario())) {
			isConsistente = false;
			System.out.println("Usuario invalido");
		}
		
		if(!this.validar(doacao.getDoador().getPessoa().getNome(),
				doacao.getDoador().getPessoa().getNomeAuxiliar(),
//				doacao.getDoador().getPessoa().getEndereco().getCep(),
//				doacao.getDoador().getPessoa().getEndereco().getComplemento(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getNome(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getNome(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getNome(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getPais().getNome(),
				doacao.getDoador().getNivelAcesso().getNome(),
				doacao.getDoador().getPessoa().getTipoPessoa().getNome()		
				)) {
			System.out.println("Algum campo vazio");
			isConsistente = false;
		}
		
//		if(!this.validar(doacao.getDoador().getPessoa().getEndereco().getCep(),
//				doacao.getDoador().getPessoa().getEndereco().getComplemento(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getNome(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getNome(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getNome(),
//				doacao.getDoador().getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getPais().getNome())) {
//			System.out.println("Algum campo vazio em endereco de doacao");
//			isConsistente = false;
//		}
		
		return isConsistente;
	}
	
	public Boolean isConsistente(Usuario usuario) { 
		// checar se cada bean não é nulo
		Boolean isConsistente = true;
		try { 
			if(usuario==null ||
				usuario.getPessoa()==(null)||
//				usuario.getPessoa().getEndereco()==(null)||
//				usuario.getPessoa().getEndereco().getBairro()==(null)||
//				usuario.getPessoa().getEndereco().getBairro().getMunicipio()==(null)||
//				usuario.getPessoa().getEndereco().getBairro().getMunicipio().getEstado()==(null)||
//				usuario.getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getPais()==(null)||
//				usuario.getPessoa().getEndereco().getLogradouro()==(null)||
//				usuario.getPessoa().getEndereco().getLogradouro().getTipoLogradouro()==(null)||
				usuario.getPessoa().getTipoPessoa()==(null)||
				usuario.getNivelAcesso()==(null)){
			System.out.println("Algum bean vazio");
			return false;
			}
		}catch(Exception e) {
			System.out.println("Erro: " + e.getMessage());
			return false;
		}
		
		if(!this.validarCPF(usuario.getPessoa().getDoc())) {
			isConsistente = false;
			System.out.println("Documento invalido");
		}
		
//		if(!this.validarEmail(usuario.getPessoa().getEmail())) {
//			isConsistente = false;
//			System.out.println("Email invalido");
//		}
		
//		if(!this.validarUsuario(usuario.getUsuario())) {
//			isConsistente = false;
//			System.out.println("Usuario invalido");
//		}
		
		// ids necessitam de validação? pode ser que os objetos necessitem ser verificados juntos ao banco através da id
		if(!this.validar(usuario.getPessoa().getNome(),
				usuario.getPessoa().getNomeAuxiliar(),
//				usuario.getPessoa().getEndereco().getCep(),
//				usuario.getPessoa().getEndereco().getComplemento(),
//				usuario.getPessoa().getEndereco().getBairro().getNome(),
//				usuario.getPessoa().getEndereco().getBairro().getMunicipio().getNome(),
//				usuario.getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getNome(),
//				usuario.getPessoa().getEndereco().getBairro().getMunicipio().getEstado().getPais().getNome(),
				usuario.getNivelAcesso().getNome(),
				usuario.getPessoa().getTipoPessoa().getNome()		
				)) {
			System.out.println("Algum campo vazio");
			isConsistente = false;
		}
		
		if(!this.validar(usuario.getNivelAcesso().getNivel()
//				,usuario.getPessoa().getEndereco().getNumero()
				)) {
			System.out.println("Nivel acesso invalido");
			isConsistente = false;
		}
		
		return isConsistente;
	}

	private boolean isConsistente(Telefone telefone) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Boolean validar(Long... l) {
		for (Long id : l) {
			if(id.equals(null)||id.equals(0L)||id<0L) {
				return false;
			}
			Pattern p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(id.toString());
			if(m.find()) {
				return false;
			}
		}
		return true;
	}
	
	public Boolean validar(Integer... i) {
		for (Integer integer : i) {
			if(integer.equals(null)||integer.equals(0)||integer<0) {
				return false;
			}
			Pattern p = Pattern.compile("[^0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(integer.toString());
			if(m.find()) {
				return false;
			}
		}
		return true;
	}

	public Boolean validar(String... s) {
		for (String string : s) {
			if(string.trim().isEmpty()||string.trim()==null||string.trim().equals(null)||string.trim().equals("")) {
				return false;
			}
			Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
			Matcher m = p.matcher(string);
			if(m.find()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
		// TODO Auto-generated method stub
		
	}
	
}
