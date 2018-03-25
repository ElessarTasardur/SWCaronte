package gal.caronte.sw.modelo.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDaoImpl implements UsuarioDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Value("${usuarioDao.insertQuery}")
	private String insertQuery;

	@Value("${usuarioDao.updateQuery}")
	private String updateQuery;

	@Value("${usuarioDao.deleteQuery}")
	private String deleteQuery;

	@Value("${usuarioDao.selectPorContaUsuarioQuery}")
	private String selectPorContaUsuarioQuery;
	
	private final static RowMapper<Usuario> ROW_MAPPER = new RowMapper<Usuario>() {

		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idUsuario = rs.getShort(Usuario.ID_USUARIO);
			String contaUsuario = rs.getString(Usuario.CONTA_USUARIO);
			return new Usuario(idUsuario, contaUsuario);
		}

	};

	@Override
	public Short engadir(Usuario usuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Usuario.CONTA_USUARIO, usuario.getContaUsuario());
		KeyHolder holder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(this.insertQuery, parameters, holder);
		Integer idUsuario;
		if (holder.getKeys().size() > 1) {
			idUsuario = (Integer) holder.getKeys().get(Usuario.ID_USUARIO);
	    }
		else {
			idUsuario = holder.getKey().intValue();
	    }
		return idUsuario.shortValue();
	}

	@Override
	public void modificar(Usuario percorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Usuario.CONTA_USUARIO, percorrido.getContaUsuario());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	@Override
	public void eliminar(Short idPercorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Usuario.ID_USUARIO, idPercorrido);
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}

	@Override
	public Usuario getPorContaUsuario(String contaUsuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Usuario.CONTA_USUARIO, contaUsuario);
		
		List<Usuario> listaUsuario = this.jdbcTemplate.query(this.selectPorContaUsuarioQuery, parameters, ROW_MAPPER);
		
		Usuario resultado = null;
		if (listaUsuario != null
				&& !listaUsuario.isEmpty()) {
			resultado = listaUsuario.get(0);
		}
		
		return resultado;
	}
	
}
