package gal.caronte.sw.custom;

public class PercorridoCustom {

	private Short idPercorrido;
	private String nome;
	private String descricion;
	private Short idEdificio;
	private Short tempoTotal;
	private Short tempoCaminho;

	public PercorridoCustom() {
		super();
	}

	public PercorridoCustom(Short idPercorrido, String nome, String descricion, Short idEdificio, Short tempoTotal, Short tempoCaminho) {
		super();
		this.idPercorrido = idPercorrido;
		this.nome = nome;
		this.descricion = descricion;
		this.idEdificio = idEdificio;
		this.tempoTotal = tempoTotal;
		this.tempoCaminho = tempoCaminho;
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
	 * @return the tempoTotal
	 */
	public Short getTempoTotal() {
		return this.tempoTotal;
	}

	/**
	 * @param tempoTotal the tempoTotal to set
	 */
	public void setTempoTotal(Short tempoTotal) {
		this.tempoTotal = tempoTotal;
	}

	/**
	 * @return the tempoCaminho
	 */
	public Short getTempoCaminho() {
		return this.tempoCaminho;
	}

	/**
	 * @param tempoCaminho the tempoCaminho to set
	 */
	public void setTempoCaminho(Short tempoCaminho) {
		this.tempoCaminho = tempoCaminho;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PercorridoCustom [idPercorrido=");
		builder.append(this.idPercorrido);
		builder.append(", nome=");
		builder.append(this.nome);
		builder.append(", descricion=");
		builder.append(this.descricion);
		builder.append(", idEdificio=");
		builder.append(this.idEdificio);
		builder.append(", tempoTotal=");
		builder.append(this.tempoTotal);
		builder.append(", tempoCaminho=");
		builder.append(this.tempoCaminho);
		builder.append("]");
		return builder.toString();
	}
	
}
