package com.cg.dao;

import java.sql.SQLException;

import com.cg.model.PolicyDetails;

public interface IReportGenerationDAO 
{
	public PolicyDetails viewDetailedReport(long policyNumber) throws SQLException;
}
