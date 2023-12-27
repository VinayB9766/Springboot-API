
package com.logistic.assigment.repository;
import com.logistic.assigment.model.Load;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LoadRepository extends CrudRepository<Load, Long> {
    List<Load> findByShipperId(String shipperId);
}

