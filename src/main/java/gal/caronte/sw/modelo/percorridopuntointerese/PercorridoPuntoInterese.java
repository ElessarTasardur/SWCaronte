package gal.caronte.sw.modelo.percorridopuntointerese;

import java.util.Objects;

public class PercorridoPuntoInterese {

	// Columnas
	public static final String ID_PERCORRIDO = "ID_PERCORRIDO";
	public static final String ID_PUNTO_INTERESE = "ID_PUNTO_INTERESE";
	public static final String POSICION = "POSICION";
	
	private Short idPercorrido;
	private Short idPuntoInterese;
	private Short posicion;
	
	public PercorridoPuntoInterese(Short idPercorrido, Short idPuntoInterese, Short posicion) {
		super();
		this.idPercorrido = idPercorrido;
		this.idPuntoInterese = idPuntoInterese;
		this.posicion = posicion;
	}

	/**
	 * @return the idPercorrido
	 */
	public Short getIdPercorrido() {
		return this.idPercorrido;
	}

	/**
	 * @param idPercorrido the idPercorrido to set
	 */
	public void setIdPercorrido(Short idPercorrido) {
		this.idPercorrido = idPercorrido;
	}

	/**
	 * @return the idPuntoInterese
	 */
	public Short getIdPuntoInterese() {
		return this.idPuntoInterese;
	}

	/**
	 * @param idPuntoInterese the idPuntoInterese to set
	 */
	public void setIdPuntoInterese(Short idPuntoInterese) {
		this.idPuntoInterese = idPuntoInterese;
	}

	/**
	 * @return the posicion
	 */
	public Short getPosicion() {
		return this.posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(Short posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idPercorrido, this.idPuntoInterese, this.posicion);
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
		final PercorridoPuntoInterese other = (PercorridoPuntoInterese) obj;
		return Objects.equals(this.idPercorrido, other.idPercorrido)
				&& Objects.equals(this.idPuntoInterese, other.idPuntoInterese)
				&& Objects.equals(this.posicion, other.posicion);
	}
	
}
