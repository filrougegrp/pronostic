package org.sinaf.tpFileRouge;

import java.sql.SQLException;

import org.dbunit.DatabaseUnitException;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class DBUnitSalarieTest extends APronosticTest {
	DBUnitSalarieTest dbUnitTest;
	
	@Before
	public void setup() {
		this.dbUnitTest = new DBUnitSalarieTest();
	}
	
	public void insertTest() {
		try {
			DatabaseOperation.CLEAN_INSERT.execute(dbUnitConnection, dataSet);
		} catch (DatabaseUnitException | SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void updateTest() {
		try {
			DatabaseOperation.UPDATE.execute(dbUnitConnection, dataSet);
		} catch (DatabaseUnitException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTest() {
		try {
			DatabaseOperation.DELETE.execute(dbUnitConnection, dataSet);
		} catch (DatabaseUnitException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void shouldreturnXXX() {

		try {
			DBUnitSalarieTest dbUnitTest = new DBUnitSalarieTest();
			dbUnitTest.insertTest();
			// dbUnitTest.updateTest();
			// dbUnitTest.deleteTest();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
