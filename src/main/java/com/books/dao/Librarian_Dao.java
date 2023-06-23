package com.books.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.books.entity.Users_In_library;

@Repository
public class Librarian_Dao {

	@Autowired
	private SessionFactory sf;

	public List<Users_In_library> get_users() {
		Session session = sf.openSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Users_In_library.class);
		@SuppressWarnings("unchecked")
		List<Users_In_library> list_users = criteria.list();
		return list_users;

	}

	public String create_User(Users_In_library user) {

		Session session = sf.openSession();

		Transaction tr = session.beginTransaction();

		session.saveOrUpdate(user);
		tr.commit();

		return "User is created....";

	}

	public String update_User(Users_In_library user) {
		Session s = sf.openSession();

		s.beginTransaction();

		s.saveOrUpdate(user);

		s.getTransaction().commit();

		return "User is Updated ..";
	}

//	public String deleteStaffInfo(int clg) {
//		Session sn = sf.openSession();
//		Transaction tn = sn.beginTransaction();
//		Collage ls = sn.load(Collage.class, clg);
//		sn.delete(ls);
//		tn.commit();
//		return "data delete...";
//
//	}

	public String delete_User(int id) {

		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();

		Users_In_library load = session.load(Users_In_library.class, id);
		session.remove(load);
		transaction.commit();

		return "User is Deleted..";
	}

	public List<Users_In_library> get_First_Name(Users_In_library user) {

		Session session = sf.openSession();

		@SuppressWarnings("deprecation")
		Criteria cr = session.createCriteria(Users_In_library.class);
		cr.add(Restrictions.like("name", "Shreekant%"));
		@SuppressWarnings("unchecked")
		List<Users_In_library> list = cr.list();
		return list;
	}

	@SuppressWarnings("deprecation")
	public List<Users_In_library> bonus_less_than_200() {
		Session filter_session = sf.openSession();

		Criteria criteria = filter_session.createCriteria(Users_In_library.class);

		criteria.add(Restrictions.lt("Due_of_Late_Submit", 200));

		@SuppressWarnings("unchecked")
		List<Users_In_library> less_than_2 = criteria.list();
		return less_than_2;

	}

	public List<Users_In_library> Ordedby_name_DESC() {
		Session query_Test = sf.openSession();

		// FROM Aviation_industry Date ORDER BY E.Date DESC
		String name_Desc_order = "select name from Users_In_library ORDER BY name DESC";
		@SuppressWarnings("unchecked")
		Query<Users_In_library> createQuery = query_Test.createQuery(name_Desc_order);
		List<Users_In_library> list = createQuery.list();
		// System.out.println(list);

		return list;
	}

	public List<Users_In_library> row_cout() {

		// To get records having salary less than 2000
		// cr.add(Restrictions.lt("salary", 2000));

		Session projection_Agression = sf.openSession();

		Criteria criteria = projection_Agression.createCriteria(Users_In_library.class);
		criteria.setProjection(Projections.rowCount());

		List<Users_In_library> row_Count = criteria.list();
		return row_Count;

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Users_In_library> sum_of_bonus() {
		Session projection_Agression = sf.openSession();

		Criteria criteria = projection_Agression.createCriteria(Users_In_library.class);
		criteria.setProjection(Projections.sum("Due_of_Late_Submit"));

		List<Users_In_library> bonus_of_due = criteria.list();
		return bonus_of_due;

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Users_In_library> max_bonus() {
		Session projection_Agression = sf.openSession();

		Criteria criteria = projection_Agression.createCriteria(Users_In_library.class);
		criteria.setProjection(Projections.max("Due_of_Late_Submit"));

		List<Users_In_library> bonus_of_due = criteria.list();
		return bonus_of_due;

	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean isEmepty() {
		Session projection_Agression = sf.openSession();

		Criteria criteria = projection_Agression.createCriteria(Users_In_library.class);
		List<Users_In_library> list = criteria.list();
//		int empty = list.size();

		if (!list.isEmpty()) {
			return true;
		} else {
			return false;
		}

//		if(empty > 0)
//		{
//			System.out.println("Database contain record ");
//			return 1 ;
//		}
//		else
//		{
//			System.out.println("Database is empty");
//			return 0;
//		}

	}

	public List<Users_In_library> list_of_Field() {
		Session all_field_session = sf.openSession();

		@SuppressWarnings("deprecation")
		Criteria criteria = all_field_session.createCriteria(Users_In_library.class);
		Projection property1 = Projections.property("name");
		Projection property2 = Projections.property("book_name");
		Projection property3 = Projections.property("name_of_Librarian");

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(property1);
		projectionList.add(property2);
		projectionList.add(property3);

		criteria.setProjection(projectionList);

		@SuppressWarnings("unchecked")
		List<Users_In_library> list = criteria.list();
		return list;

	}

	public List<Users_In_library> particular_field_count() {
		// To get distinct count of a property.
		// cr.setProjection(Projections.countDistinct("firstName"));
		Session One_field_session = sf.openSession();

		@SuppressWarnings("deprecation")
		Criteria criteria = One_field_session.createCriteria(Users_In_library.class);
		criteria.setProjection(Projections.countDistinct("book_name"));
		List<Users_In_library> list = criteria.list();

		return list;

	}

	public List<Users_In_library> Extra_Charge_of_Due() {
		Session session = sf.openSession();
		@SuppressWarnings("deprecation")
		Criteria criteria = session.createCriteria(Users_In_library.class);
		@SuppressWarnings("unchecked")
		List<Users_In_library> list_users = criteria.list();
		return list_users;

	}

	public List<Users_In_library> distinct_name_of_librarian() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Users_In_library.class);

		criteria.setProjection(Projections.countDistinct("name_of_Librarian"));
		List<Users_In_library> countDistict_librarian = criteria.list();

		return countDistict_librarian;
	}

	/*
	 * The name propery is used. by using alias and reverse order it returning the
	 * list
	 * 
	 * 
	 */
	@SuppressWarnings("deprecation")
	public List<Users_In_library> group_by_alias_usin_Name_Field() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Users_In_library.class);
		@SuppressWarnings("unchecked")
		List<Users_In_library> list_of_name = criteria
				.setProjection(Projections.groupProperty("name").as("name_of_user"))
				.addOrder(Order.desc("name_of_user")).list();
		return list_of_name;
	}

	/*
	 * 
	 * DetachedCriteria query = DetachedCriteria.forClass(Cat.class) .add(
	 * Property.forName("sex").eq('F') );
	 * 
	 * Session session = ....; Transaction txn = session.beginTransaction(); List
	 * results = query.getExecutableCriteria(session).setMaxResults(100).list();
	 * txn.commit(); session.close();
	 * 
	 * 
	 */
	public List<Users_In_library> DetachedCriteria_Query_Date() {
		DetachedCriteria query = DetachedCriteria.forClass(Users_In_library.class)
				.add(Property.forName("name_of_librarian").eq('K')); // K for only character in the database otherwise
																		// generate error

		Session session = sf.openSession();
		Transaction txn = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Users_In_library> results = query.getExecutableCriteria(session).setMaxResults(10).list();
		txn.commit();
		session.close();
		return results;
	}

	/*
	 * A DetachedCriteria may also be used to express a subquery. 
	 * Criterion instances involving subqueries may be obtained via Subqueries or Property.
	 * 
	 * DetachedCriteria weights = DetachedCriteria.forClass(Cat.class)
	 * .setProjection( Property.forName("weight") );
	 * session.createCriteria(Cat.class) .add( Subqueries.geAll("weight", weights) )
	 * .list();
	 * 
	 * 
	 * 
	 */
	
	public List<Users_In_library> sub_query_using_Dispacter()
	{
		DetachedCriteria due = DetachedCriteria.forClass(Users_In_library.class)
				.setProjection(Property.forName("due_for_user"));
		
		Session session = sf.openSession();
		@SuppressWarnings({ "unchecked", "deprecation" })
		List<Users_In_library> list = session.createCriteria(Users_In_library.class)
		.add( Subqueries.geAll("due_for_user", due))
		.list();
		
		return list;
		
	}

}
