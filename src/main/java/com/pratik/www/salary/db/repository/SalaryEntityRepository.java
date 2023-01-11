package com.pratik.www.salary.db.repository;

import com.pratik.www.salary.db.entity.SalaryEntity;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryEntityRepository extends CouchbaseRepository<SalaryEntity,String> {
}
