package gal.caronte.sw.custom;

public class PosicionCustom {
	
	private Short idEdificio;
	private Short idPlanta;
	private Float latitude;
	private Float lonxitude;
	
	public PosicionCustom() {
		super();
	}

	public PosicionCustom(Short idEdificio, Short idPlanta, Float latitude, Float lonxitude) {
		super();
		this.idEdificio = idEdificio;
		this.idPlanta = idPlanta;
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
	 * @return the latitude
	 */
	public Float getLatitude() {
		return this.latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the lonxitude
	 */
	public Float getLonxitude() {
		return this.lonxitude;
	}

	/**
	 * @param lonxitude the lonxitude to set
	 */
	public void setLonxitude(Float lonxitude) {
		this.lonxitude = lonxitude;
	}

}
