package br.com.santander.zurich.previdencia.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:database.properties")
@ConfigurationProperties(prefix="database.oracle.config.pool")
public class OracleProperties {

private String url;
	
	private String senha;
	
	private String usuario;
	
	private String diretorioCredenciais;

	public String getUrl() {
		return url;
	}

	public String getSenha() {
		return senha;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getDiretorioCredenciais() {
		return diretorioCredenciais;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public void setDiretorioCredenciais(String diretorioCredenciais) {
		this.diretorioCredenciais = diretorioCredenciais;
	}
}
