DROP TABLE IF EXISTS FLT_DETAILS;
CREATE TABLE FLT_DETAILS(
	FLT_ID INT AUTO_INCREMENT PRIMARY KEY,
	FLT_NUMBER VARCHAR(4) NOT NULL,
	FLT_SUFFIX VARCHAR(2) NULL,
	FLT_PREFIX VARCHAR(2) NOT NULL,
	FLT_SCH_DEP_DATE VARCHAR(20) NOT NULL, 
	FLT_SCH_DEP_TIME VARCHAR(5) NOT NULL,
	FLT_ACT_DEP_DATE VARCHAR(20) NULL, 
	FLT_ACT_DEP_TIME VARCHAR(5) NULL, 
	FLT_SCH_ARR_DATE VARCHAR(20) NOT NULL, 
	FLT_SCH_ARR_TIME VARCHAR(5) NOT NULL, 
	FLT_ACT_ARR_DATE VARCHAR(20) NULL, 
	FLT_ACT_ARR_TIME VARCHAR(5) NULL, 
	FLT_ROUTE VARCHAR(20) NOT NULL, 
	FLT_STATUS VARCHAR(2) NOT NULL
);


