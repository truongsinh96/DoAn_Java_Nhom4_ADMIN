package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chiphingay;

@Component
public class ChiPhiNgayDaoImp extends HibernateUtil implements ChiPhiNgayDao{

	@Override
	public long getSum(Date begin, Date end) {
		String hql = "select COALESCE(SUM(tien), 0) from Chiphingay where ngay >= :begin and ngay < :end";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		return (long) query.uniqueResult();
	}

	@Override
	public long getSum(Date begin, Date end, int ChiNhanh) {
		String hql = "select COALESCE(SUM(tien), 0) from Chiphingay where ngay >= :begin and ngay < :end and chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql);
		query.setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return (long) query.uniqueResult();
	}

	@Override
	public List<Chiphingay> getListIn(Date begin, Date end) {
		String hql = "from Chiphingay where ngay >= :begin and ngay < :end";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		return query.list();
	}

	@Override
	public List<Chiphingay> getListIn(Date begin, Date end, int ChiNhanh) {
		String hql = "from Chiphingay where ngay >= :begin and ngay < :end and chinhanh.chiNhanhId = :ChiNhanh";
		Query query = getSession().createQuery(hql).setParameter("begin", begin);
		query.setParameter("end", end);
		query.setParameter("ChiNhanh", ChiNhanh);
		return query.list();
	}

	@Override
	public List<Chiphingay> getChiPhiNgayInDate(Date date) {
		//language=HQL
		String hql = "from Chiphingay where (day(ngay)=day(:date) and month(ngay)=month(:date) and year(ngay)=year(:date))";
		Query query = getSession().createQuery(hql).setParameter("date", date);
		return query.list();
	}

	@Override
	public void create(Chiphingay chiphingay) {
		super.create(chiphingay);
	}

	@Override
	public Chiphingay getById(int id) {
		return super.fetchById(id, Chiphingay.class);
	}

	@Override
	public void update(Chiphingay chiphingay) {
		super.update(chiphingay);
	}

	@Override
	public void deleteById(int id) {
		super.delete(id, Chiphingay.class);
	}

}
