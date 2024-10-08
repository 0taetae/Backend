package com.ssafy.service;

import java.util.List;

import com.ssafy.dao.EmpDaoImpl;
import com.ssafy.dto.EmpDTO;

public class EmpServiceImpl implements EmpService{
	
	public static EmpServiceImpl empService;
	
	public static EmpService getEmpService() {
		if(empService==null) {
			empService = new EmpServiceImpl();
		}
		return empService;
	}

	@Override
	public int insertEmp(EmpDTO emp) {
		return EmpDaoImpl.getEmpDao().insertEmp(emp);
	}

	@Override
	public List<EmpDTO> listEmp() {
		return EmpDaoImpl.getEmpDao().listEmp();
	}

	@Override
	public int updateEmp(EmpDTO emp) {
		return EmpDaoImpl.getEmpDao().updateEmp(emp);
	}

	@Override
	public int deleteEmp(EmpDTO emp) {
		return EmpDaoImpl.getEmpDao().deleteEmp(emp);
	}

	

}
