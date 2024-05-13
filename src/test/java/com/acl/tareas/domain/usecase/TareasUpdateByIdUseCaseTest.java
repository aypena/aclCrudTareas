package com.acl.tareas.domain.usecase;


import com.acl.tareas.data.gateway.TareasUpdateById;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TareasUpdateByIdUseCaseTest {

    @Mock
    private TareasUpdateById tareasUpdateById;
    private TareasUpdateByIdUseCase tareasUpdateByIdUseCase;


    @BeforeEach
    void init (){
        tareasUpdateByIdUseCase = new TareasUpdateByIdUseCase(tareasUpdateById);
    }

    @Test
    void when_use_case_update_featured_is_called_then_new_updated(){
        ResponseDto responseDto  = new ResponseDto ("01", "updated");
        TareasDTO requestDto= new TareasDTO();

        when(tareasUpdateById.modifyNewsById(1,requestDto)).thenReturn(responseDto);
        ResponseDto response = tareasUpdateByIdUseCase.modifyTarea(1,requestDto);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }



}
