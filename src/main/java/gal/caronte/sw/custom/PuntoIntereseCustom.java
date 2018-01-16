package gal.caronte.sw.custom;

public class PuntoIntereseCustom {

	private Short idPuntoInterese;
	private String nome;
	private String descricion;
	private PosicionCustom posicion;
	
	public PuntoIntereseCustom() {
		super();
	}

	public PuntoIntereseCustom(Short idPuntoInterese, String nome, String descricion, PosicionCustom posicion) {
		super();
		this.idPuntoInterese = idPuntoInterese;
		this.nome = nome;
		this.descricion = descricion;
		this.posicion = posicion;
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
	 * @return the posicion
	 */
	public PosicionCustom getPosicion() {
		return this.posicion;
	}

	/**
	 * @param posicion the posicion to set
	 */
	public void setPosicion(PosicionCustom posicion) {
		this.posicion = posicion;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PuntoIntereseCustom [idPuntoInterese=");
		builder.append(this.idPuntoInterese);
		builder.append(", nome=");
		builder.append(this.nome);
		builder.append(", descricion=");
		builder.append(this.descricion);
		builder.append(", posicion=");
		builder.append(this.posicion);
		builder.append("]");
		return builder.toString();
	}
	
	
}
