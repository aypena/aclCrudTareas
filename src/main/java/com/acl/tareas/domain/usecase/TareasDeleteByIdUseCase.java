package com.acl.tareas.domain.usecase;

import com.acl.tareas.data.gateway.TareasDeleteById;
import com.acl.tareas.domain.model.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class TareasDeleteByIdUseCase {

    private final TareasDeleteById tareasDeleteById;

    public TareasDeleteByIdUseCase(TareasDeleteById tareasDeleteById) {
        this.tareasDeleteById = tareasDeleteById;
    }

    public ResponseDto deleteTareaById (Integer id){
        return tareasDeleteById.deleteNewsById(id);
    }
}
