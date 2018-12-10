package br.com.santander.zurich.previdencia;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.santander.zurich.previdencia.enums.SexoEnum;
import br.com.santander.zurich.previdencia.resource.BeneficiarioResource;
import br.com.santander.zurich.previdencia.resource.PropostaAdesaoResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaPrevidenciaServicosAdesaoApplicationTests {

	@Test
	public void contextLoads() throws JsonProcessingException {
		
		PropostaAdesaoResource a = new PropostaAdesaoResource();
		a.setBeneficiarios(new ArrayList<BeneficiarioResource>());
		
		BeneficiarioResource b = new BeneficiarioResource();
		b.setCpf(123L);
		b.setDataNascimento(new Date());
		b.setGenero(SexoEnum.FEMININO);
		b.setGrauParentesco(1);
		b.setNomeCompleto("ZE BENEFICIARIO DA SILVA");
		b.setPercentualAcumulacao(BigDecimal.valueOf(100));
		
		a.getBeneficiarios().add(b);
		
		ObjectMapper mapper = new ObjectMapper();
		
		System.out.println(mapper.writeValueAsString(a));
	}

}
