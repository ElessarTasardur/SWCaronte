package gal.caronte.sw.modelo.imaxe;

import java.util.Objects;

public class Imaxe {

	// Columnas
	public static final String ID_IMAXE = "ID_IMAXE";
	public static final String ID_PUNTO_INTERESE = "ID_PUNTO_INTERESE";
	public static final String NOME = "NOME";
	public static final String DESCRICION = "DESCRICION";
	
	private Short idImaxe;
	private Short idPuntoInterese;
	private String nome;
	private String descricion;
	
	public Imaxe(Short idImaxe, Short idPuntoInterese, String nome, String descricion) {
		super();
		this.idImaxe = idImaxe;
		this.idPuntoInterese = idPuntoInterese;
		this.nome = nome;
		this.descricion = descricion;
	}

	/**
	 * @return the idImaxe
	 */
	public Short getIdImaxe() {
		return this.idImaxe;
	}

	/**
	 * @param idImaxe the idImaxe to set
	 */
	public void setIdImaxe(Short idImaxe) {
		this.idImaxe = idImaxe;
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
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.idImaxe);
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
		final Imaxe other = (Imaxe) obj;
		return Objects.equals(this.idImaxe, other.idImaxe);
	}
	
}
