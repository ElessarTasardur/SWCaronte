package gal.caronte.sw.modelo.usuarioedificio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioEdificioDaoImpl implements UsuarioEdificioDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${usuarioEdificioDao.selectPorIdUsuarioQuery}")
	private String selectPorIdUsuarioQuery;
	
	@Value("${usuarioEdificioDao.insertQuery}")
	private String insertQuery;

	@Value("${usuarioEdificioDao.updateQuery}")
	private String updateQuery;

	@Value("${usuarioEdificioDao.deleteQuery}")
	private String deleteQuery;
	
	private final static RowMapper<UsuarioEdificio> ROW_MAPPER = new RowMapper<UsuarioEdificio>() {

		@Override
		public UsuarioEdificio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idUsuario = rs.getShort(UsuarioEdificio.ID_USUARIO);
			Short idEdificio = rs.getShort(UsuarioEdificio.ID_EDIFICIO);
			Boolean administrador = rs.getBoolean(UsuarioEdificio.ADMINISTRADOR);
			return new UsuarioEdificio(idUsuario, idEdificio, administrador);
		}

	};
	
	@Override
	public void engadir(UsuarioEdificio usuarioEdificio) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(UsuarioEdificio.ID_USUARIO, usuarioEdificio.getIdUsuario())
				.addValue(UsuarioEdificio.ID_EDIFICIO, usuarioEdificio.getIdEdificio())
				.addValue(UsuarioEdificio.ADMINISTRADOR, usuarioEdificio.getAdministrador());
		this.jdbcTemplate.update(this.insertQuery, parameters);
	}

	@Override
	public void modificar(UsuarioEdificio usuarioEdificio) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(UsuarioEdificio.ID_USUARIO, usuarioEdificio.getIdUsuario())
				.addValue(UsuarioEdificio.ID_EDIFICIO, usuarioEdificio.getIdEdificio())
				.addValue(UsuarioEdificio.ADMINISTRADOR, usuarioEdificio.getAdministrador());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	@Override
	public void eliminar(Short idUsuario, Short idEdificio) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(UsuarioEdificio.ID_USUARIO, idUsuario)
				.addValue(UsuarioEdificio.ID_EDIFICIO, idEdificio);
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}
	
	@Override
	public List<UsuarioEdificio> getPorIdUsuario(Short idUsuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(UsuarioEdificio.ID_USUARIO, idUsuario);
		return this.jdbcTemplate.query(this.selectPorIdUsuarioQuery, parameters, ROW_MAPPER);
	}
	
}
