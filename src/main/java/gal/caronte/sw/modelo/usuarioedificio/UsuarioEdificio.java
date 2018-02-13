package gal.caronte.sw.modelo.usuarioedificio;

import java.util.Objects;

public class UsuarioEdificio {

	// Columnas
	public static final String ID_USUARIO = "ID_USUARIO";
	public static final String ID_EDIFICIO = "ID_EDIFICIO";
	public static final String ADMINISTRADOR = "ADMINISTRADOR";
	
	private Short idUsuario;
	private Short idEdificio;
	private Boolean administrador;

	public UsuarioEdificio(Short idUsuario, Short idEdificio, Boolean administrador) {
		super();
		this.idUsuario = idUsuario;
		this.idEdificio = idEdificio;
		this.administrador = administrador;
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
	 * @return the idEdificio
	 */
	public Short getIdEdificio() {
		return this.idEdificio;
	}

	/**
	 * @param idEdificio the idEdificio to set
	 */
	public void setIdEdificio(Short idEdificio) {
		this.idEdificio = idEdificio;
	}

	/**
	 * @return the administrador
	 */
	public Boolean getAdministrador() {
		return this.administrador;
	}

	/**
	 * @param administrador the administrador to set
	 */
	public void setAdministrador(Boolean administrador) {
		this.administrador = administrador;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UsuarioEdificio [idUsuario=");
		builder.append(this.idUsuario);
		builder.append(", idEdificio=");
		builder.append(this.idEdificio);
		builder.append(", administrador=");
		builder.append(this.administrador);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idUsuario, this.idEdificio, this.administrador);
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
		final UsuarioEdificio other = (UsuarioEdificio) obj;
		return Objects.equals(this.idUsuario, other.idUsuario)
				&& Objects.equals(this.idEdificio, other.idEdificio)
				&& Objects.equals(this.administrador, other.administrador);
	}
	
}
