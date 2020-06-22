CREATE TABLE `profile` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_name` varchar(50) DEFAULT NULL,
  `profile_description` varchar(50) DEFAULT NULL,
  `input_folder` varchar(50) DEFAULT NULL,
  `output_folder` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `profile_mail` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) NOT NULL,
  `recepient_type` varchar(10) NOT NULL,
  `email_id` varchar(45) NOT NULL,
  PRIMARY KEY (`row_id`),
  KEY `profile_mail_ibfk_1` (`profile_id`),
  CONSTRAINT `profile_mail_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

CREATE TABLE `profile_signatories` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) DEFAULT NULL,
  `signatory_id` int(11) DEFAULT NULL,
  `x_axis` int(11) DEFAULT NULL,
  `y_axis` int(11) DEFAULT NULL,
  `sign_size` int(11) DEFAULT NULL,
  `pages` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`row_id`),
  KEY `profile_id` (`profile_id`),
  KEY `signatory_id` (`signatory_id`),
  CONSTRAINT `profile_signatories_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`row_id`),
  CONSTRAINT `profile_signatories_ibfk_2` FOREIGN KEY (`signatory_id`) REFERENCES `signatories` (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `roles` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL,
  `CREATED_ON` datetime DEFAULT NULL,
  `MODIFIED_ON` datetime DEFAULT NULL,
  `CREATED_BY` int(11) DEFAULT NULL,
  `MODIFIED_BY` int(11) DEFAULT NULL,
  `DESCRIPTION` varchar(500) DEFAULT NULL,
  `STATUS` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `sign_history` (
  `row_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `profile_id` int(11) DEFAULT NULL,
  `sign_document_name` varchar(150) DEFAULT NULL,
  `signer_name` varchar(55) DEFAULT NULL,
  `sign_status` varchar(15) DEFAULT NULL,
  `failure_reason` varchar(55) DEFAULT NULL,
  `sign_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`row_id`),
  KEY `profile_id` (`profile_id`),
  KEY `sign_history_sign_date_IDX` (`sign_date`) USING BTREE,
  CONSTRAINT `sign_history_ibfk_1` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35597359 DEFAULT CHARSET=utf8;

CREATE TABLE `signatories` (
  `row_id` int(11) NOT NULL AUTO_INCREMENT,
  `signatory_name` varchar(50) DEFAULT NULL,
  `signature_private_key` varchar(50) DEFAULT NULL,
  `signature_certificate_key` varchar(50) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`row_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE `tbl_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_Amount` int(11) DEFAULT NULL,
  `Sub_Id` varchar(50) DEFAULT NULL,
  `sub_Name` varchar(50) DEFAULT NULL,
  `address1` varchar(150) DEFAULT NULL,
  `address2` varchar(150) DEFAULT NULL,
  `address3` varchar(150) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` varchar(50) DEFAULT NULL,
  `sub_Gstin` int(15) DEFAULT NULL,
  `gmd_Sl_No` varchar(50) DEFAULT NULL,
  `invoice_Number` varchar(50) DEFAULT NULL,
  `base_Amount` int(11) DEFAULT NULL,
  `tax_Amount` int(11) DEFAULT NULL,
  `total_Amount` int(11) DEFAULT NULL,
  `cgst` int(15) DEFAULT NULL,
  `sgst` int(15) DEFAULT NULL,
  `igst` int(15) DEFAULT NULL,
  `transaction_Date` varchar(50) DEFAULT NULL,
  `transaction_Id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

