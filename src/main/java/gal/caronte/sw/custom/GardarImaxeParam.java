package gal.caronte.sw.custom;

public class GardarImaxeParam {

	private Short idImaxe;
	private short idPoi;
	private String nome;
	private String descricion;
	
	public GardarImaxeParam() {
		super();
	}

	/**
	 * @param idImaxe
	 * @param idPoi
	 * @param nome
	 * @param descricion
	 */
	public GardarImaxeParam(Short idImaxe, short idPoi, String nome, String descricion) {
		super();
		this.idImaxe = idImaxe;
		this.idPoi = idPoi;
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
	 * @return the idPoi
	 */
	public short getIdPoi() {
		return this.idPoi;
	}

	/**
	 * @param idPoi the idPoi to set
	 */
	public void setIdPoi(short idPoi) {
		this.idPoi = idPoi;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GardarImaxeParam [idImaxe=");
		builder.append(this.idImaxe);
		builder.append(", idPoi=");
		builder.append(this.idPoi);
		builder.append(", nome=");
		builder.append(this.nome);
		builder.append(", descricion=");
		builder.append(this.descricion);
		builder.append("]");
		return builder.toString();
	}
	
}
