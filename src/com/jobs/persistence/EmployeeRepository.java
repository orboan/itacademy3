package com.jobs.persistence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jobs.domain.AbsStaffMember;

public class EmployeeRepository {

	//Per a guardar els empleats i voluntaris (Staff Members)
	private static List<AbsStaffMember> members=new ArrayList<>();
	
	//Per a guardar els payment rates de cada tipus d'empleat
	private static Map<EmployeeType, Double> rates = new HashMap<>();
	
	public EmployeeRepository(){
		
	}
	
	public List<AbsStaffMember> getAllMembers(){
		//retorna una còpia
		//així evitem modificacions no desitjades a l'original
		return new ArrayList<>(members);
	}
	
	//Afegim staff members a la "base de dades" (list)
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
	public Map<EmployeeType, Double> getRates(){
		//retorna una còpia
		//així evitem modificacions no desitjades a l'original
		return new HashMap<>(rates);
	}
	
	//Guardem a la "base de dades" (map) els payment rates
	//de cada tipus d'empleat
	public void assignRate(EmployeeType type, double rate) {
		rates.put(type, rate);
	}
	
	//tipus d'empleat segons payment rate
	public static enum EmployeeType {
		BOSS, MANAGER, EMPLOYEE, JUNIOR, MID, SENIOR
	}
}
