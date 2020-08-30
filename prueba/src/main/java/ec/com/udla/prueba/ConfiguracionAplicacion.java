package ec.com.udla.prueba;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
@EnableJpaRepositories("ec.com.udla.prueba.repositorio")
@EntityScan("ec.com.udla.prueba.entidades")
public class ConfiguracionAplicacion {
	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		builder.setType(EmbeddedDatabaseType.H2).
		addScript("META-INF/sql/schema.sql")
		.addScript("META-INF/sql/data.sql");
		return builder.build();		
	}

}
