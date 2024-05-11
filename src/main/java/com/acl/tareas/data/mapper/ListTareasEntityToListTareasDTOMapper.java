package com.acl.tareas.data.mapper;

import com.acl.tareas.data.model.TareasEntity;
import com.acl.tareas.domain.model.TareasDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ListTareasEntityToListTareasDTOMapper {

    public List<TareasDTO> mapper(List<TareasEntity> tareasEntityList){

        List<TareasDTO> listTareasDto = tareasEntityList.stream().map(entity -> {
            TareasDTO tareasDTO = new TareasDTO();
            tareasDTO.setIdentificador(entity.getIdentificador());
            tareasDTO.setDescripcion(entity.getDescripcion());
            tareasDTO.setFechaCreacion(entity.getFechaCreacion());
            tareasDTO.setVigente(entity.isVigente());
            return tareasDTO;
        }).collect(Collectors.toList());
        return listTareasDto;
    }
}