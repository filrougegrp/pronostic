package org.sinaf.tpFileRouge.dao.pronostic.impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sinaf.tpFileRouge.dao.ConnexionManager;
import org.sinaf.tpFileRouge.dao.pronostic.PronosticDAO;
import org.sinaf.tpFileRouge.dao.rencontre.RencontreDAO;
import org.sinaf.tpFileRouge.dao.rencontre.impl.RencontreDAOImpl;
import org.sinaf.tpFileRouge.dao.salarie.SalarieDao;
import org.sinaf.tpFileRouge.dao.salarie.impl.SalarieDAOImpl;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Pronostic;

public class PronosticDAOImpl implements PronosticDAO {

	private final String INSERT_QUERY = "INSERT INTO PRONOSTIC (`BUT_1`, `BUT_2`, `NOTE`, `ID_RENCONTRE`, `ID_SALARIE`) VALUES(?,?,?,?,?)";
	private final String SELECT_ALL_BY_SALARIE_QUERY = "SELECT * FROM PRONOSTIC WHERE ID_SALARIE = ?";

	private RencontreDAO rencontreDAO;
	private SalarieDao salarieDao;

	private Connection con;

	public PronosticDAOImpl() throws TechniqueException {
		try {
			this.rencontreDAO = new RencontreDAOImpl();
			this.salarieDao = new SalarieDAOImpl();

			this.con = ConnexionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public PronosticDAOImpl(Connection connection) {
		this.rencontreDAO = new RencontreDAOImpl(connection);
		this.salarieDao = new SalarieDAOImpl(connection);

		this.con = connection;
	}

	@Override
	public int create(Pronostic model) throws TechniqueException {
		PreparedStatement preparedStatement;
		int rs = 0;
		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(this.INSERT_QUERY);
				preparedStatement.setInt(1, model.getBut_1());
				preparedStatement.setInt(2, model.getBut_2());
				preparedStatement.setLong(3, model.getNote());
				preparedStatement.setLong(4, model.getRencontre().getId());
				preparedStatement.setLong(5, model.getSalarie().getId());
				rs = preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return rs;
	}

	@Override
	public void update(Pronostic model) throws TechniqueException {

	}

	@Override
	public Optional<Pronostic> getById(Long id) {
		return null;
	}

	@Override
	public void delete(Pronostic model) throws TechniqueException {

	}

	@Override
	public List<Pronostic> getAllPronosticsBySalarieId(Long id) throws TechniqueException {

		PreparedStatement preparedStatement;
		ResultSet rs;

		List<Pronostic> pronostics = new ArrayList<>();
		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(this.SELECT_ALL_BY_SALARIE_QUERY);
				preparedStatement.setLong(1, id);
				rs = preparedStatement.executeQuery();

				while (rs.next()) {
					pronostics.add(new Pronostic(rs.getLong("ID_PRONOSTIC"), rs.getInt("BUT_1"), rs.getInt("BUT_2"),
							rs.getInt("NOTE"), this.rencontreDAO.getById(rs.getLong("ID_RENCONTRE")).get(),
							this.salarieDao.getById(rs.getLong("ID_SALARIE")).get()));

				}

			} catch (SQLException e) {
				throw new TechniqueException("getAll Not working SQLException", e);
			}

		}
		return pronostics;

	}

}
