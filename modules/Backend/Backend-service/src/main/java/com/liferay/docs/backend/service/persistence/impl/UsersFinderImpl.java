package com.liferay.docs.backend.service.persistence.impl;

import com.liferay.docs.backend.model.Users;
import com.liferay.docs.backend.model.impl.UsersImpl;
import com.liferay.docs.backend.service.persistence.UsersFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = UsersFinder.class)
public class UsersFinderImpl extends UsersFinderBaseImpl implements UsersFinder {

	@Reference
	private CustomSQL _customSQL;

	public List<Users> getDuLieuTimKiem(String keytimkiem) {
		System.out.println("Inside custom sql");
		System.out.println("Inside custom sql === "+ keytimkiem);
		Session session = null;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), UsersFinder.class.getName() + ".getDuLieuTimKiem");
			System.out.println("Query==>" + sql);
			System.out.println("");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Users", UsersImpl.class);
			System.out.println("sqlQuery==>" + sqlQuery);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			System.out.println("queryPos==>" + queryPos);
			queryPos.add(keytimkiem);
			System.out.println("queryPos 22222222222222222222 ==>" + queryPos);
			System.out.println("(List<Users>) sqlQuery.list()==>" + (List<Users>) sqlQuery.list());
			return (List<Users>) sqlQuery.list();
		} catch (Exception e) {

		} finally {
			closeSession(session);
		}
		 return null;
		

	}

}
