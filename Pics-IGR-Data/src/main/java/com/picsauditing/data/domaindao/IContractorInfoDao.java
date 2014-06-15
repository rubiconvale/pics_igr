
package com.picsauditing.data.domaindao;

import com.picsauditing.data.model.entity.ContractorInfo;
import com.picsauditing.exception.DAOLayerException;

import java.util.List;

//This ia a test
public interface IContractorInfoDao {

	List<ContractorInfo> findAllContractorInfo() throws DAOLayerException;

	ContractorInfo findContractorInfoByName(String name) throws DAOLayerException;
	
}