package gal.caronte.sw.custom;

public class PercorridoPuntoIntereseCustom {

	private Short idPercorrido;
	private Short idPuntoInterese;
	private Short posicion;

	public PercorridoPuntoIntereseCustom() {
		super();
	}
	
	public PercorridoPuntoIntereseCustom(Short idPercorrido, Short idPuntoInterese, Short posicion) {
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
	
}
