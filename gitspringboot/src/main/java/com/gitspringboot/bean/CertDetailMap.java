package com.gitspringboot.bean;

import java.util.List;
import java.util.Map;

import com.gitspringboot.model.CertMaster;

public class CertDetailMap {
	
	
	
	private Map<String,String> mapCertStatuslist;
	
	private Map<String,List<CertMaster>> mapCertlist;

	

	public Map<String, List<CertMaster>> getMapCertlist() {
		return mapCertlist;
	}

	public void setMapCertlist(Map<String, List<CertMaster>> mapCertlist) {
		this.mapCertlist = mapCertlist;
	}

	public Map<String, String> getMapCertStatuslist() {
		return mapCertStatuslist;
	}

	public void setMapCertStatuslist(Map<String, String> mapCertStatuslist) {
		this.mapCertStatuslist = mapCertStatuslist;
	}
	
	

}
