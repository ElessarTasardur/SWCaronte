package gal.caronte.sw.modelo.edificio;

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
public class EdificioDaoImpl implements EdificioDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${edificioDao.selectTodosQuery}")
	private String selectTodosQuery;

	@Value("${edificioDao.selectPorIdQuery}")
	private String selectPorIdQuery;
	
	private final static RowMapper<Edificio> ROW_MAPPER = new RowMapper<Edificio>() {

		@Override
		public Edificio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idEdificio = rs.getShort(Edificio.ID_EDIFICIO);
			Short idEdificioExterno = rs.getShort(Edificio.ID_EDIFICIO_EXTERNO);
			String nome = rs.getString(Edificio.NOME);
			String descricion = rs.getString(Edificio.DESCRICION);
			return new Edificio(idEdificio, idEdificioExterno, nome, descricion);
		}

	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Edificio> getTodos() {
		return this.jdbcTemplate.query(this.selectTodosQuery, ROW_MAPPER);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Edificio getEdificio(Short idEdificio) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Edificio.ID_EDIFICIO, idEdificio);
		return this.jdbcTemplate.queryForObject(this.selectPorIdQuery, parameters, ROW_MAPPER);
	}
}
