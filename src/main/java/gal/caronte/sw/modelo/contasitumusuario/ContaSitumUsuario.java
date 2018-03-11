package gal.caronte.sw.modelo.contasitumusuario;

import java.util.Objects;

public class ContaSitumUsuario {

	//Columnas
	public static final String ID_CONTA_SITUM = "ID_CONTA_SITUM";
	public static final String ID_USUARIO = "ID_USUARIO";
	
	private Short idContaSitum;
	private Short idUsuario;
	
	public ContaSitumUsuario() {
		super();
	}

	public ContaSitumUsuario(Short idContaSitum, Short idUsuario) {
		super();
		this.idContaSitum = idContaSitum;
		this.idUsuario = idUsuario;
	}

	/**
	 * @return the idContaSitum
	 */
	public Short getIdContaSitum() {
		return this.idContaSitum;
	}

	/**
	 * @param idContaSitum the idContaSitum to set
	 */
	public void setIdContaSitum(Short idContaSitum) {
		this.idContaSitum = idContaSitum;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idContaSitum, this.idUsuario);
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
		final ContaSitumUsuario other = (ContaSitumUsuario) obj;
		return Objects.equals(this.idContaSitum, other.idContaSitum)
				&& Objects.equals(this.idUsuario, other.idUsuario);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaSitumUsuario [idContaSitum=");
		builder.append(this.idContaSitum);
		builder.append(", idUsuario=");
		builder.append(this.idUsuario);
		builder.append("]");
		return builder.toString();
	}
	
}
