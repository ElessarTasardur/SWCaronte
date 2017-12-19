package gal.caronte.sw.custom;

public class PercorridoCustom {

	private Short idPercorrido;
	private String nome;
	private String descricion;
	private Short idEdificio;

	public PercorridoCustom() {
		super();
	}

	public PercorridoCustom(Short idPercorrido, String nome, String descricion, Short idEdificio) {
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
	
}
