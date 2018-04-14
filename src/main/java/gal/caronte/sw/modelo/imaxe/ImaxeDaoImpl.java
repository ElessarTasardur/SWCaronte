package gal.caronte.sw.modelo.imaxe;

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
public class ImaxeDaoImpl implements ImaxeDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${imaxeDao.insertQuery}")
	private String insertQuery;

	@Value("${imaxeDao.updateQuery}")
	private String updateQuery;

	@Value("${imaxeDao.deleteQuery}")
	private String deleteQuery;
	
	@Value("${imaxeDao.deletePorIdPuntoIntereseQuery}")
	private String deletePorIdPuntoIntereseQuery;
	
	@Value("${imaxeDao.selectPorIdPuntoIntereseQuery}")
	private String selectPorIdPuntoIntereseQuery;
	
	private final static RowMapper<Imaxe> ROW_MAPPER = new RowMapper<Imaxe>() {

		@Override
		public Imaxe mapRow(ResultSet rs, int rowNum) throws SQLException {
			Short idImaxe = rs.getShort(Imaxe.ID_IMAXE);
			Short idPuntoInterese = rs.getShort(Imaxe.ID_PUNTO_INTERESE);
			String nome = rs.getString(Imaxe.NOME);
			String descricion = rs.getString(Imaxe.DESCRICION);
			return new Imaxe(idImaxe, idPuntoInterese, nome, descricion);
		}

	};
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int engadir(Imaxe imaxe) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Imaxe.ID_PUNTO_INTERESE, imaxe.getIdPuntoInterese())
				.addValue(Imaxe.NOME, imaxe.getNome())
				.addValue(Imaxe.DESCRICION, imaxe.getDescricion());
		return this.jdbcTemplate.update(this.insertQuery, parameters);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void modificar(Imaxe imaxe) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Imaxe.ID_IMAXE, imaxe.getIdImaxe())
				.addValue(Imaxe.NOME, imaxe.getNome())
				.addValue(Imaxe.DESCRICION, imaxe.getDescricion());
		this.jdbcTemplate.update(this.updateQuery, parameters);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminar(Short idImaxe) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Imaxe.ID_IMAXE, idImaxe);
		this.jdbcTemplate.update(this.deleteQuery, parameters);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void eliminarPorIdPuntoInterese(Short idPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Imaxe.ID_PUNTO_INTERESE, idPuntoInterese);
		this.jdbcTemplate.update(this.deletePorIdPuntoIntereseQuery, parameters);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Imaxe> getListaImaxePorIdPuntoInterese(Short idPuntoInterese) {
		SqlParameterSource parameters = new MapSqlParameterSource().addValue(Imaxe.ID_PUNTO_INTERESE, idPuntoInterese);
		return this.jdbcTemplate.query(this.selectPorIdPuntoIntereseQuery, parameters, ROW_MAPPER);
	}

}
