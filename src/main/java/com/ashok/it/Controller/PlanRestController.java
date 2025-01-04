package com.ashok.it.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.it.Entities.PlanMaster;
import com.ashok.it.Service.IPlanMasterService;

@RestController
@RequestMapping("/api/plans")  
public class PlanRestController {

	@Autowired
	private IPlanMasterService service;

	@GetMapping("/categories")  // Clearer naming
	public ResponseEntity<Map<Integer, String>> planCategories() {
		Map<Integer, String> planCategories = service.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> savePlan(@RequestBody PlanMaster plan) {
		Boolean flag = service.savePlan(plan);
		String responseMsg = flag ? "Saved Plan" : "Not Saved Plan";
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public ResponseEntity<List<PlanMaster>> getAllPlans() {
		List<PlanMaster> allPlans = service.getAllPlans();
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}

	@GetMapping("/{planId}")  // Consistent path variable
	public ResponseEntity<PlanMaster> getById(@PathVariable Integer planId) {
		PlanMaster byId = service.getById(planId);
		return new ResponseEntity<>(byId, HttpStatus.OK);
	}

	@PutMapping("/edit/{planId}")  // Correct the path and variable for update
	public ResponseEntity<String> updatePlan(@PathVariable Integer planId, @RequestBody PlanMaster plan) {
		Boolean updatePlan = service.updatePlan(plan);
		String responseMessage = updatePlan ? "Plan Updated" : "Plan Not Updated";
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{planId}")  // Consistent delete path
	public ResponseEntity<String> deleteById(@PathVariable Integer planId) {
		Boolean deletePlanById = service.deletePlanById(planId);
		String responseMessage = deletePlanById ? "Plan Deleted" : "Plan Not Deleted";
		return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	}

	@PutMapping("/status/{planId}/{status}")  // Correct path for status change
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
		Boolean changeStatus = service.ChangeStatus(planId, status);
		String msg = changeStatus ? "Status Changed" : "Status Not Changed";
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}
}
