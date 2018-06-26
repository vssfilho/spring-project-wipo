package com.java.rest.resources.wipo;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.java.wipo.model.dto.PatenteDto;
import com.java.wipo.service.PatenteService;
import com.java.wipo.util.ResponseBuilder;

@RestController
@RequestMapping("/patente")
public class PatenteScopeResources {

	PatenteService service = new PatenteService();

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/carregar/{nuPatente}", method = RequestMethod.GET)
	public @ResponseBody ResponseBuilder carregar(@PathVariable String nuPatente) {
		PatenteDto patente = service.carregarPatente(nuPatente);
		if (patente != null) {
			return ResponseBuilder.builder().setSuccess().setData(patente).build();
		} else {
			return ResponseBuilder.builder().setError().setMessages("Erro ao tentar carregar a patente.").build();
		}
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/salvar", method = RequestMethod.POST)
	public @ResponseBody ResponseBuilder adicionar(@RequestBody PatenteDto patente) {
		if (service.salvar(patente)) {
			return ResponseBuilder.builder().setSuccess().setMessages("Patente salva com sucesso.").build();
		} else {
			return ResponseBuilder.builder().setError().setMessages("Erro ao tentar salvar a patente.").build();
		}
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/buscar", method = RequestMethod.GET)
	public @ResponseBody ResponseBuilder buscar(
			@RequestParam(value = "nro_publicacao", required = false) String nroPublicacao,
			@RequestParam(value = "no_requerente", required = false) String noRequerente) {
		List<PatenteDto> listPatente = service.buscar(nroPublicacao, noRequerente);
		if (listPatente != null && listPatente.size() > 0) {
			return ResponseBuilder.builder().setSuccess().setData(listPatente).build();
		} else {
			return ResponseBuilder.builder().setError().setMessages("Não foi encontrado patente.").build();
		}
	}

}
