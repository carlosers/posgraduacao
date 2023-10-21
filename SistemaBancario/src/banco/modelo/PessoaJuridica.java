package banco.modelo;

public class PessoaJuridica extends Cliente {

	private String cnpj;
	private String razaoSocial;
	
	public PessoaJuridica() {
		super();
		cnpj="";
		razaoSocial="INDEFINIDA";
	}

	public PessoaJuridica(String cnpj, String razaoSocial, String cidade, String estado) {
		
		super(cidade, estado);
		this.cnpj = cnpj;
		this.razaoSocial= razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String listarDados() {
		return "RAZÃO SOCIAL: "+razaoSocial+"\n"+"CNPJ: "+cnpj+"\n"+super.listarDados();
	}
}
