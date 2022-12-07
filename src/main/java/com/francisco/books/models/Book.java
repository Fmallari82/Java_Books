package com.francisco.books.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min = 5, max = 200, message="title needs to be at least 5 characters long")
    private String title;
    
    @NotNull
    @Size(min = 5, max = 200, message="description needs to be at least 5 characters long")
    private String description;
    
    @NotNull
    @Size(min = 3, max = 40, message="language needs to be at least 5 characters long")
    private String language;
    
    @NotNull
    @Min(value=100, message="Number of pages needs to be at least 100 pages")
    private Integer numberOfPages;
    
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Book() {
    }
    
    public Book(
			@NotNull @Size(min = 5, max = 200, message = "title needs to be at least 5 characters long") String title,
			@NotNull @Size(min = 5, max = 200, message = "description needs to be at least 5 characters long") String description,
			@NotNull @Size(min = 3, max = 40, message = "language needs to be at least 5 characters long") String language,
			@NotNull @Min(value = 100, message = "Number of pages needs to be at least 100 pages") Integer numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}
    

	public Book(Long id,
			@NotNull @Size(min = 5, max = 200, message = "title needs to be at least 5 characters long") String title,
			@NotNull @Size(min = 5, max = 200, message = "description needs to be at least 5 characters long") String description,
			@NotNull @Size(min = 3, max = 40, message = "language needs to be at least 5 characters long") String language,
			@NotNull @Min(value = 100, message = "Number of pages needs to be at least 100 pages") Integer numberOfPages) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}

	// other getters and setters removed for brevity
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Integer getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	protected void onCreate(){
		this.createdAt = new Date();
	}
	@PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}

