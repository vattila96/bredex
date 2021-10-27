package com.attila.varga.BredexInterviewProject.position;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends CrudRepository<PositionEntity, Long> {

}
