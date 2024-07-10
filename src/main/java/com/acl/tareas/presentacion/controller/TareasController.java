package com.acl.tareas.presentacion.controller;


import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import com.acl.tareas.domain.usecase.TareaSaveUseCase;
import com.acl.tareas.domain.usecase.TareasDeleteByIdUseCase;
import com.acl.tareas.domain.usecase.TareasFindAllUseCase;
import com.acl.tareas.domain.usecase.TareasUpdateByIdUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/tareas")

public class TareasController {

    private final TareaSaveUseCase tareaSaveUseCase;
    private final TareasUpdateByIdUseCase tareasUpdateByIdUseCase;
    private final TareasDeleteByIdUseCase tareasDeleteByIdUseCase;
    private final TareasFindAllUseCase tareasFindAllUseCase;

    public TareasController(TareaSaveUseCase tareaSaveUseCase, TareasUpdateByIdUseCase tareasUpdateByIdUseCase, TareasDeleteByIdUseCase tareasDeleteByIdUseCase, TareasFindAllUseCase tareasFindAllUseCase) {
        this.tareaSaveUseCase = tareaSaveUseCase;
        this.tareasUpdateByIdUseCase = tareasUpdateByIdUseCase;
        this.tareasDeleteByIdUseCase = tareasDeleteByIdUseCase;
        this.tareasFindAllUseCase = tareasFindAllUseCase;
    }
    @PostMapping
    public ResponseEntity<ResponseDto> saveTarea(@RequestBody TareasDTO tareasDTO) throws ParseException {
    return  new ResponseEntity<ResponseDto>(tareaSaveUseCase.excecute(tareasDTO), HttpStatus.CREATED);

}
@GetMapping("/all")
public ResponseEntity<ResponseDto> findAllTarea(){
    return  new ResponseEntity (tareasFindAllUseCase.findAlltareas(), HttpStatus.OK);
}
    @DeleteMapping("/{id}")
    public  ResponseEntity deleteTareaById(@PathVariable("id") Integer identificador){
        return new ResponseEntity(tareasDeleteByIdUseCase.deleteTareaById(identificador),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity  modifyTareaById(@PathVariable("id") Integer identificador,@RequestBody TareasDTO tareasDTO){
        return new ResponseEntity(tareasUpdateByIdUseCase.modifyTarea(identificador,tareasDTO),HttpStatus.OK);
    }
}
