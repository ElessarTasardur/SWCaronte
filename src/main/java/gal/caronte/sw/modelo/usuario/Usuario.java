package gal.caronte.sw.modelo.usuario;

import java.util.Objects;

public class Usuario {

	// Columnas
	public static final String ID_USUARIO = "ID_USUARIO";
	public static final String CONTA_USUARIO = "CONTA_USUARIO";
	
	private Short idUsuario;
	private String contaUsuario;

	public Usuario(Short idUsuario, String contaUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.contaUsuario = contaUsuario;
	}

	/**
	 * @return the idUsuario
	 */
	public Short getIdUsuario() {
		return this.idUsuario;
	}

	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(Short idUsuario) {
		this.idUsuario = idUsuario;
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
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Usuario [idUsuario=");
		builder.append(this.idUsuario);
		builder.append(", contaUsuario=");
		builder.append(this.contaUsuario);
		builder.append("]");
		return builder.toString();
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
		final Usuario other = (Usuario) obj;
		return Objects.equals(this.contaUsuario, other.contaUsuario);
	}
	
}
