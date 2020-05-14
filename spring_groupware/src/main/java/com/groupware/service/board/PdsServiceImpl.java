package com.groupware.service.board;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.groupware.dao.board.AttachDAO;
import com.groupware.dao.board.PdsDAO;
import com.groupware.dao.board.PdsShareDAO;
import com.groupware.dto.EmployeeVO;
import com.groupware.dto.PdsAttachVO;
import com.groupware.dto.PdsShareVO;
import com.groupware.dto.PdsVO;
import com.groupware.request.PageMaker;
import com.groupware.request.SearchCriteria;

public class PdsServiceImpl implements PdsService {

	private PdsDAO pdsDAO;
	public void setPdsDAO(PdsDAO pdsDAO) {
		this.pdsDAO = pdsDAO;
	}

	private PdsShareDAO pdsShareDAO;
	public void setPdsShareDAO(PdsShareDAO pdsShareDAO) {
		this.pdsShareDAO=pdsShareDAO;
	}
	
	
	private AttachDAO attachDAO;
	public void setAttachDAO(AttachDAO attachDAO) {
		this.attachDAO = attachDAO;
	}
	
	
	
	@Override
	public Map<String, Object> getList(SearchCriteria cri, EmployeeVO loginUser) throws SQLException {

		List<PdsVO> pdsList = pdsDAO.selectPdsSearchCriteria(cri);

		if (pdsList != null) {
			for (PdsVO pds : pdsList) {
				pds.setPdsShareList(pdsShareDAO.selectPdsShareListByPno(pds.getPno()));
				pds.setAttachList(attachDAO.selectAttachesByPno(pds.getPno()));
			}
		}
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(pdsDAO.selectPdsSearchCriteriaTotalCount(cri));

		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("pdsList", pdsList);
		dataMap.put("pageMaker", pageMaker);

		return dataMap;
	}

	@Override
	public PdsVO getPds(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		List<PdsShareVO> pdsShareList = pdsShareDAO.selectPdsShareListByPno(pno);
		List<PdsAttachVO> attachList = attachDAO.selectAttachesByPno(pno);
		
		pds.setPdsShareList(pdsShareList);
		pds.setAttachList(attachList);
		return pds;
	}

	@Override
	public void regist(PdsVO pds) throws SQLException {
		int pno = pdsDAO.getSeqNextValue();
		pds.setPno(pno);
		pdsDAO.insertPds(pds);
		
		if(pds.getPdsShareList()!=null) {
			for (PdsShareVO pdsShare : pds.getPdsShareList()) {
				pdsShare.setPno(pds.getPno());
				pdsShareDAO.insertPdsShare(pdsShare);
			}
		}
		if(pds.getAttachList()!=null) {
			for (PdsAttachVO attach : pds.getAttachList()) {
				attach.setPno(pno);
				attach.setAttacher(pds.getWriter());
				attachDAO.insertAttach(attach);
			}
		}
	}

	@Override
	public void modify(PdsVO pds) throws SQLException {
		pdsDAO.updatePds(pds);
		// attachDAO.deleteAllAttach(pds.getPno());
		for (PdsAttachVO attach : pds.getAttachList()) {
			attach.setPno(pds.getPno());
			attach.setAttacher(pds.getWriter());
			attachDAO.insertAttach(attach);
		}
	}

	@Override
	public void remove(int pno) throws SQLException {
		pdsDAO.deletePds(pno);
	}

	@Override
	public PdsVO read(int pno) throws SQLException {
		PdsVO pds = pdsDAO.selectPdsByPno(pno);
		
		List<PdsShareVO> pdsShareList = pdsShareDAO.selectPdsShareListByPno(pno);
		pds.setPdsShareList(pdsShareList);
		
		
		List<PdsAttachVO> attachList = attachDAO.selectAttachesByPno(pno);
		pds.setAttachList(attachList);
		pdsDAO.increaseViewCnt(pno);

		return pds;
	}

}
