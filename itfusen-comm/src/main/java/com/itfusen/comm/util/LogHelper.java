package com.itfusen.comm.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHelper {


	//system log  management
	public static final Logger system_log_logger = LoggerFactory.getLogger("system_log_item");
	//scan log item management
	public static final Logger user_scan_log_item_logger = LoggerFactory.getLogger("san_log_item");
	//scan log management
	public static final Logger user_scan_log_logger = LoggerFactory.getLogger("san_log");
	//user role management
	public static final Logger user_role_logger = LoggerFactory.getLogger("user_role_log");
	//user store management
	public static final Logger user_store_logger = LoggerFactory.getLogger("user_store_log");
	//user distributor management
	public static final Logger user_distributor_logger = LoggerFactory.getLogger("user_distributor_log");
	//product log management
	public static final Logger product_logger = LoggerFactory.getLogger("product_log");
	//distributor log management
	public static final Logger distributor_logger = LoggerFactory.getLogger("distributor_log");
	//store log management
	public static final Logger store_logger = LoggerFactory.getLogger("store_log");
	//user log management
	public static final Logger user_logger = LoggerFactory.getLogger("user_logger");
	//test
	public static final Logger test_logger = LoggerFactory.getLogger("test");
	//database
	public static final Logger log_database = LoggerFactory.getLogger("database");
	//task
	public static final Logger syncTask = LoggerFactory.getLogger("syncTask");
	//order
	public static final Logger order_logger = LoggerFactory.getLogger("order_log");
	//productScore
	public static final Logger productScore_logger = LoggerFactory.getLogger("productScore_log");
	//gradeScore
	public static final Logger gradeScore_logger = LoggerFactory.getLogger("gradeScore_log");

	//oapi
	public static final Logger oapi_logger = LoggerFactory.getLogger("oapi_logger");

	//code
	public static final Logger code_logger = LoggerFactory.getLogger("code_logger");


	//cache
	public static final Logger cache_logger = LoggerFactory.getLogger("cache_logger");

	//mdm sync
	public static final Logger mdm_sync_logger = LoggerFactory.getLogger("mdm_sync_logger");
}
