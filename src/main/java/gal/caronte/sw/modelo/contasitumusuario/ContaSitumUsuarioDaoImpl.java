package gal.caronte.sw.modelo.contasitumusuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ContaSitumUsuarioDaoImpl implements ContaSitumUsuarioDao {
	
	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Value("${contaSitumUsuarioDao.insertQuery}")
	private String insertQuery;

	@Value("${contaSitumUsuarioDao.deleteQuery}")
	private String deleteQuery;
	
	private final static RowMapper<ContaSitumUsuario> ROW_MAPPER = new RowMapper<ContaSitumUsuario>() {

		@Override
		public ContaSitumUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idContaSitum = rs.getShort(ContaSitumUsuario.ID_CONTA_SITUM);
			Short idUsuario = rs.getShort(ContaSitumUsuario.ID_USUARIO);
			return new ContaSitumUsuario(idContaSitum, idUsuario);
		}

	};
	
	@Override
	public void engadir(ContaSitumUsuario contaSitumUsuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitumUsuario.ID_CONTA_SITUM, contaSitumUsuario.getIdContaSitum())
				.addValue(ContaSitumUsuario.ID_USUARIO, contaSitumUsuario.getIdUsuario());
		this.jdbcTemplate.update(this.insertQuery, parameters);
	}

	@Override
	public void eliminar(ContaSitumUsuario contaSitumUsuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitumUsuario.ID_CONTA_SITUM, contaSitumUsuario.getIdContaSitum())
				.addValue(ContaSitumUsuario.ID_USUARIO, contaSitumUsuario.getIdUsuario());
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}
}
