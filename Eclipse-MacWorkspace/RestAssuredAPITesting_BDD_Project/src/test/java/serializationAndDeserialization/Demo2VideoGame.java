package serializationAndDeserialization;

import java.io.Serializable;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Demo2VideoGame implements Serializable{
	
	public int id=0;
	public String name;
	public String releaseDate;
	public int reviewScore =0;
	public String Category;
	public String rating;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String showasString() {
		return(this.id+" "+this.name+" "+this.releaseDate+" "+this.reviewScore+" "+this.Category+" "+this.rating);
	}

}
