package com.acl.tareas.data.repository;

import com.acl.tareas.data.model.TareasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(path ="TareasEntity", collectionResourceRel ="TareasEntity" )
public interface TareasRepository extends JpaRepository<TareasEntity,Integer> {
}
