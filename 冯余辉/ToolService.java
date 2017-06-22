package com.service;

import java.util.List;
import java.util.Map;

import queryGuan.portGuan;
import realizeGuan.RealizeztGuan;
import UserDaoImplGuan.DeskClassGuan;

public class ToolService {
	private portGuan pt = new RealizeztGuan();
	public List<Map <String,Object>> query(){
		return pt.query();
	}
	/**
	 * 增加桌台
	 */
	public void add(DeskClassGuan dc){
		pt.add(dc);
	}
	/**
	 * 更新桌台
	 */
	public void update(int staid,int deskid){
		pt.update(staid, deskid);
	}
	/**
	 * 查询桌台
	 * @param id
	 * @return
	 */
	public List<Map <String,Object>> getdesk(int id){
		return pt.getdesk(id);
	}
	/**
	 * 查询未使用餐桌
	 * @param statuid
	 * @return
	 */
	public List<Map <String,Object>> getDesknotuse(){
		return pt.getDesknotuse();
	}
	/**
	 * 根据桌台号 查询本桌台的状态
	 * @param deskid
	 * @return
	 */
	public List<Map <String,Object>> getstatusName(int deskid){
		return pt.getstatusName(deskid);
	}
	/**
	 * 获取桌子
	 * @return
	 */
	public List<Map<String, Object>> getdeskone(){
		return pt.getdeskone();
	}
	/**
	 * 获取包厢
	 * @return
	 */
	public List<Map<String, Object>> getdesksecond(){
		return pt.getdesksecond();
	}
	/**
	 * 获取可用的桌子
	 * @return
	 */
	public List<Map <String,Object>> getdesknotuse(){
		return pt.getdesknotuse();
	}
	/**
	 * 获取可用的包厢
	 * @return
	 */
	public List<Map <String,Object>> gethomedesknotuse(){
		return pt.gethomedesknotuse();
	}
	/**
	 * 查询人数大于num的餐桌
	 * @return
	 */
	public List<Map <String,Object>> penum(int num){
		return pt.peDesknum(num);
	}
	/**
	 * 查询人数大于num的包厢
	 * @return
	 */
	public List<Map <String,Object>> peHomeDesknum(int num) {
		return pt.peHomeDesknum(num);
	}
}

