package com.ashok.it.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashok.it.Entities.PlanMaster;

@Repository
public interface IPlanMaster extends JpaRepository<PlanMaster, Integer>{

}
