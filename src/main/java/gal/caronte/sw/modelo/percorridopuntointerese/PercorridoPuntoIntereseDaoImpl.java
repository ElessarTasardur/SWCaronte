package gal.caronte.sw.modelo.percorridopuntointerese;

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
public class PercorridoPuntoIntereseDaoImpl implements PercorridoPuntoIntereseDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${percorridoPuntoIntereseDao.insertQuery}")
	private String insertQuery;

	@Value("${percorridoPuntoIntereseDao.updateQuery}")
	private String updateQuery;

	@Value("${percorridoPuntoIntereseDao.deleteQuery}")
	private String deleteQuery;
	
	@Value("${percorridoPuntoIntereseDao.selectPorIdPercorridoQuery}")
	private String selectPorIdPercorridoQuery;

	private final static RowMapper<PercorridoPuntoInterese> ROW_MAPPER = new RowMapper<PercorridoPuntoInterese>() {

		@Override
		public PercorridoPuntoInterese mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idPercorrido = rs.getShort(PercorridoPuntoInterese.ID_PERCORRIDO);
			Short idPuntoInterese = rs.getShort(PercorridoPuntoInterese.ID_PUNTO_INTERESE);
			Short posicion = rs.getShort(PercorridoPuntoInterese.POSICION);
			return new PercorridoPuntoInterese(idPercorrido, idPuntoInterese, posicion);
		}

	};

	@Override
	public void engadir(PercorridoPuntoInterese percorridoPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PercorridoPuntoInterese.ID_PERCORRIDO, percorridoPuntoInterese.getIdPercorrido())
				.addValue(PercorridoPuntoInterese.ID_PUNTO_INTERESE, percorridoPuntoInterese.getIdPuntoInterese())
				.addValue(PercorridoPuntoInterese.POSICION, percorridoPuntoInterese.getPosicion());
		this.jdbcTemplate.update(this.insertQuery, parameters);
	}

	@Override
	public void modificar(PercorridoPuntoInterese percorridoPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PercorridoPuntoInterese.ID_PERCORRIDO, percorridoPuntoInterese.getIdPercorrido())
				.addValue(PercorridoPuntoInterese.ID_PUNTO_INTERESE, percorridoPuntoInterese.getIdPuntoInterese())
				.addValue(PercorridoPuntoInterese.POSICION, percorridoPuntoInterese.getPosicion());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	@Override
	public void eliminar(Short idPercorrido, Short idPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PercorridoPuntoInterese.ID_PERCORRIDO, idPercorrido)
				.addValue(PercorridoPuntoInterese.ID_PUNTO_INTERESE, idPuntoInterese);
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}

	@Override
	public List<PercorridoPuntoInterese> getListaPercorridoPuntoInteresePorIdPercorrido(Short idPercorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PercorridoPuntoInterese.ID_PERCORRIDO, idPercorrido);
		return this.jdbcTemplate.query(this.selectPorIdPercorridoQuery, parameters, ROW_MAPPER);
	}

}
