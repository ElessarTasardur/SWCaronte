package gal.caronte.sw.modelo.usuarioedificio;

import java.util.List;

public interface UsuarioEdificioDao {

	void engadir(UsuarioEdificio usuarioEdificio);

	void modificar(UsuarioEdificio usuarioEdificio);

	void eliminar(Short idUsuario, Short idEdificio);

	List<UsuarioEdificio> getPorIdUsuario(Short idUsuario);
	
}
