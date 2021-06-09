package com.samuel.workshopmongo.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hero implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String heroName;
	private String power;
	private Integer type;
	private String skills;
	private String urlImage;

	public Hero() {
	}

	public Hero(String heroName, String power, Integer type, String skills, String urlImage) {
		this.heroName = heroName;
		this.power = power;
		this.type = type;
		this.skills = skills;
		this.urlImage = urlImage;
	}

	public String getHeroName() {
		return heroName;
	}

	public void setHeroName(String heroName) {
		this.heroName = heroName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heroName == null) ? 0 : heroName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (heroName == null) {
			if (other.heroName != null)
				return false;
		} else if (!heroName.equals(other.heroName))
			return false;
		return true;
	}
	

}
