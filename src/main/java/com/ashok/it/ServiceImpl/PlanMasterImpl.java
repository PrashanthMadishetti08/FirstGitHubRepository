package com.ashok.it.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.it.Entities.PlanCategory;
import com.ashok.it.Entities.PlanMaster;
import com.ashok.it.Repositories.IPlanCategory;
import com.ashok.it.Repositories.IPlanMaster;
import com.ashok.it.Service.IPlanMasterService;

@Service
public class PlanMasterImpl implements IPlanMasterService {

	@Autowired
	private IPlanCategory planCategory;

	@Autowired
	private IPlanMaster planMaster;

	@Override
	public Map<Integer, String> getPlanCategories() {
		Map<Integer, String> getPlanCategoriesDropDown = new HashMap<>();
		List<PlanCategory> findAll = planCategory.findAll();
		findAll.forEach(n -> {
			getPlanCategoriesDropDown.put(n.getCategoryId(), n.getCategoryName());
		});
		return getPlanCategoriesDropDown;
	}

	@Override
	public Boolean savePlan(PlanMaster plan) {
		PlanMaster save = planMaster.save(plan);
		return save.getPlanId() != null;
	}

	@Override
	public List<PlanMaster> getAllPlans() {
		List<PlanMaster> findAll = planMaster.findAll();
		return findAll;
	}

	@Override
	public PlanMaster getById(Integer planId) {
		Optional<PlanMaster> findById = planMaster.findById(planId);
		if (findById.isPresent()) {
			return findById.get();
		} else {
			return null;
		}
	}

	@Override
	public Boolean updatePlan(PlanMaster plan) {
		PlanMaster save = planMaster.save(plan);
		return plan.getPlanId() != null;
	}

	@Override
	public Boolean deletePlanById(Integer plandId) {
		boolean status = false;
		try {
			planMaster.deleteById(plandId);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Boolean ChangeStatus(Integer planId, String status) {
		Boolean flag = false;
		Optional<PlanMaster> findById = planMaster.findById(planId);
		if (findById.isPresent()) {
			PlanMaster planMaster2 = findById.get();
			planMaster2.setActiveSwitch(status);
			planMaster.save(planMaster2);
			flag = true;
		}
		return flag;

	}

}
