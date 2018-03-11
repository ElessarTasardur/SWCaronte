package gal.caronte.sw.modelo.contasitum;

import java.util.Objects;

public class ContaSitum {

	//Columnas
	public static final String ID_CONTA_SITUM = "ID_CONTA_SITUM";
	public static final String CONTA_USUARIO = "CONTA_USUARIO";
	public static final String NOME = "NOME";
	public static final String CONTRASINAL = "CONTRASINAL";
	public static final String PUBLICA = "PUBLICA";
	
	private Short idContaSitum;
	private String contaUsuario;
	private String nome;
	private String contrasinal;
	private Boolean publica;
	
	public ContaSitum() {
		super();
	}

	public ContaSitum(Short idContaSitum, String contaUsuario, String nome, String contrasinal, boolean publica) {
		super();
		this.idContaSitum = idContaSitum;
		this.contaUsuario = contaUsuario;
		this.nome = nome;
		this.contrasinal = contrasinal;
		this.publica = publica;
	}

	/**
	 * @return the contaUsuario
	 */
	public String getContaUsuario() {
		return this.contaUsuario;
	}

	/**
	 * @param contaUsuario the contaUsuario to set
	 */
	public void setContaUsuario(String contaUsuario) {
		this.contaUsuario = contaUsuario;
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
	 * @return the contrasinal
	 */
	public String getContrasinal() {
		return this.contrasinal;
	}

	/**
	 * @param contrasinal the contrasinal to set
	 */
	public void setContrasinal(String contrasinal) {
		this.contrasinal = contrasinal;
	}

	/**
	 * @return the idContaSitum
	 */
	public Short getIdContaSitum() {
		return this.idContaSitum;
	}

	/**
	 * @param idContaSitum the idContaSitum to set
	 */
	public void setIdContaSitum(Short idContaSitum) {
		this.idContaSitum = idContaSitum;
	}

	/**
	 * @return the publica
	 */
	public Boolean getPublica() {
		return this.publica;
	}

	/**
	 * @param publica the publica to set
	 */
	public void setPublica(Boolean publica) {
		this.publica = publica;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		return Objects.hash(this.contaUsuario);
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
		final ContaSitum other = (ContaSitum) obj;
		return Objects.equals(this.contaUsuario, other.contaUsuario);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ContaSitum [idContaSitum=");
		builder.append(this.idContaSitum);
		builder.append(", contaUsuario=");
		builder.append(this.contaUsuario);
		builder.append(", nome=");
		builder.append(this.nome);
		builder.append(", contrasinal=");
		builder.append(this.contrasinal);
		builder.append(", publica=");
		builder.append(this.publica);
		builder.append("]");
		return builder.toString();
	}
	
}
