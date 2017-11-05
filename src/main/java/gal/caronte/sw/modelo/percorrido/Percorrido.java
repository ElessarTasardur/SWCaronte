package gal.caronte.sw.modelo.percorrido;

import java.util.Objects;

public class Percorrido {

	// Columnas
	public static final String ID_PERCORRIDO = "ID_PERCORRIDO";
	public static final String NOME = "NOME";
	public static final String DESCRICION = "DESCRICION";
	public static final String ID_EDIFICIO = "ID_EDIFICIO";
	
	private Short idPercorrido;
	private String nome;
	private String descricion;
	private Short idEdificio;
	
	public Percorrido(Short idPercorrido, String nome, String descricion, Short idEdificio) {
		super();
		this.idPercorrido = idPercorrido;
		this.nome = nome;
		this.descricion = descricion;
		this.idEdificio = idEdificio;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.nome, this.descricion, this.idEdificio);
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
		final Percorrido other = (Percorrido) obj;
		return Objects.equals(this.nome, other.nome)
				&& Objects.equals(this.descricion, other.descricion)
				&& Objects.equals(this.idEdificio, other.idEdificio);
	}
	
	
	
}
