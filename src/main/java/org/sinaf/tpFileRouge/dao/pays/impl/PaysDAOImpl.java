package org.sinaf.tpFileRouge.dao.pays.impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.sinaf.tpFileRouge.dao.ConnexionManager;
import org.sinaf.tpFileRouge.dao.pays.PaysDAO;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pays;

public class PaysDAOImpl implements PaysDAO {

	private final String SELECT_QUERY = "SELECT ID_PAYS,NOM FROM PAYS WHERE ID_PAYS = ?";

	private Connection con;

	public PaysDAOImpl() throws TechniqueException {
		try {
			this.con = ConnexionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public PaysDAOImpl(Connection connection) {
		this.con = connection;
	}

	@Override
	public int create(Pays model) throws TechniqueException {
		return 0;
	}

	@Override
	public void update(Pays model) throws TechniqueException {
	}

	@Override
	public Optional<Pays> getById(Long id) throws TechniqueException {

		PreparedStatement preparedStatement;
		ResultSet rs;
		Pays p = null;
		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(this.SELECT_QUERY);
				preparedStatement.setLong(1, id);
				rs = preparedStatement.executeQuery();
				rs.next();
				p = new Pays(rs.getLong("ID_PAYS"), rs.getString("NOM"), null);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new TechniqueException("getByID Not working SQLException", e);
			}

		}
		return Optional.ofNullable(p);
	}

	@Override
	public void delete(Pays model) throws TechniqueException {
	}

}
