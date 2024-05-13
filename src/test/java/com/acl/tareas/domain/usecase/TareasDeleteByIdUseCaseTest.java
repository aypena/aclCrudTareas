package com.acl.tareas.domain.usecase;

import com.acl.tareas.data.gateway.TareasDeleteById;
import com.acl.tareas.domain.model.ResponseDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TareasDeleteByIdUseCaseTest {

    @Mock
    private TareasDeleteById tareasDeleteById;
    private TareasDeleteByIdUseCase tareasDeleteByIdUseCase;


    @BeforeEach
    void init (){
        tareasDeleteByIdUseCase = new TareasDeleteByIdUseCase(tareasDeleteById);
    }

    @Test
    void when_use_case_delete_tarea_is_called_then_new_deleted() {
        ResponseDto responseDto  = new ResponseDto ("01", "deleted");

        when(tareasDeleteById.deleteNewsById(1)).thenReturn(responseDto);
        ResponseDto response = tareasDeleteByIdUseCase.deleteTareaById(1);

        Assertions.assertNotNull(response);
        Assertions.assertEquals(response.getCode(), responseDto.getCode());
        Assertions.assertEquals(response.getDescription(), responseDto.getDescription());
    }
}
