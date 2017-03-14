package org.sinaf.tpFileRouge.dao.rencontre.impl;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.sinaf.tpFileRouge.dao.ConnexionManager;
import org.sinaf.tpFileRouge.dao.pays.PaysDAO;
import org.sinaf.tpFileRouge.dao.pays.impl.PaysDAOImpl;
import org.sinaf.tpFileRouge.dao.rencontre.RencontreDAO;
import org.sinaf.tpFileRouge.exception.TechniqueException;
import org.sinaf.tpFileRouge.model.Rencontre;

public class RencontreDAOImpl implements RencontreDAO {

	private final String SELECT_QUERY = "SELECT * FROM RENCONTRE WHERE ID_RENCONTRE = ?";
	private final String SELECT_ALL_QUERY = "SELECT * FROM RENCONTRE";

	private PaysDAO paysDAO;

	private Connection con;

	public RencontreDAOImpl() throws TechniqueException {

		try {
			this.paysDAO = new PaysDAOImpl();
			this.con = ConnexionManager.getInstance().getConnection();
		} catch (SQLException | IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}

	public RencontreDAOImpl(Connection connection) {
		this.paysDAO = new PaysDAOImpl(connection);

		this.con = connection;
	}

	@Override
	public int create(Rencontre model) throws TechniqueException {
		return 0;
	}

	@Override
	public void update(Rencontre model) throws TechniqueException {

	}

	@Override
	public Optional<Rencontre> getById(Long id) throws TechniqueException {

		PreparedStatement preparedStatement;
		ResultSet rs;
		Rencontre rencontre = null;
		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(this.SELECT_QUERY);
				preparedStatement.setLong(1, id);
				rs = preparedStatement.executeQuery();
				rs.next();
				rencontre = new Rencontre(rs.getLong(1), this.paysDAO.getById(rs.getLong(5)).get(),
						this.paysDAO.getById(rs.getLong(6)).get(), rs.getInt(3), rs.getInt(4), null,
						LocalDateTime.now());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new TechniqueException("getByID Not working SQLException", e);
			}

		}
		return Optional.ofNullable(rencontre);
	}

	@Override
	public void delete(Rencontre model) throws TechniqueException {
	}

	@Override
	public List<Rencontre> getAll() throws TechniqueException {
		PreparedStatement preparedStatement;
		ResultSet rs;

		List<Rencontre> rencontres = new ArrayList<>();
		if (this.con != null) {
			try {
				preparedStatement = this.con.prepareStatement(this.SELECT_ALL_QUERY);
				rs = preparedStatement.executeQuery();

				while (rs.next()) {

					rencontres.add(new Rencontre(rs.getLong(1), this.paysDAO.getById(rs.getLong(5)).get(),
							this.paysDAO.getById(rs.getLong(6)).get(), rs.getInt(3), rs.getInt(4), null,
							LocalDateTime.now()));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new TechniqueException("getByID Not working SQLException", e);
			}

		}
		return rencontres;
	}

}
