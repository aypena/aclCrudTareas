package com.acl.tareas.data.gateway;


import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TareasDeleteByIdGatewayImplTest {

    @Mock
    private TareasRepository tareasRepository;
    private TareasDeleteByIdGatewayImpl tareasDeleteByIdGateway;

    @BeforeEach
    void init (){
        tareasDeleteByIdGateway = new TareasDeleteByIdGatewayImpl(tareasRepository);
    }

    @Test
    void when_gateway_delete_tarea_is_no_find_then_tarea_No_deleted(){
        ResponseDto responseDto  = new ResponseDto ("02", "Tarea no encontrada");

        ResponseDto response = tareasDeleteByIdGateway.deleteNewsById(19);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }




}
