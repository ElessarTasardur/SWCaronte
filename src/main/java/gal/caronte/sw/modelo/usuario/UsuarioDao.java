package gal.caronte.sw.modelo.usuario;

public interface UsuarioDao {

	Short engadir(Usuario usuario);

	void modificar(Usuario usuario);

	void eliminar(Short idUsuario);

}
