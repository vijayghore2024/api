package com.example.api;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAO {

	@Autowired
	public SessionFactory sf;

	@PersistenceContext
	private EntityManager entityManager;

	public List<Student> getAllStudents() {
		try (Session session = sf.openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Student> query = builder.createQuery(Student.class);
			Root<Student> root = query.from(Student.class);

			query.select(root);

			List<Student> students = session.createQuery(query).getResultList();
			return students;
		}
	}

	@Transactional
    public Student getStudent(int rno) {
        try {
            return entityManager.find(Student.class, rno);
        } catch (Exception e) {
            e.printStackTrace(); 
            return null; 
        }
    }
	
	
	@Transactional
	public String addStudent(Student std) {
		try {
			entityManager.persist(std);
			return "Record Saved Successfully !!";
		} catch (Exception e) {
			e.printStackTrace(); // Log or handle the exception appropriately
			return "Error saving the record. See logs for details.";
		}
	}
	
	@Transactional
    public String deleteStudent(int rno) {
        try {
            Student studentToDelete = entityManager.find(Student.class, rno);
            if (studentToDelete != null) {
                entityManager.remove(studentToDelete);
                return "Record Deleted Successfully !!";
            } else {
                return "Student with ID " + rno + " not found.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error deleting the record. See logs for details.";
        }
    }

}
