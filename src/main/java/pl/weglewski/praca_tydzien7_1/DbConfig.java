package pl.weglewski.praca_tydzien7_1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DbConfig {


    private DataSource dataSource;

    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void init(){
//        String sql = "CREATE TABLE cars(car_id int, mark varchar(255), model varchar(255), color varchar(255), prod_date int, PRIMARY KEY (car_id))";
//        getJdbcTemplate().update(sql);
//    }
}
