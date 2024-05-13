package com.acl.tareas.data.gateway;

import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

//@ExtendWith(MockitoExtension.class)
public class TareasFindAllGatewayImplTest {

    @Mock
    private TareasRepository tareasRepository;
    private TareasFindAllGatewayImpl tareasFindAllGateway;


    @BeforeEach
    void init (){
        //tareasFindAllGateway = new TareasFindAllGatewayImpl(tareasRepository);
    }


    void when_gateway_findAll_tarea_is_no_find_then_tarea_No_deleted(){
      //  ResponseDto responseDto  = new ResponseDto ("02", "Tarea no encontrada");

        List<TareasDTO> emptyList = new ArrayList<>();

        List<TareasDTO> response = tareasFindAllGateway.findTareasAll();
        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.isEmpty());
    }



}
