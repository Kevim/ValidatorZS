package br.com.santander.zurich.previdencia.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import br.com.santander.zurich.previdencia.exception.ApplicationException;
import br.com.santander.zurich.previdencia.util.StringUtils;
import br.com.santander.zurich.previdencia.util.VariaveisAmbienteUtil;

@Configuration
public class OracleSettings {
	
	@Autowired
	private OracleProperties oracleProperties;
	
	public String getUrl() {
		String url = VariaveisAmbienteUtil.getValor(oracleProperties.getUrl());
		if(StringUtils.isBlank(url)){
			throw new ApplicationException("Não encontrada a url do banco de dados nas variavéis de ambiente");
		}
		
		return url;
	}

	public String getSenha() {
		String senha = oracleProperties.getSenha();
		if(StringUtils.isBlank(senha)){
			throw new ApplicationException("Não encontrada a senha do banco de dados nas variavéis de ambiente");
		}
		
		File arquivoSenha = getFile(senha);
		
		if(!arquivoSenha.exists()){
			throw new ApplicationException("Arquivo de configuração de senha não encontrado");
		}

		return convertFileToString(arquivoSenha);
	}

	public String getUsuario() {
		String usuario = oracleProperties.getUsuario();
		
		if(StringUtils.isBlank(usuario)){
			throw new ApplicationException("Não encontrado o usuário do banco de dados nas variavéis de ambiente");
		}
		
		File arquivoUsuario = getFile(usuario);
		
		if(!arquivoUsuario.exists()){
			throw new ApplicationException("Arquivo de configuração de usuário não encontrado");
		}

		return convertFileToString(arquivoUsuario);
	}

	
	public String getDiretorioCredenciais() {
		String diretorioCredenciais = oracleProperties.getDiretorioCredenciais();
		if(StringUtils.isBlank(diretorioCredenciais)){
			throw new ApplicationException("Não encontrado o diretório de credenciais nas variavéis de ambiente");
		}
		
		File diretorio = new File(diretorioCredenciais);
		
		if(!diretorio.isDirectory()){
			throw new ApplicationException("O Diretório "+ diretorioCredenciais +" não existe");
		}
		return diretorioCredenciais;
	}
	
	private String convertFileToString(File file){
		if(file == null){
			return null;
		}
		try {
			return Files.lines(file.toPath()).collect(Collectors.joining());
		} catch (IOException e) {
			throw new ApplicationException("Falha ao abrir arquivo " +file.getAbsolutePath(),e);
		}
	}
	
	private File getFile(String nomeArquivo){
		return new File(getDiretorioCredenciais()+ File.separator + nomeArquivo );
	}
	
}
