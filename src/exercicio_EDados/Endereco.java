package exercicio_EDados;

public class Endereco {
	private String logradouro;
	private String complemento;
	private String CEP;
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	@Override
	public String toString() {
		return "Endereco [logradouro=" + logradouro + ", complemento=" + complemento + ", CEP=" + CEP + "]";
	}
	

	
	
}
