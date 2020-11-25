package com.cg.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility 
{
	static Logger plpLogger=null;
	static
	{
		plpLogger = LogManager.getLogger(LoggerUtility.class);
	}
	public static Logger getLogger()
	{
		return plpLogger;
	}
}
