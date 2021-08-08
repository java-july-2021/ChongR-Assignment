package com.chongren.lookify.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="lookify")
public class Lookify {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(min=5)
	private String title;
	
	@NotBlank
	@Size(min=5)
	private String artist;
	
	@NotNull
	@Min(1)
	@Max(10)
	private int rating;

	
	public Lookify() {
			
		}
	
	public Lookify(@NotBlank @Size(min = 5) String title, @NotBlank @Size(min = 5) String artist,
			int rating) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}

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

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	
	
	
	
	
	
}
