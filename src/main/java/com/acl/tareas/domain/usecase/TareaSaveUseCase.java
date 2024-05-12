package com.acl.tareas.domain.usecase;


import com.acl.tareas.data.gateway.TareasSave;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;


@Service
public class TareaSaveUseCase {

    private final TareasSave tareasSave;

    public TareaSaveUseCase(TareasSave tareasSave) {
        this.tareasSave = tareasSave;
    }


    public ResponseDto excecute(TareasDTO tareasDTO) throws ParseException {

        return  tareasSave.saveTarea(tareasDTO);
    }
}
