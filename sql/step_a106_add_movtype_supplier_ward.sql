INSERT INTO `oh_medicaldsrstockmovtype`(`MMVT_ID_A`, `MMVT_DESC`, `MMVT_TYPE`, `MMVT_CREATED_BY`, `MMVT_CREATED_DATE`, `MMVT_LAST_MODIFIED_BY`, `MMVT_LAST_MODIFIED_DATE`, `MMVT_ACTIVE`) VALUES ('inventory+','Inventory+','+',NULL,NULL,NULL,NULL,1);
INSERT INTO `oh_medicaldsrstockmovtype`(`MMVT_ID_A`, `MMVT_DESC`, `MMVT_TYPE`, `MMVT_CREATED_BY`, `MMVT_CREATED_DATE`, `MMVT_LAST_MODIFIED_BY`, `MMVT_LAST_MODIFIED_DATE`, `MMVT_ACTIVE`) VALUES ('inventory-','Inventory-','-',NULL,NULL,NULL,NULL,1);
INSERT INTO `oh_supplier` (`SUP_ID`, `SUP_NAME`, `SUP_ADDRESS`, `SUP_TAXCODE`, `SUP_PHONE`, `SUP_FAX`, `SUP_EMAIL`, `SUP_NOTE`, `SUP_DELETED`, `SUP_CREATED_BY`, `SUP_CREATED_DATE`, `SUP_LAST_MODIFIED_BY`, `SUP_LAST_MODIFIED_DATE`, `SUP_ACTIVE`) VALUES (4,'INVENTORY',NULL,NULL,NULL,NULL,NULL,NULL,'N','admin','2024-06-06 10:07:52','admin','2024-06-06 10:14:57',1);
INSERT INTO `oh_ward` (`WRD_ID_A`, `WRD_NAME`, `WRD_TELE`, `WRD_FAX`, `WRD_EMAIL`, `WRD_NBEDS`, `WRD_NQUA_NURS`, `WRD_NDOC`, `WRD_IS_OPD`, `WRD_IS_PHARMACY`, `WRD_IS_MALE`, `WRD_IS_FEMALE`, `WRD_VISIT_DURATION`, `WRD_LOCK`, `WRD_CREATED_BY`, `WRD_CREATED_DATE`, `WRD_LAST_MODIFIED_BY`, `WRD_LAST_MODIFIED_DATE`, `WRD_ACTIVE`) VALUES ('INV','INVENTORY',237,'','',0,0,0,0,0,0,0,0,0,'admin','2024-06-06 10:03:55',NULL,NULL,1);