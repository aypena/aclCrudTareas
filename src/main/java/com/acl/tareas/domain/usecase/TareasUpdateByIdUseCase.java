package com.acl.tareas.domain.usecase;

import com.acl.tareas.data.gateway.TareasUpdateById;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import org.springframework.stereotype.Service;

@Service
public class TareasUpdateByIdUseCase {

    private final TareasUpdateById tareasUpdateById;


    public TareasUpdateByIdUseCase(TareasUpdateById tareasUpdateById) {
        this.tareasUpdateById = tareasUpdateById;
    }
    public ResponseDto modifyTarea(Integer id, TareasDTO tareasDTO){
        return tareasUpdateById.modifyNewsById( id, tareasDTO );
    }

}
