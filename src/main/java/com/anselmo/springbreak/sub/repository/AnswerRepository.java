package com.anselmo.springbreak.sub.repository;

import com.anselmo.springbreak.sub.entity.SubAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<SubAnswerEntity,Integer> {

}
