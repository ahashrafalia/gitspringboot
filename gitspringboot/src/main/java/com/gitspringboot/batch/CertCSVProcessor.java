package com.gitspringboot.batch;

import org.springframework.batch.item.ItemProcessor;

public class CertCSVProcessor implements ItemProcessor<CertCsv, CertCsv> {

	@Override
	public CertCsv process(CertCsv certCSV) throws Exception {
		//System.out.println(certCSV);
		return certCSV;
	}

}
