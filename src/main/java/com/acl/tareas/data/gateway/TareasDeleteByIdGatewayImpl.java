package com.acl.tareas.data.gateway;

import com.acl.tareas.data.repository.TareasRepository;
import com.acl.tareas.domain.model.ResponseDto;
import com.acl.tareas.util.Constants;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TareasDeleteByIdGatewayImpl implements  TareasDeleteById{

    private final TareasRepository tareasRepository;
    @Override
    public ResponseDto deleteNewsById(Integer id) {
        try {
               if (tareasRepository.findById(id).isEmpty()  ){
                   return new ResponseDto(Constants.ERROR_CODE, Constants.NOT_FOUND_ERROR_MESSAGE);
               }else {
                   tareasRepository.deleteById(id);
                   return new ResponseDto(Constants.SUCCESS_CODE, Constants.DELETE_MESSAGE);
               }


        } catch (Exception e) {

            return new ResponseDto(Constants.NOT_FOUND_ERROR_MESSAGE, Constants.NOT_FOUND_ERROR_MESSAGE);
        }
    }
}
