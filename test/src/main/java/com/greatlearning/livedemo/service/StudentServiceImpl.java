package com.greatlearning.livedemo.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatlearning.livedemo.entity.Student;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionfactory;
	private Session session;

	@Autowired
	public StudentServiceImpl(SessionFactory sessionfactory) {
		super();
		this.sessionfactory = sessionfactory;

		try {
			this.session = this.sessionfactory.getCurrentSession();
		}

		catch (HibernateException exp) {

			this.session = this.sessionfactory.openSession();
		}
	}

	@Override
	public List<Student> findAll() {
		List<Student> students = this.session.createQuery("From Student").list();
		return students;
	}

	@Override
	public Student findbyId(int Studentid) {
		Student student = this.session.get(Student.class, Studentid);
		return student;
	}

	@Override
	@Transactional
	public void save(Student student) {
		Transaction tx = this.session.beginTransaction();
		this.session.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	@Transactional
	public void delete(int Studentid) {
		Student student = findbyId(Studentid);
		Transaction tx = this.session.beginTransaction();
		this.session.delete(student);
		tx.commit();
	}
}
