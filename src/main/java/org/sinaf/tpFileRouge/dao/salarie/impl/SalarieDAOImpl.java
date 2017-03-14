package org.sinaf.tpFileRouge.dao.salarie.impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.sinaf.tpFileRouge.dao.ConnexionManager;
import org.sinaf.tpFileRouge.dao.salarie.SalarieDao;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Salarie;

public class SalarieDAOImpl implements SalarieDao {

	private static final String GET_BY_USERNAME_QUERY = "SELECT ID_SALARIE,NOM, PRENOM, USERNAME, PASSWORD FROM SALARIE WHERE USERNAME  = ?";
	private static final String GET_BY_ID_QUERY = "SELECT ID_SALARIE,NOM, PRENOM, USERNAME, PASSWORD FROM SALARIE WHERE ID_SALARIE  = ?";

	private Connection con;

	public SalarieDAOImpl() throws TechniqueException {
		try {
			this.con = ConnexionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public SalarieDAOImpl(Connection connection) {
		this.con = connection;
	}

	@Override
	public int create(Salarie model) throws TechniqueException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Salarie model) throws TechniqueException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Salarie> getById(Long id) throws TechniqueException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Salarie salarie = null;

		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(GET_BY_ID_QUERY);
				preparedStatement.setLong(1, id);
				rs = preparedStatement.executeQuery();
				rs.next();
				salarie = new Salarie(rs.getLong("ID_SALARIE"), rs.getString("NOM"), rs.getString("PRENOM"),
						rs.getString("USERNAME"), rs.getString("PASSWORD"), null, null);
			} catch (SQLException e) {
				throw new TechniqueException("Salarie not found SQLException ", e);
			}

		}

		return Optional.ofNullable(salarie);
	}

	@Override
	public void delete(Salarie model) throws TechniqueException {
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Salarie> getSalarieByUsername(String username) throws TechniqueException {
		PreparedStatement preparedStatement;
		ResultSet rs;
		Salarie salarie = null;

		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(GET_BY_USERNAME_QUERY);
				preparedStatement.setString(1, username);
				rs = preparedStatement.executeQuery();
				rs.next();
				salarie = new Salarie(rs.getLong("ID_SALARIE"), rs.getString("NOM"), rs.getString("PRENOM"),
						rs.getString("USERNAME"), rs.getString("PASSWORD"), null, null);
			} catch (SQLException e) {
				throw new TechniqueException("Salarie not found SQLException ", e);
			}

		}

		return Optional.ofNullable(salarie);
	}

}
