package gal.caronte.sw.modelo.puntointerese;

import java.util.Objects;

public class PuntoInterese {

	// Columnas
	public static final String ID_PUNTO_INTERESE = "ID_PUNTO_INTERESE";
	public static final String NOME = "NOME";
	public static final String DESCRICION = "DESCRICION";
	public static final String ID_EDIFICIO = "ID_EDIFICIO";
	public static final String ID_PLANTA = "ID_PLANTA";
	public static final String NIVEL = "NIVEL";
	public static final String LATITUDE = "LATITUDE";
	public static final String LONXITUDE = "LONXITUDE";
	
	private Short idPuntoInterese;
	private String nome;
	private String descricion;
	private Short idEdificio;
	private Short idPlanta;
	private Short nivel;
	private Float latitude;
	private Float lonxitude;

	public PuntoInterese(Short idPuntoInterese, String nome, String descricion, Short idEdificio, Short idPlanta, Short nivel,
			Float latitude, Float lonxitude) {
		super();
		this.idPuntoInterese = idPuntoInterese;
		this.nome = nome;
		this.descricion = descricion;
		this.idEdificio = idEdificio;
		this.idPlanta = idPlanta;
		this.nivel = nivel;
		this.latitude = latitude;
		this.lonxitude = lonxitude;
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
	 * @return the descricion
	 */
	public String getDescricion() {
		return this.descricion;
	}

	/**
	 * @param descricion the descricion to set
	 */
	public void setDescricion(String descricion) {
		this.descricion = descricion;
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.idEdificio, this.idPlanta, this.latitude, this.lonxitude);
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
		final PuntoInterese other = (PuntoInterese) obj;
		return Objects.equals(this.nome, other.nome)
				&& Objects.equals(this.idEdificio, other.idEdificio)
				&& Objects.equals(this.idPlanta, other.idPlanta)
				&& Objects.equals(this.latitude, other.latitude)
				&& Objects.equals(this.lonxitude, other.lonxitude);
	}
	
}
