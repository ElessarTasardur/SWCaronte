package gal.caronte.sw.modelo.percorrido;

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

import gal.caronte.sw.modelo.edificio.Edificio;

@Repository
public class PercorridoDaoImpl implements PercorridoDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Value("${percorridoDao.insertQuery}")
	private String insertQuery;

	@Value("${percorridoDao.updateQuery}")
	private String updateQuery;

	@Value("${percorridoDao.deleteQuery}")
	private String deleteQuery;

	@Value("${percorridoDao.selectPorIdQuery}")
	private String selectPorIdQuery;

	@Value("${percorridoDao.selectPorIdEdificioQuery}")
	private String selectPorIdEdificioQuery;

	@Value("${percorridoDao.selectPorIdEdificioExternoQuery}")
	private String selectPorIdEdificioExternoQuery;

	private final static RowMapper<Percorrido> ROW_MAPPER = new RowMapper<Percorrido>() {

		@Override
		public Percorrido mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idPercorrido = rs.getShort(Percorrido.ID_PERCORRIDO);
			String nome = rs.getString(Percorrido.NOME);
			String descricion = rs.getString(Percorrido.DESCRICION);
			Short idEdificio = rs.getShort(Percorrido.ID_EDIFICIO);
			return new Percorrido(idPercorrido, nome, descricion, idEdificio);
		}

	};

	@Override
	public Percorrido getPercorrido(Short idPercorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Percorrido.ID_PERCORRIDO, idPercorrido);
		return this.jdbcTemplate.queryForObject(this.selectPorIdQuery, parameters, ROW_MAPPER);
	}

	@Override
	public List<Percorrido> getListaPercorridoPorIdEdificio(Short idEdificio) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Percorrido.ID_EDIFICIO, idEdificio);
		return this.jdbcTemplate.query(this.selectPorIdEdificioQuery, parameters, ROW_MAPPER);
	}

	@Override
	public List<Percorrido> getListaPercorridoPorIdEdificioExterno(Short idEdificioExterno) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Edificio.ID_EDIFICIO_EXTERNO, idEdificioExterno);
		return this.jdbcTemplate.query(this.selectPorIdEdificioExternoQuery, parameters, ROW_MAPPER);
	}
	
	@Override
	public Short engadir(Percorrido percorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(Percorrido.NOME, percorrido.getNome())
				.addValue(Percorrido.DESCRICION, percorrido.getDescricion())
				.addValue(Percorrido.ID_EDIFICIO, percorrido.getIdEdificio());
		KeyHolder holder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(this.insertQuery, parameters, holder);
		Integer idPercorrido;
		if (holder.getKeys().size() > 1) {
			idPercorrido = (Integer) holder.getKeys().get(Percorrido.ID_PERCORRIDO);
	    }
		else {
	    	idPercorrido= holder.getKey().intValue();
	    }
		return idPercorrido.shortValue();
	}

	@Override
	public void modificar(Percorrido percorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Percorrido.ID_PERCORRIDO, percorrido.getIdPercorrido())
				.addValue(Percorrido.NOME, percorrido.getNome())
				.addValue(Percorrido.DESCRICION, percorrido.getDescricion());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	@Override
	public void eliminar(Short idPercorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Percorrido.ID_PERCORRIDO, idPercorrido);
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}

}
