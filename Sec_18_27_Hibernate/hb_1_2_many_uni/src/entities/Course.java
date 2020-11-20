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
	
}
