package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.DETACH,
						 CascadeType.MERGE,
						 CascadeType.PERSIST,
						 CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY,
			   cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews = null;
	
	@ManyToMany(fetch=FetchType.LAZY,
				cascade= {CascadeType.DETACH,
						  CascadeType.MERGE,
						  CascadeType.PERSIST,
						  CascadeType.REFRESH})
	@JoinTable(name="course_student",
			   joinColumns=@JoinColumn(name="course_id"),
			   inverseJoinColumns=@JoinColumn(name="student_id"))
	private List<Student> students = null;

	public Course() {}

	public Course(String title) {this.title = title;}

	public int getId() {return id;}

	public void setId(int id) {this.id = id;}

	public String getTitle() {return title;}

	public void setTitle(String title) {this.title = title;}

	public Instructor getInstructor() {return instructor;}

	public void setInstructor(Instructor instructor) {this.instructor = instructor;}
	
	public List<Review> getReviews() {return reviews;}

	public void setReviews(List<Review> reviews) {this.reviews = reviews;}
	
	public List<Student> getStudents() {return students;}

	public void setStudents(List<Student> students) {this.students = students;}

	@Override
	public String toString() {return "\nCourse id: " + id + " | title: " + title + "\n";}
	
	/**
	 * this method sets up the bi-directional link between the Course class & the Review class
	 * 
	 * it adds a review to a course
	 * 
	 * @param r a reference to a Review instance
	 */
	public void addReview(Review r) {
		
		if (this.reviews == null) {
			this.reviews = new ArrayList<>();
		}
		
		// add a review to the list of reviews
		this.reviews.add(r);
		
	}
	
	/**
	 * this method sets up the link between the Course class & the Student class
	 * 
	 * it adds a student to a course
	 * 
	 * @param st a reference to a Student instance
	 */
	public void addStudent(Student st) {
		
		if (students == null) {
			students = new ArrayList<>();
		}
		
		// add a student to the list of students
		students.add(st);
		
	}
	
}
