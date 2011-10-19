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


    public static void main(String[] args) {
        SchemaExporter exporter = new SchemaExporter();
        exporter.createDerbySchema();
        exporter.createMySqlSchema();
    }

	private void createDerbySchema() {
		Configuration cfg = new Ejb3Configuration().configure("in-memory-test-db", null).getHibernateConfiguration();
		new SchemaExport(cfg)
				.setOutputFile("schema-export-derby.sql")
				.setDelimiter(";")
				.setFormat(true)
				.create(false, true);
	}

	private void createMySqlSchema() {
		Configuration cfg = new Ejb3Configuration().configure("in-memory-test-db", null).getHibernateConfiguration();
		// override the Derby dialect used in tests
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		new SchemaExport(cfg)
				.setOutputFile("schema-export-mysql.sql")
				.setDelimiter(";")
				.setFormat(true)
				.create(false, true);
	}

}
