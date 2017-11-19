package gal.caronte.sw.modelo.contasitum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContaSitumDaoImpl implements ContaSitumDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Value("${contaUsuarioDao.selectTodasQuery}")
	private String selectTodasQuery;

	private final static RowMapper<ContaSitum> ROW_MAPPER = new RowMapper<ContaSitum>() {

		@Override
		public ContaSitum mapRow(ResultSet rs, int rowNum) throws SQLException {
			String nomeUsuario = rs.getString(ContaSitum.NOME_USUARIO);
			String contrasinal = rs.getString(ContaSitum.CONTRASINAL);
			return new ContaSitum(nomeUsuario, contrasinal);
		}

	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ContaSitum> getTodas() {
		return this.jdbcTemplate.query(this.selectTodasQuery, ROW_MAPPER);
	}

}
