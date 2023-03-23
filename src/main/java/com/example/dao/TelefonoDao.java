package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Estudiante;
import com.example.entities.Telefono;

public interface TelefonoDao extends JpaRepository<Telefono, Integer>{
    


    long deleteByEstudiante(Estudiante estudiante);

    /**Si necesitara un método que borrara teléfonos por el id del estudiante lo haría asi:
     * @Query(value = "delete from telefonos where estudiante_id = :idEstudiante", nativeQuery = true)
     * long deleteByIdEstudiante(@Param("idEstudiante") Integer idEstudiante);
     */
    

     /**Para encontrar una lista de teléfonos a partir de un estudiante concreto se utiliza la 
      * consulta siguiente:
      */
     //List<Telefono> findByEstudiante(Estudiante estudiante);
}
