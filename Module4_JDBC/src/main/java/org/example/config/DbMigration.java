/**
 * JavaDeveloper3. Module 4. JDBC
 *
 * @autor Valentin Mozul
 * @version of 10.11.2021
 */

package org.example.config;

import org.flywaydb.core.Flyway;

public class DbMigration {

    public static void migrate() {
        Flyway flyway = Flyway.configure()
                .dataSource(DataSourceHolder.getDataSource())
                .load();
        flyway.migrate();
    }
}
