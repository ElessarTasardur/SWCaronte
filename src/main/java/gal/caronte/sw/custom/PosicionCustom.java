package gal.caronte.sw.custom;

public class PosicionCustom {
	
	private Short idEdificio;
	private Short idPlanta;
	private Short nivel;
	private Double latitude;
	private Double lonxitude;
	
	public PosicionCustom() {
		super();
	}

	public PosicionCustom(Short idEdificio, Short idPlanta, Short nivel, Double latitude, Double lonxitude) {
		super();
		this.idEdificio = idEdificio;
		this.idPlanta = idPlanta;
		this.nivel = nivel;
		this.latitude = latitude;
		this.lonxitude = lonxitude;
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
	 * @return the idPlanta
	 */
	public Short getIdPlanta() {
		return this.idPlanta;
	}

	/**
	 * @param idPlanta the idPlanta to set
	 */
	public void setIdPlanta(Short idPlanta) {
		this.idPlanta = idPlanta;
	}
	
	/**
	 * @return the nivel
	 */
	public Short getNivel() {
		return this.nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(Short nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude() {
		return this.latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the lonxitude
	 */
	public Double getLonxitude() {
		return this.lonxitude;
	}

	/**
	 * @param lonxitude the lonxitude to set
	 */
	public void setLonxitude(Double lonxitude) {
		this.lonxitude = lonxitude;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PosicionCustom [idEdificio=");
		builder.append(this.idEdificio);
		builder.append(", idPlanta=");
		builder.append(this.idPlanta);
		builder.append(", nivel=");
		builder.append(this.nivel);
		builder.append(", latitude=");
		builder.append(this.latitude);
		builder.append(", lonxitude=");
		builder.append(this.lonxitude);
		builder.append("]");
		return builder.toString();
	}

}
