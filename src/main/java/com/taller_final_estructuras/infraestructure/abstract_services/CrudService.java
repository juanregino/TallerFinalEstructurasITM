package com.taller_final_estructuras.infraestructure.abstract_services;

import java.util.List;
//RQ = Request, RS = Response, RSMD = Response Modified, ID = ID
public interface CrudService < RQ , RS ,RSMD , ID>{
   
    RS create(RQ rq);

    RS update(RQ rq , ID id);

    void delete(ID id);

    RSMD findById(ID id); 

    List<RSMD> findAll();
}
