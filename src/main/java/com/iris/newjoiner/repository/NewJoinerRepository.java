package com.iris.newjoiner.repository;

import com.iris.newjoiner.model.NewJoiner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewJoinerRepository extends JpaRepository<NewJoiner, Integer> {
}
