package Config;

public class Config {
	
	private int maxPrestamos;
	private String nombreBiblioteca;
	private String sisVersion;
	private int maxLogin;
	
	public Config() {
		this.maxPrestamos = 3;
		this.nombreBiblioteca = "Biblioteca Municipal";
		this.sisVersion = "1.0";
		this.maxLogin = 3;
	}

	public int getMaxPrestamos() {
		return maxPrestamos;
	}

	public String getNombreBiblioteca() {
		return nombreBiblioteca;
	}

	public String getSisVersion() {
		return sisVersion;
	}

	public int getMaxLogin() {
		return maxLogin;
	}
}
	
	