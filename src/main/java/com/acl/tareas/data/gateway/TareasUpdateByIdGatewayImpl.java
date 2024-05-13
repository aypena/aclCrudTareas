package com.acl.tareas.data.gateway;

import com.acl.tareas.data.model.TareasEntity;
import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.domain.model.TareasDTO;
import com.acl.tareas.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
@Service
@AllArgsConstructor
public class TareasUpdateByIdGatewayImpl implements  TareasUpdateById{

    private final TareasRepository tareasRepository;
    @Override
    public ResponseDto modifyNewsById(Integer id, TareasDTO tareasDTO) {
        try {


            if (tareasRepository.findById(id).isEmpty() ){
                return new ResponseDto(Constants.ERROR_CODE, Constants.NOT_FOUND_ERROR_MESSAGE);
            }else {
                TareasEntity findTareaById = tareasRepository.findById(id).get();
                findTareaById.setDescripcion(tareasDTO.getDescripcion());
                findTareaById.setFechaCreacion(tareasDTO.getFechaCreacion());
                findTareaById.setVigente(tareasDTO.isVigente());
                tareasRepository.save(findTareaById);
                return new ResponseDto(Constants.SUCCESS_CODE, Constants.UPDATE_MESSAGE);
            }



        }
        catch (NoSuchElementException exception){
            throw exception;
        }
    }
}
