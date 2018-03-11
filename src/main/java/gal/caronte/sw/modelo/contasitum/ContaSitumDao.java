package gal.caronte.sw.modelo.contasitum;

import java.util.List;

public interface ContaSitumDao {

	void engadir(ContaSitum contaSitum);

	void modificar(ContaSitum contaSitum);

	void eliminar(String contaUsuario);
	
	List<ContaSitum> getTodas();

	List<ContaSitum> getPublica();

	List<ContaSitum> getContaPorIdUsuario(Short idUsuario);
	
}
