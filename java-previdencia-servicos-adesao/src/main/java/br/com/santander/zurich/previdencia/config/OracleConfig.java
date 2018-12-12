package br.com.santander.zurich.previdencia.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import br.com.santander.zurich.previdencia.exception.ApplicationException;

/**
 * Classe responsável pela criação do datasource com a base Oracle da previdência.
 * 
 * @author Andre Dornelas
 */
@Configuration
public class OracleConfig {

    @Autowired
	public OracleSettings oracleSettings;    

    @Bean(name = "oracleDataSource")
	@Primary
	@ConfigurationProperties("spring.oracle.config.db")
    public DataSource dataSource() {
    	
    	try {
    		
    		BasicDataSource dataSource = new BasicDataSource();

			dataSource.setUsername(oracleSettings.getUsuario());
			dataSource.setPassword(oracleSettings.getSenha());
			dataSource.setUrl(oracleSettings.getUrl());

			return dataSource;
			
		} catch (Exception e) {
			throw new ApplicationException("Falha ao criar DataSource Oracle: ", e);
		}
    }
    
}