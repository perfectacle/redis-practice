package com.practice.redis.domain.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by kwonsungyang on 25/06/2018
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
}
