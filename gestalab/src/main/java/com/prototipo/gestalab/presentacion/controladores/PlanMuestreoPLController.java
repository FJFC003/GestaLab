package com.prototipo.gestalab.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prototipo.gestalab.aplicacion.casosuso.entrada.IPlanMuestreoPLUseCase;
import com.prototipo.gestalab.presentacion.dto.request.PlanMuestreoPLRequestDto;
import com.prototipo.gestalab.presentacion.dto.response.PlanMuestreoPLResponseDto;
import com.prototipo.gestalab.presentacion.mapeadores.IPlanMuestreoPLDtoMapper;

import jakarta.validation.Valid;

@RequestMapping("/api/gestalab/plan-muestreo-pl")
@RestController
public class PlanMuestreoPLController {
	
	private final IPlanMuestreoPLUseCase planMuestreoPLUseCase;
	private final IPlanMuestreoPLDtoMapper mapper;
	public PlanMuestreoPLController(IPlanMuestreoPLUseCase planMuestreoPLUseCase, IPlanMuestreoPLDtoMapper mapper) {
		super();
		this.planMuestreoPLUseCase = planMuestreoPLUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PlanMuestreoPLResponseDto guardar(@Valid @RequestBody PlanMuestreoPLRequestDto requestPlan) {
		return mapper.toResponseDto(planMuestreoPLUseCase.guardar(mapper.toDomain(requestPlan)));
	}
	
	@GetMapping
	public List<PlanMuestreoPLResponseDto> listarTodos(){
		return planMuestreoPLUseCase.ListarTodos().stream().map(mapper :: toResponseDto).toList();
	}
	
	@DeleteMapping("/{idPlan}")
	public ResponseEntity<Void> eliminar (@PathVariable int idPlan)
	{
		planMuestreoPLUseCase.eliminar(idPlan);
		return ResponseEntity.noContent().build();
	}

}
