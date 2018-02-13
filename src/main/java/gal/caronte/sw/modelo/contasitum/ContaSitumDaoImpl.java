package gal.caronte.sw.modelo.contasitum;

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

import gal.caronte.sw.modelo.percorridopuntointerese.PercorridoPuntoInterese;

@Repository
public class ContaSitumDaoImpl implements ContaSitumDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${contaSitumDao.selectTodasQuery}")
	private String selectTodasQuery;

	@Value("${contaSitumDao.insertQuery}")
	private String insertQuery;

	@Value("${contaSitumDao.updateQuery}")
	private String updateQuery;

	@Value("${contaSitumDao.deleteQuery}")
	private String deleteQuery;

	private final static RowMapper<ContaSitum> ROW_MAPPER = new RowMapper<ContaSitum>() {

		@Override
		public ContaSitum mapRow(ResultSet rs, int rowNum) throws SQLException {
			String contaUsuario = rs.getString(ContaSitum.CONTA_USUARIO);
			String nome = rs.getString(ContaSitum.NOME);
			String contrasinal = rs.getString(ContaSitum.CONTRASINAL);
			return new ContaSitum(contaUsuario, nome, contrasinal);
		}

	};
	
	@Override
	public void engadir(ContaSitum contaSitum) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitum.CONTA_USUARIO, contaSitum.getContaUsuario())
				.addValue(ContaSitum.CONTRASINAL, contaSitum.getContrasinal())
				.addValue(ContaSitum.NOME, contaSitum.getNome());
		this.jdbcTemplate.update(this.insertQuery, parameters);
	}

	@Override
	public void modificar(ContaSitum contaSitum) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitum.CONTA_USUARIO, contaSitum.getContaUsuario())
				.addValue(ContaSitum.CONTRASINAL, contaSitum.getContrasinal())
				.addValue(ContaSitum.NOME, contaSitum.getNome());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	@Override
	public void eliminar(String contaUsuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitum.CONTA_USUARIO, contaUsuario);
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ContaSitum> getTodas() {
		return this.jdbcTemplate.query(this.selectTodasQuery, ROW_MAPPER);
	}

}
