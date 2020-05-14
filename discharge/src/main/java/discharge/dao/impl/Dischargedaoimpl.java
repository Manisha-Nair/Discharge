package discharge.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import discharge.dao.DischargeDao;
import discharge.dao.entity.DischargeEntity;
import discharge.dto.Dischargedto;
import discharge.hibernate.utils.HibernateUtils;

@Component
public class Dischargedaoimpl implements DischargeDao {

	Session session;

	@Override
	public void openConnection() {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
		session = sessionFactory.openSession();

	}

	@Override
	public Dischargedto getDischargeById(String patientId) {

		Dischargedto patientdto = null;

		long patId = Long.parseLong(patientId);

		CriteriaBuilder crb = session.getCriteriaBuilder();

		CriteriaQuery<DischargeEntity> cquery = crb.createQuery(DischargeEntity.class);

		Root<DischargeEntity> root = cquery.from(DischargeEntity.class);

		cquery.select(root);

		cquery.where(crb.equal(root.get("id"), patId));

		Query<DischargeEntity> query = session.createQuery(cquery);

		DischargeEntity patientEntity = query.uniqueResult();
		
		if (patientEntity != null) {
			patientdto = new Dischargedto();
			BeanUtils.copyProperties(patientEntity, patientdto);

		}

		return patientdto;

	}

	@Override
	public void closeConnection() {

		if (session != null)
			session.close();
	}

	@Override
	public Dischargedto savePatient(Dischargedto patientdto) {

		Dischargedto savedPatient = null;
		DischargeEntity patientEntity = new DischargeEntity();

		BeanUtils.copyProperties(patientdto, patientEntity);

		//openConnection();
		session.beginTransaction();
		session.save(patientEntity);
		session.getTransaction().commit();
		//closeConnection();

		savedPatient = new Dischargedto();
		BeanUtils.copyProperties(patientEntity, savedPatient);

		return savedPatient;

	}

}