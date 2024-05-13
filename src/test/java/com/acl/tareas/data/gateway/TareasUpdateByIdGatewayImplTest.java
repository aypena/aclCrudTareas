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

@ExtendWith(MockitoExtension.class)
public class TareasUpdateByIdGatewayImplTest {

    @Mock
    private TareasRepository tareasRepository;
    private TareasUpdateByIdGatewayImpl tareasUpdateByIdGateway;

    @BeforeEach
    void init (){
        tareasUpdateByIdGateway = new TareasUpdateByIdGatewayImpl(tareasRepository);
    }

    @Test
    void when_gateway_delete_tarea_is_no_find_then_tarea_No_deleted(){
        ResponseDto responseDto  = new ResponseDto ("02", "Tarea no encontrada");
        TareasDTO tareasDTO = new TareasDTO();

        ResponseDto response = tareasUpdateByIdGateway.modifyNewsById(19,tareasDTO);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }



}
