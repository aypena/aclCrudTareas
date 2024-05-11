package com.acl.tareas.domain.usecase;


import com.acl.tareas.data.gateway.TareasFindAll;
import com.acl.tareas.domain.model.TareasDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasFindAllUseCase {

    private final TareasFindAll tareasFindAll;

    public TareasFindAllUseCase(TareasFindAll tareasFindAll) {
        this.tareasFindAll = tareasFindAll;
    }

    public List<TareasDTO> findAlltareas(){
        return tareasFindAll.findTareasAll();
    }
}
