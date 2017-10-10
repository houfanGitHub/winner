package com.item.finance.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.item.finance.bean.FinanceProductFunds;
import com.item.finance.bean.FinanceProductSubscribe;

@Component
public class Yx_FinanceProductFunds_Dao {
	@Autowired
	private SessionFactory sessionFactory;
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public List<FinanceProductFunds> listFinanceProductFunds(Map map){
		Session session=getSession();
		String hql="from FinanceProductFunds where 0=0";
		hql=datehql(map, hql);
		List<FinanceProductFunds> list=session.createQuery(hql).list();
	/*	for(int i=0;i<list.size();i++){
			//System.out.println(listCount().get(i));
			//System.out.println(list.get(i));
			list.get(i).setCounts(listCount().get(i));
		}*/
		return  list;
	}
	public String datehql(Map map,String hql){
		String qname=(String)map.get("qname");
		String qstatus=(String)map.get("qstatus");
		String qtype=(String)map.get("qtype");
		if(qname!=null&&!qname.equals("")){
			hql+="and name like '%"+qname+"%'";
		}
		if(qstatus!=null&&!qstatus.equals("")){
			hql+="and status like '%"+qstatus+"%'";
		}
		if(qtype!=null&&!qtype.equals("")){
			hql+="and type like '%"+qtype+"%'";
		}
		return hql;
	}
	public FinanceProductFunds listEdit(int id){
		Session session=getSession();
		FinanceProductFunds fs=(FinanceProductFunds)session.get(FinanceProductFunds.class, id);
		return fs;
	}
	public FinanceProductSubscribe listchakan(int id){
		Session session=getSession();
		FinanceProductSubscribe fe=(FinanceProductSubscribe)session.get(FinanceProductSubscribe.class, id);
		return fe;
	}
	public void saveFinanceProductFunds(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.save(financeProductFunds);
	}
	public List<FinanceProductSubscribe> listWdl(int id){
		Session session=getSession();
		String hql="from FinanceProductSubscribe where product_id="+id;
		List<FinanceProductSubscribe> list=session.createQuery(hql).list();
	    return list;
	}
	//查询条数
/*	public List<Integer> listCount(){
		Session session=getSession();
		String sql="SELECT COUNT(e.product_id) FROM  finance_product_funds f left join  finance_product_subscribe e on f.id=e.product_id GROUP BY f.id";
	    List<Integer> list=session.createSQLQuery(sql).list();
	    return list;
	}*/
	public FinanceProductSubscribe selectqssb(int id){
		Session session=getSession();
		FinanceProductSubscribe fs=(FinanceProductSubscribe)session.get(FinanceProductSubscribe.class, id);
		return fs;
	}
	//设置签署失败
	public void updateqssb(FinanceProductSubscribe fe){
		Session session=getSession();
		session.update(fe);
	}
	//修改
	public void	updateFinanceProductFunds(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.update(financeProductFunds);
	}
	//签署合同
	public void	 updatesign(FinanceProductSubscribe financeProductSubscribe){
		Session session=getSession();
		session.update(financeProductSubscribe);
	}
	public void	 updatesign2(FinanceProductFunds financeProductFunds){
		Session session=getSession();
		session.update(financeProductFunds);
	}

}
