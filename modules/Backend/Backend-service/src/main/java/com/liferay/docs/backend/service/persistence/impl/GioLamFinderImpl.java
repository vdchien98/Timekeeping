package com.liferay.docs.backend.service.persistence.impl;

import com.liferay.docs.backend.model.GioLam;
import com.liferay.docs.backend.model.impl.GioLamImpl;
import com.liferay.docs.backend.service.persistence.GioLamFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = GioLamFinder.class)

public class GioLamFinderImpl extends GioLamFinderBaseImpl implements GioLamFinder {
	   @Reference
	    private CustomSQL _customSQL;
		
		public List<GioLam>  getGioLamByYearAndMonth( String Month,String Year, long userId){
			System.out.println("Inside custom sql");
			 Session session=null;
			  try{
			          session=openSession();            
			          String sql=_customSQL.get(getClass(),GioLamFinder.class.getName() + ".getGioLamByYearAndMonth");
			        //  System.out.println("Query==>"+sql);
			        //  System.out.println("");
			          SQLQuery sqlQuery=session.createSQLQuery(sql);
			          sqlQuery.setCacheable(false);
	                  sqlQuery.addEntity("GioLam",GioLamImpl.class);
	                //  System.out.println("sqlQuery==>"+sqlQuery);
			          QueryPos queryPos=QueryPos.getInstance(sqlQuery);
			       //   System.out.println("queryPos==>"+queryPos);
			          queryPos.add(Month);
			          queryPos.add(Year);
			          queryPos.add(userId);
			        //  System.out.println("queryPos 22222222222==>"+queryPos);
			          return (List<GioLam>)sqlQuery.list();
			  }catch(Exception e){
			   
			  }finally {
			   closeSession(session);
			  }
			  return null;
			 }
}
