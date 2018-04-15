package gal.caronte.sw.modelo.puntointerese;

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
import gal.caronte.sw.modelo.percorrido.Percorrido;

@Repository
public class PuntoIntereseDaoImpl implements PuntoIntereseDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	@Value("${puntoIntereseDao.insertQuery}")
	private String insertQuery;

	@Value("${puntoIntereseDao.updateQuery}")
	private String updateQuery;

	@Value("${puntoIntereseDao.deleteQuery}")
	private String deleteQuery;
	
	@Value("${puntoIntereseDao.selectPorIdQuery}")
	private String selectPorIdQuery;

	@Value("${puntoIntereseDao.selectPorIdEdificioQuery}")
	private String selectPorIdEdificioQuery;
	
	@Value("${puntoIntereseDao.selectPorIdEdificioExternoQuery}")
	private String selectPorIdEdificioExternoQuery;

	@Value("${puntoIntereseDao.selectPorIdPercorridoQuery}")
	private String selectPorIdPercorridoQuery;

	private final static RowMapper<PuntoInterese> ROW_MAPPER = new RowMapper<PuntoInterese>() {

		@Override
		public PuntoInterese mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idPuntoInterese = rs.getShort(PuntoInterese.ID_PUNTO_INTERESE);
			String nome = rs.getString(PuntoInterese.NOME);
			String descricion = rs.getString(PuntoInterese.DESCRICION);
			Short idEdificio = rs.getShort(PuntoInterese.ID_EDIFICIO);
			Short idPlanta = rs.getShort(PuntoInterese.ID_PLANTA);
			Short nivel = rs.getShort(PuntoInterese.NIVEL);
			Double latitude = rs.getDouble(PuntoInterese.LATITUDE);
			Double lonxitude = rs.getDouble(PuntoInterese.LONXITUDE);
			Short tempo = rs.getShort(PuntoInterese.TEMPO);
			String listaImaxe = rs.getString(PuntoInterese.LISTA_IMAXE);
			return new PuntoInterese(idPuntoInterese, nome, descricion, idEdificio, idPlanta, nivel, latitude, lonxitude, tempo, listaImaxe);
		}

	};

	@Override
	public PuntoInterese getPorId(Short idPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PuntoInterese.ID_PUNTO_INTERESE, idPuntoInterese);
		return this.jdbcTemplate.queryForObject(this.selectPorIdQuery, parameters, ROW_MAPPER);
	}

	@Override
	public List<PuntoInterese> getPorIdEdificio(Short idEdificio) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PuntoInterese.ID_EDIFICIO, idEdificio);
		return this.jdbcTemplate.query(this.selectPorIdEdificioQuery, parameters, ROW_MAPPER);
	}
	
	@Override
	public List<PuntoInterese> getPorIdEdificioExterno(Short idEdificioExterno) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Edificio.ID_EDIFICIO_EXTERNO, idEdificioExterno);
		return this.jdbcTemplate.query(this.selectPorIdEdificioExternoQuery, parameters, ROW_MAPPER);
	}

	@Override
	public List<PuntoInterese> getPorIdPercorrido(Short idPercorrido) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Percorrido.ID_PERCORRIDO, idPercorrido);
		return this.jdbcTemplate.query(this.selectPorIdPercorridoQuery, parameters, ROW_MAPPER);
	}

	@Override
	public Short engadir(PuntoInterese puntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(PuntoInterese.NOME, puntoInterese.getNome())
				.addValue(PuntoInterese.DESCRICION, puntoInterese.getDescricion())
				.addValue(PuntoInterese.ID_EDIFICIO, puntoInterese.getIdEdificio())
				.addValue(PuntoInterese.ID_PLANTA, puntoInterese.getIdPlanta())
				.addValue(PuntoInterese.NIVEL, puntoInterese.getNivel())
				.addValue(PuntoInterese.LATITUDE, puntoInterese.getLatitude())
				.addValue(PuntoInterese.LONXITUDE, puntoInterese.getLonxitude())
				.addValue(PuntoInterese.TEMPO, puntoInterese.getTempo());
		KeyHolder holder = new GeneratedKeyHolder();
		this.jdbcTemplate.update(this.insertQuery, parameters, holder);
		Integer idPoi;
		if (holder.getKeys().size() > 1) {
			idPoi = (Integer) holder.getKeys().get(PuntoInterese.ID_PUNTO_INTERESE);
	    }
		else {
			idPoi= holder.getKey().intValue();
	    }
		return idPoi.shortValue();
	}
	
	@Override
	public void modificar(PuntoInterese puntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource()
				.addValue(PuntoInterese.ID_PUNTO_INTERESE, puntoInterese.getIdPuntoInterese())
				.addValue(PuntoInterese.NOME, puntoInterese.getNome())
				.addValue(PuntoInterese.DESCRICION, puntoInterese.getDescricion())
				.addValue(PuntoInterese.ID_EDIFICIO, puntoInterese.getIdEdificio())
				.addValue(PuntoInterese.ID_PLANTA, puntoInterese.getIdPlanta())
				.addValue(PuntoInterese.NIVEL, puntoInterese.getNivel())
				.addValue(PuntoInterese.LATITUDE, puntoInterese.getLatitude())
				.addValue(PuntoInterese.LONXITUDE, puntoInterese.getLonxitude())
				.addValue(PuntoInterese.TEMPO, puntoInterese.getTempo());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	@Override
	public boolean eliminar(Short idPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(PuntoInterese.ID_PUNTO_INTERESE, idPuntoInterese);
		return this.jdbcTemplate.update(this.deleteQuery, parameters) == 1;
	}
}
