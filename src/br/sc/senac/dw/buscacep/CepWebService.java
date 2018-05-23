package br.sc.senac.dw.buscacep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.primefaces.json.JSONException;
import org.primefaces.json.JSONObject;

public class CepWebService {
	private String cepFormatado = "";
	private String estado = "";
	private String estadoNome = "";
	private String cidade = "";
	private String bairro = "";
	private String tipoLogradouro = "";
	private String logradouro = "";
	private String logradouroComplemento = "";

	private String retorno = "";
	private boolean retornoValido = false;

	// @SuppressWarnings("rawtypes")
	public CepWebService(String numero) {
		char[] toCharArray = numero.toCharArray();
		numero = "";

		for (Character c : toCharArray) {
			if (Character.isDigit(c)) {
				numero += c;
			}
		}
		while (numero.length() < 8) {
			numero += "0";
		}
		numero = numero.substring(0, 5) + "-" + numero.substring(5, 8);

		try {
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.postmon.com.br/v1/cep/" + numero)
					.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "text/html");

			BufferedReader retornoBruto = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			this.retorno = retornoBruto.readLine();
			conn.disconnect();

		} catch (IOException i) {
			retorno = "CEP nÃ£o encontrado ou serviÃ§o indisponÃ­vel";

		} finally {
			if (!retorno.equals("CEP nÃ£o encontrado ou serviÃ§o indisponÃ­vel")) {
				retornoValido = true;
				try {
					JSONObject dados = new JSONObject(retorno);
					JSONObject dadosEstado = new JSONObject(dados.get("estado_info").toString());
					// JSONObject dadosCidade =
					// new JSONObject(dados.get("cidade_info").toString());

					this.cepFormatado = numero; // dados.getString("cep");
					this.estadoNome = dadosEstado.getString("nome");
					this.estado = dados.getString("estado");
					// this.estadoCodigo = dadosEstado.getString("codigo_ibge");
					// this.estadoArea = dadosEstado.getString("area_km2");
					this.cidade = dados.getString("cidade");
					// this.cidadeCodigo = dadosCidade.getString("codigo_ibge");
					// this.cidadeArea = dadosCidade.getString("area_km2");
					this.bairro = dados.getString("bairro");
					String logradouroFull = dados.getString("logradouro");
					this.tipoLogradouro = logradouroFull.substring(0, logradouroFull.indexOf(" ")).toUpperCase();
					this.logradouro = logradouroFull.substring(logradouroFull.indexOf(" ") + 1,
							logradouroFull.length());
					this.logradouroComplemento = dados.getString("complemento");
				} catch (JSONException j) {
					// j.printStackTrace();
				} finally {

				}
			}
		}
	}

	public String getEstado() {
		return estado;
	}

	public String getEstadoNome() {
		return estadoNome;
	}

	public String getCidade() {
		return cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public String getLogradouroComplemento() {
		return logradouroComplemento;
	}

	public String getRetorno() {
		return retorno;
	}

	public boolean isRetornoValido() {
		return retornoValido;
	}

	@Override
	public String toString() {

		if (isRetornoValido()) {
			return "CepWebService [cep=" + cepFormatado + ", estado=" + estadoNome + ", uf=" + estado + ", cidade="
					+ cidade + ", bairro=" + bairro + ", tipoLogradouro=" + tipoLogradouro + ", logradouro="
					+ logradouro + ", complemento=" + logradouroComplemento + "]";
		} else {
			return retorno;
		}

	}
}