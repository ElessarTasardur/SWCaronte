package gal.caronte.sw.custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ComprobarLoginGoogleCustom {

	private Short idUsuario;
	private String contaUsuario;
	private List<Short> listaIdEdificioAdministrador;
	
	public ComprobarLoginGoogleCustom() {
		super();
		this.listaIdEdificioAdministrador = new ArrayList<>();
	}
	
	public ComprobarLoginGoogleCustom(Short idUsuario, String contaUsuario, List<Short> listaIdEdificioAdministrador) {
		super();
		this.idUsuario = idUsuario;
		this.contaUsuario = contaUsuario;
		this.listaIdEdificioAdministrador = listaIdEdificioAdministrador;
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
	 * @return the listaIdEdificioAdministrador
	 */
	public List<Short> getListaIdEdificioAdministrador() {
		return this.listaIdEdificioAdministrador;
	}

	/**
	 * @param listaIdEdificioAdministrador the listaIdEdificioAdministrador to set
	 */
	public void setListaIdEdificioAdministrador(List<Short> listaIdEdificioAdministrador) {
		this.listaIdEdificioAdministrador = listaIdEdificioAdministrador;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idUsuario);
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
		final ComprobarLoginGoogleCustom other = (ComprobarLoginGoogleCustom) obj;
		return Objects.equals(this.idUsuario, other.idUsuario);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ComprobarLoginGoogleCustom [idUsuario=");
		builder.append(this.idUsuario);
		builder.append(", contaUsuario=");
		builder.append(this.contaUsuario);
		builder.append(", listaIdEdificioAdministrador=");
		builder.append(this.listaIdEdificioAdministrador);
		builder.append("]");
		return builder.toString();
	}
	
	
}
