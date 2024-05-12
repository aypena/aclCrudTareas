package com.acl.tareas.presentacion.controller;

import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import com.acl.tareas.domain.usecase.TareaSaveUseCase;
import com.acl.tareas.domain.usecase.TareasDeleteByIdUseCase;
import com.acl.tareas.domain.usecase.TareasFindAllUseCase;
import com.acl.tareas.domain.usecase.TareasUpdateByIdUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TareasControllerTest {

    @Mock
    private TareaSaveUseCase tareaSaveUseCase;

    @Mock
    private  TareasUpdateByIdUseCase tareasUpdateByIdUseCase;
    @Mock
    private  TareasDeleteByIdUseCase tareasDeleteByIdUseCase;
    @Mock
    private  TareasFindAllUseCase tareasFindAllUseCase;

    private  TareasController tareasController;
    @BeforeEach
    void init (){
        tareasController = new TareasController(
                tareaSaveUseCase,
                tareasUpdateByIdUseCase,
                tareasDeleteByIdUseCase,
                tareasFindAllUseCase);
    }

    @Test
    void test_tarea_nueva() throws ParseException {
        TareasDTO tareasDTO = new TareasDTO();
        ResponseDto responseDto  = new ResponseDto ("01", "Guardada");
        when(tareaSaveUseCase.excecute(tareasDTO)).thenReturn(responseDto);

        ResponseEntity responseEntity=tareasController.saveTarea(tareasDTO);

        ResponseDto  responseBody = (ResponseDto) responseEntity.getBody();
        Assertions.assertNotNull(responseEntity);
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        Assertions.assertEquals(responseBody.getCode(), responseDto.getCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());

    }


    @Test
    void test_buscar_todas_tarea() throws ParseException {
        TareasDTO responseDTO = new TareasDTO(1,"Pintar la Casa",new Date(),false);
        List<TareasDTO> listResponse = new ArrayList<TareasDTO>();
        listResponse.add(responseDTO);

        when(tareasFindAllUseCase.findAlltareas()).thenReturn(listResponse);

        ResponseEntity response = tareasController.findAllTarea();

        List<TareasDTO> responseBody = (List<TareasDTO>) response.getBody();

        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.size(), listResponse.size());


    }

    @Test
    void test_tarea_eliminar () {
        ResponseDto responseDto = new ResponseDto("01", "deleted");
        when(tareasDeleteByIdUseCase.deleteTareaById(1)).thenReturn(responseDto);

        ResponseEntity response = tareasController.deleteTareaById(1);

        ResponseDto responseBody = (ResponseDto) response.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.getCode(), responseDto.getCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());
    }

    @Test
    void test_news_update () {
        TareasDTO request = new TareasDTO();
        ResponseDto responseDto = new ResponseDto("01", "updated");
        when(tareasUpdateByIdUseCase.modifyTarea(1, request)).thenReturn(responseDto);

        ResponseEntity response = tareasController.modifyTareaById(1, request);

        ResponseDto responseBody = (ResponseDto) response.getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(responseBody.getCode(), responseDto.getCode());
        Assertions.assertEquals(responseBody.getDescription(), responseDto.getDescription());
    }


}
