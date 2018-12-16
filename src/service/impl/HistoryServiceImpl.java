package service.impl;

import java.util.List;

import dao.HistoryDAO;
import pojo.History;
import service.HistoryService;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:16:55
 */
public class HistoryServiceImpl implements HistoryService {

	HistoryDAO historyDAO;

	public HistoryDAO getHistoryDAO() {
		return historyDAO;
	}

	public void setHistoryDAO(HistoryDAO historyDAO) {
		this.historyDAO = historyDAO;
	}

	public List<History> list() {
		return historyDAO.list();
	}
	
	public void add(History history) {
		historyDAO.add(history);
	}
}
