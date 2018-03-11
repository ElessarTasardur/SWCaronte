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

import gal.caronte.sw.modelo.contasitumusuario.ContaSitumUsuario;

@Repository
public class ContaSitumDaoImpl implements ContaSitumDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Value("${contaSitumDao.insertQuery}")
	private String insertQuery;

	@Value("${contaSitumDao.updateQuery}")
	private String updateQuery;

	@Value("${contaSitumDao.deleteQuery}")
	private String deleteQuery;
	
	@Value("${contaSitumDao.selectTodasQuery}")
	private String selectTodasQuery;
	
	@Value("${contaSitumDao.selectPublicaQuery}")
	private String selectPublicaQuery;
	
	@Value("${contaSitumDao.selectPorIdUsuarioQuery}")
	private String selectPorIdUsuarioQuery;

	private final static RowMapper<ContaSitum> ROW_MAPPER = new RowMapper<ContaSitum>() {

		@Override
		public ContaSitum mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idContaUsuario = rs.getShort(ContaSitum.ID_CONTA_SITUM);
			String contaUsuario = rs.getString(ContaSitum.CONTA_USUARIO);
			String nome = rs.getString(ContaSitum.NOME);
			String contrasinal = rs.getString(ContaSitum.CONTRASINAL);
			boolean publica = rs.getBoolean(ContaSitum.PUBLICA);
			return new ContaSitum(idContaUsuario, contaUsuario, nome, contrasinal, publica);
		}

	};
	
	@Override
	public void engadir(ContaSitum contaSitum) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitum.CONTA_USUARIO, contaSitum.getContaUsuario())
				.addValue(ContaSitum.CONTRASINAL, contaSitum.getContrasinal())
				.addValue(ContaSitum.NOME, contaSitum.getNome())
				.addValue(ContaSitum.PUBLICA, contaSitum.getPublica());
		this.jdbcTemplate.update(this.insertQuery, parameters);
	}

	@Override
	public void modificar(ContaSitum contaSitum) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitum.CONTA_USUARIO, contaSitum.getContaUsuario())
				.addValue(ContaSitum.CONTRASINAL, contaSitum.getContrasinal())
				.addValue(ContaSitum.NOME, contaSitum.getNome())
				.addValue(ContaSitum.PUBLICA, contaSitum.getPublica());
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

	@Override
	public List<ContaSitum> getPublica() {
		return this.jdbcTemplate.query(this.selectPublicaQuery, ROW_MAPPER);
	}

	@Override
	public List<ContaSitum> getContaPorIdUsuario(Short idUsuario) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(ContaSitumUsuario.ID_USUARIO, idUsuario);
		return this.jdbcTemplate.query(this.selectPorIdUsuarioQuery, parameters, ROW_MAPPER);
	}

}
