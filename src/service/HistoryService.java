package service;

import java.util.List;

import pojo.History;

/**
 * @author: 詹亦凡
 * @date: 2018年11月27日 下午9:15:34
 */
public interface HistoryService {
	
	//获取所有操作历史
	public List<History> list();
	
	//新增操作历史
	public void add(History history);
}
