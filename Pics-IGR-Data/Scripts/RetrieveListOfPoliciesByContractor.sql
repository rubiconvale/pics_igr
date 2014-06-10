SELECT TRIM(Account.name) AS `accountName`, Account.id AS `AccountID`, Audit.auditTypeID AS `AuditTypeName`, Audit.auditTypeID AS `AuditTypeNameString`, Audit.id AS `AuditID`, TRIM(AuditOperatorAccount.name) AS `auditOperatorAccountName`, Audit.effectivedate AS `AuditEffectiveDate`, Audit.expiresdate AS `auditExpiresDate`, CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) AS `AuditOperatorStatusSubstatus`
FROM contractor_audit_operator AS AuditOperator
JOIN accounts AS AuditOperatorAccount ON AuditOperator.opID = AuditOperatorAccount.id
JOIN contractor_audit AS Audit ON AuditOperator.auditID = Audit.id
JOIN audit_type AS AuditType ON Audit.auditTypeID = AuditType.id
JOIN contractor_info AS Contractor ON Audit.conID = Contractor.id
JOIN accounts AS Account ON Contractor.id = Account.id AND Account.type = 'Contractor'
WHERE ((AuditType.classtype IN ('Policy')) AND ((Audit.expiresdate >= '2014-06-09' OR Audit.expiresdate IS NULL)) AND (true)) 
 AND (AuditOperator.visible = 1) 
ORDER BY AuditOperator.statuschangeddate DESC

SELECT TRIM(Account.name) AS `accountName`, Account.id AS `AccountID`, Audit.auditTypeID AS `AuditTypeName`, Audit.auditTypeID AS `AuditTypeNameString`, Audit.id AS `AuditID`, TRIM(AuditOperatorAccount.name) AS `auditOperatorAccountName`, Audit.effectivedate AS `AuditEffectiveDate`, Audit.expiresdate AS `auditExpiresDate`, CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) AS `AuditOperatorStatusSubstatus`, CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) AS `AuditOperatorStatusSubstatus`
FROM contractor_audit_operator AS AuditOperator
JOIN accounts AS AuditOperatorAccount ON AuditOperator.opID = AuditOperatorAccount.id
JOIN contractor_audit AS Audit ON AuditOperator.auditID = Audit.id
JOIN audit_type AS AuditType ON Audit.auditTypeID = AuditType.id
JOIN contractor_info AS Contractor ON Audit.conID = Contractor.id
JOIN accounts AS Account ON Contractor.id = Account.id AND Account.type = 'Contractor'
WHERE ((AuditType.classtype IN ('Policy')) AND ((Audit.expiresdate >= '2014-06-09' OR Audit.expiresdate IS NULL)) AND (true) AND (CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) IN ('Submitted','Resubmit'))) 
 AND (AuditOperator.visible = 1) 
ORDER BY AuditOperator.statuschangeddate DESC

SELECT TRIM(Account.name) AS `accountName`, Account.id AS `AccountID`, Audit.auditTypeID AS `AuditTypeName`, Audit.auditTypeID AS `AuditTypeNameString`, Audit.id AS `AuditID`, TRIM(AuditOperatorAccount.name) AS `auditOperatorAccountName`, Audit.effectivedate AS `AuditEffectiveDate`, Audit.expiresdate AS `auditExpiresDate`, CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) AS `AuditOperatorStatusSubstatus`, CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) AS `AuditOperatorStatusSubstatus`
FROM contractor_audit_operator AS AuditOperator
JOIN accounts AS AuditOperatorAccount ON AuditOperator.opID = AuditOperatorAccount.id
JOIN contractor_audit AS Audit ON AuditOperator.auditID = Audit.id
JOIN audit_type AS AuditType ON Audit.auditTypeID = AuditType.id
JOIN contractor_info AS Contractor ON Audit.conID = Contractor.id
JOIN accounts AS Account ON Contractor.id = Account.id AND Account.type = 'Contractor'
LEFT JOIN account_user AS CustomerService ON Contractor.id = CustomerService.accountID AND CustomerService.role = 'PICSCustomerServiceRep' AND CustomerService.startDate < NOW() AND CustomerService.endDate >= NOW()
LEFT JOIN users AS CustomerServiceUser ON CustomerService.userID = CustomerServiceUser.id
WHERE ((AuditType.classtype IN ('Policy')) AND ((Audit.expiresdate >= '2014-06-09' OR Audit.expiresdate IS NULL)) AND (true) AND (CONCAT(AuditOperator.status,IFNULL(CONCAT(':',AuditOperator.auditSubStatus),'')) IN ('Submitted','Resubmit')) AND (CustomerServiceUser.id = 8397)) 
 AND (AuditOperator.visible = 1) 
ORDER BY AuditOperator.statuschangeddate DESC