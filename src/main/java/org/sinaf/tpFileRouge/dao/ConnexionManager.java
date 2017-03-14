package org.sinaf.tpFileRouge.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

public class ConnexionManager {

	private static final String FICHIER_PROPERTIES = "org/sinaf/tpFileRouge/dao/dao.properties";

	private static ConnexionManager connexionManager;
	private BoneCP connectionPool;

	private ConnexionManager() throws IOException, SQLException, PropertyVetoException {
		Properties properties = new Properties();
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

		InputStream fichierProperties = classLoader.getResourceAsStream(FICHIER_PROPERTIES);

		try {
			properties.load(fichierProperties);
			// load the database driver (make sure this is in your classpath!)

			Class.forName(properties.getProperty("driver"));
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			// setup the connection pool using BoneCP Configuration
			BoneCPConfig config = new BoneCPConfig();
			// jdbc url specific to your database, eg
			// jdbc:mysql://127.0.0.1/yourdb
			config.setJdbcUrl(properties.getProperty("url"));
			config.setUsername(properties.getProperty("username"));
			config.setPassword(properties.getProperty("password"));
			config.setMinConnectionsPerPartition(5);
			config.setMaxConnectionsPerPartition(10);
			config.setPartitionCount(1);
			// setup the connection pool
			this.connectionPool = new BoneCP(config);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

	}

	public static ConnexionManager getInstance() throws IOException, SQLException, PropertyVetoException {
		if (connexionManager == null) {
			connexionManager = new ConnexionManager();
			return connexionManager;
		} else {
			return connexionManager;
		}
	}

	public Connection getConnection() throws SQLException {
		return this.connectionPool.getConnection();
	}

}