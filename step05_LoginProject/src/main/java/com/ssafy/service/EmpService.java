package com.ssafy.service;

import java.util.List;

import com.ssafy.dto.EmpDTO;

public interface EmpService {
	public int insertEmp(EmpDTO emp);
	public List<EmpDTO> listEmp();
	public int updateEmp(EmpDTO emp);
	public int deleteEmp(EmpDTO emp);
	
}
