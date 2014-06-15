package com.picsauditing.data.domaindao.impl;

import com.picsauditing.data.domaindao.IContractorInfoDao;
import com.picsauditing.data.model.entity.ContractorInfo;
import com.picsauditing.exception.DAOLayerException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * @author ram natarajan
 */
@Repository

public class ContractorDaoImpl extends		AbstractDaoImpl<ContractorInfo, Integer> implements IContractorInfoDao {

	@Override
	public ContractorInfo findContractorInfoByName(String name)			throws DAOLayerException {
        log.trace("entered ContractorInfoDaoImpl.findContractorInfoByName({})",name);
		try {
             Query qry = getSession().getNamedQuery("ContractorInfo.findContractorByAccountName").setParameter("name", name);
             return (ContractorInfo) qry.uniqueResult();
        } catch (HibernateException e) {
			throw new DAOLayerException(e.getMessage());
		}
	}

	@Override

	public List<ContractorInfo> findAllContractorInfo() throws DAOLayerException {
        log.trace("entered ContractorInfoDaoImpl.findAllContractorInfo()");
		try {
			return findAllObjects();
		} catch (HibernateException e) {
			throw new DAOLayerException(e.getMessage());
		}
	}

//This is atest

}
