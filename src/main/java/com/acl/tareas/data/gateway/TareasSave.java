package com.acl.tareas.data.gateway;

import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;

public interface TareasSave {

    ResponseDto saveTarea(TareasDTO tareasDTO);

}
