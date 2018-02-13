package gal.caronte.sw.modelo.contasitum;

import java.util.Objects;

public class ContaSitum {

	//Columnas
	public static final String CONTA_USUARIO = "CONTA_USUARIO";
	public static final String NOME = "NOME";
	public static final String CONTRASINAL = "CONTRASINAL";
	
	private String contaUsuario;
	private String nome;
	private String contrasinal;
	
	public ContaSitum() {
		super();
	}

	public ContaSitum(String contaUsuario, String nome, String contrasinal) {
		super();
		this.contaUsuario = contaUsuario;
		this.nome = nome;
		this.contrasinal = contrasinal;
	}

	/**
	 * @return the contaUsuario
	 */
	public String getContaUsuario() {
		return this.contaUsuario;
	}

	/**
	 * @param contaUsuario the contaUsuario to set
	 */
	public void setContaUsuario(String contaUsuario) {
		this.contaUsuario = contaUsuario;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the contrasinal
	 */
	public String getContrasinal() {
		return this.contrasinal;
	}

	/**
	 * @param contrasinal the contrasinal to set
	 */
	public void setContrasinal(String contrasinal) {
		this.contrasinal = contrasinal;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.contaUsuario);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ContaSitum other = (ContaSitum) obj;
		return Objects.equals(this.contaUsuario, other.contaUsuario);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaCustom [contaUsuario=");
		builder.append(this.contaUsuario);
		builder.append(", nome=");
		builder.append(this.nome);
		builder.append(", contrasinal=");
		builder.append(this.contrasinal);
		builder.append("]");
		return builder.toString();
	}
	
}
