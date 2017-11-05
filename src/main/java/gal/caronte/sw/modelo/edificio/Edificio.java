package gal.caronte.sw.modelo.edificio;

import java.util.Objects;

public class Edificio {

	//Columnas
	public static final String ID_EDIFICIO = "ID_EDIFICIO";
	public static final String ID_EDIFICIO_EXTERNO = "ID_EDIFICIO_EXTERNO";
	public static final String NOME = "NOME";
	public static final String DESCRICION = "DESCRICION";
	
	private final Short idEdificio;
	private final Short idEdificioExterno;
	private final String nome;
	private final String descricion;

	public Edificio(Short idEdificio, Short idEdificioExterno, String nome, String descricion) {
		super();
		this.idEdificio = idEdificio;
		this.idEdificioExterno = idEdificioExterno;
		this.nome = nome;
		this.descricion = descricion;
	}

	public Short getIdEdificio() {
		return this.idEdificio;
	}

	public Short getIdEdificioExterno() {
		return this.idEdificioExterno;
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricion() {
		return this.descricion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idEdificio);
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
		final Edificio other = (Edificio) obj;
		return Objects.equals(this.idEdificio, other.idEdificio);
	}

}
