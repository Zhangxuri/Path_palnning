-- auto Generated on 2018-01-19 14:28:45 
-- DROP TABLE IF EXISTS product_list; 
CREATE TABLE product_list(
	id BIGINT (15) NOT NULL AUTO_INCREMENT COMMENT 'id',
	address VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'address',
	product BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'product',
	sendname VARCHAR (50) NOT NULL DEFAULT '' COMMENT 'sendname',
	sendtel BIGINT (15) NOT NULL DEFAULT -1 COMMENT 'sendtel',
	PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT 'product_list';
