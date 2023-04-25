package com.iris.newjoiner.repository;

import com.iris.newjoiner.model.NewJoiners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewJoinerRepository extends JpaRepository<NewJoiners, Integer> {
}
