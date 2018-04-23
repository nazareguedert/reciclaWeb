package br.sc.senac.dw.rex.db.model;

import java.util.Date;

import br.sc.senac.dw.rex.db.model.entity.Endereco;
import br.sc.senac.dw.rex.db.model.entity.Logradouro;

public class EnderecoDAO extends GenericDAO<EnderecoDB, Endereco> {

	public EnderecoDAO() {
		super(BaseDAO.BANCO[1], "tb_endereco", "cep", "bairro", "logradouro", new EnderecoDB(), new Endereco());
	}

	@Override
	public EnderecoDB toDB(Endereco i) {
		EnderecoDB o = new EnderecoDB();

		o.setId(i.getId());
		o.setCep(i.getCep());
		o.setLatitude(i.getLatitude());
		o.setLongitude(i.getLongitude());
		o.setBairro(i.getBairro().getId());
		o.setLogradouro(i.getLogradouro().getId());
		o.setNumero(i.getNumero());
		o.setComplemento(i.getComplemento());
		o.setData_inclusao(i.getDataInclusao());
		o.setData_remocao(i.getDataRemocao());

		return o;
	}

	@Override
	public Endereco fromDB(EnderecoDB i) {
		Endereco o = new Endereco();

		o.setId(i.getId());
		o.setCep(i.getCep());
		o.setLatitude(i.getLatitude());
		o.setLongitude(i.getLongitude());
		o.setBairro(new BairroDAO().getPorId(i.getBairro()));
		o.setLogradouro(new LogradouroDAO().getPorId(i.getLogradouro()));
		o.setNumero(i.getNumero());
		o.setComplemento(i.getComplemento());
		o.setDataInclusao(i.getData_inclusao());
		o.setDataRemocao(i.getData_remocao());

		return o;
	}

}

class EnderecoDB {

	private Long id;
	private String cep;
	private Float latitude;
	private Float longitude;
	private Long bairro;
	private Long logradouro;
	private Integer numero;
	private String complemento;
	private Date data_inclusao;
	private Date data_remocao;

	public EnderecoDB() {
		super();
	}

	public EnderecoDB(String cep, Float latitude, Float longitude, Long bairro, Long logradouro, Integer numero,
			String complemento) {
		super();
		this.cep = cep;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
	}

	public EnderecoDB(Long id, String cep, Float latitude, Float longitude, Long bairro, Long logradouro,
			Integer numero, String complemento, Date data_inclusao, Date data_remocao) {
		super();
		this.id = id;
		this.cep = cep;
		this.latitude = latitude;
		this.longitude = longitude;
		this.bairro = bairro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.data_inclusao = data_inclusao;
		this.data_remocao = data_remocao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Long getBairro() {
		return bairro;
	}

	public void setBairro(Long bairro) {
		this.bairro = bairro;
	}

	public Long getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Long logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Date getData_inclusao() {
		return data_inclusao;
	}

	public void setData_inclusao(Date data_inclusao) {
		this.data_inclusao = data_inclusao;
	}

	public Date getData_remocao() {
		return data_remocao;
	}

	public void setData_remocao(Date data_remocao) {
		this.data_remocao = data_remocao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((data_inclusao == null) ? 0 : data_inclusao.hashCode());
		result = prime * result + ((data_remocao == null) ? 0 : data_remocao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDB other = (EnderecoDB) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (data_inclusao == null) {
			if (other.data_inclusao != null)
				return false;
		} else if (!data_inclusao.equals(other.data_inclusao))
			return false;
		if (data_remocao == null) {
			if (other.data_remocao != null)
				return false;
		} else if (!data_remocao.equals(other.data_remocao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (latitude == null) {
			if (other.latitude != null)
				return false;
		} else if (!latitude.equals(other.latitude))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (longitude == null) {
			if (other.longitude != null)
				return false;
		} else if (!longitude.equals(other.longitude))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnderecoDB [id=" + id + ", cep=" + cep + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", bairro=" + bairro + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", data_inclusao=" + data_inclusao + ", data_remocao=" + data_remocao + "]";
	}

	
}
