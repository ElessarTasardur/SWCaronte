package gal.caronte.sw.custom;

public class ImaxeCustom {

	private Short idImaxe;
	private String nome;
	private String descricion;
	private Short idPuntoInterese;

	public ImaxeCustom() {
		super();
	}

	public ImaxeCustom(Short idImaxe, String nome, String descricion, Short idPuntoInterese) {
		super();
		this.idImaxe = idImaxe;
		this.nome = nome;
		this.descricion = descricion;
		this.idPuntoInterese = idPuntoInterese;
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
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ImaxeCustom [idImaxe=");
		builder.append(this.idImaxe);
		builder.append(", nome=");
		builder.append(this.nome);
		builder.append(", descricion=");
		builder.append(this.descricion);
		builder.append(", idPuntoInterese=");
		builder.append(this.idPuntoInterese);
		builder.append("]");
		return builder.toString();
	}
	
}
