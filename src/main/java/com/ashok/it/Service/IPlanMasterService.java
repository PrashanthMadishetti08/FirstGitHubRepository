package com.ashok.it.Service;

import java.util.List;
import java.util.Map;

import com.ashok.it.Entities.PlanMaster;

public interface IPlanMasterService {
	
	public Map<Integer, String> getPlanCategories();
	public Boolean savePlan(PlanMaster plan);
	public List<PlanMaster> getAllPlans();
	public PlanMaster getById(Integer planId);
	public Boolean updatePlan(PlanMaster plan);
	public Boolean deletePlanById(Integer plandId);
	public Boolean ChangeStatus(Integer planId, String status);
	
}
