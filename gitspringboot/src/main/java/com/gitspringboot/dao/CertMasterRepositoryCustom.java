package com.gitspringboot.dao;


import java.util.List;

import com.gitspringboot.model.CertMaster;

public interface CertMasterRepositoryCustom {
	
	public List<CertMaster> searchCertViaProcedure(String s1, String d1, String d2) ;
	public List<CertMaster> getAllCertViaProcedure() ;

}
