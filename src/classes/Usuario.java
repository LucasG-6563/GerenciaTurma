package classes;

public class Usuario {

	private String user, senha, codigoRecupera;

	public String getCodigoRecupera() {
		return codigoRecupera;
	}

	public void setCodigoRecupera(String codigoRecupera) {
		this.codigoRecupera = codigoRecupera;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario() {
		setUser("lusca");
		setSenha("Lusca123");
		setCodigoRecupera("54321");
	}
	
	public boolean verificaUser(String usuario, String senha) {
		if(usuario.equals(this.user) && senha.equals(this.senha))
			return true;
		else
			return false;
	}
	
	public String recuperaSenha(String senhaRecupera) {
		if(senhaRecupera.equals(this.codigoRecupera))
			return getSenha();
		else
			return null;
	}
}
