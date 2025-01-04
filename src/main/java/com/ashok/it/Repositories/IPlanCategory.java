package com.ashok.it.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ashok.it.Entities.PlanCategory;

@Repository
public interface IPlanCategory extends JpaRepository<PlanCategory, Integer>{
	
	

}
