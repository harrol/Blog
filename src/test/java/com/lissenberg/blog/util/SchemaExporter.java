package com.lissenberg.blog.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.ejb.Ejb3Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

/**
 * Util class to export DDL schema from JPA persistence entities & configuration
 *
 * @author Harro Lissenberg
 */
public class SchemaExporter {

	@Test
	public void createDerbySchema() {
		Configuration cfg = new Ejb3Configuration().configure("in-memory-test-db", null).getHibernateConfiguration();
		new SchemaExport(cfg).setOutputFile("schema-export-derby.sql").create(false, true);
	}

	@Test
	public void createMySqlSchema() {
		Configuration cfg = new Ejb3Configuration().configure("in-memory-test-db", null).getHibernateConfiguration();
		// override the Derby dialect used in tests
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		new SchemaExport(cfg).setOutputFile("schema-export-mysql.sql").create(false, true);
	}

}
