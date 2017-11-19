package gal.caronte.sw.modelo.contasitum;

import java.util.Objects;

public class ContaSitum {

	//Columnas
	public static final String NOME_USUARIO = "NOME_USUARIO";
	public static final String CONTRASINAL = "CONTRASINAL";
	
	private String nomeUsuario;
	private String contrasinal;
	
	public ContaSitum() {
		super();
	}

	public ContaSitum(String nomeUsuario, String contrasinal) {
		super();
		this.nomeUsuario = nomeUsuario;
		this.contrasinal = contrasinal;
	}

	/**
	 * @return the nomeUsuario
	 */
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	/**
	 * @param nomeUsuario the nomeUsuario to set
	 */
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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
		return Objects.hash(this.nomeUsuario);
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
		return Objects.equals(this.nomeUsuario, other.nomeUsuario);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaCustom [nomeUsuario=");
		builder.append(this.nomeUsuario);
		builder.append(", contrasinal=");
		builder.append(this.contrasinal);
		builder.append("]");
		return builder.toString();
	}
	
}
