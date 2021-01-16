package sk.itsovy.android.dolinsky.projectcalories.test.drink;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "drinks")
public class Drink {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private int id;

	@ColumnInfo(name = "title")
	private String title;

	@ColumnInfo(name = "proteins")
	private int proteins;

	public Drink() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getProteins() {
		return proteins;
	}

	public void setProteins(int proteins) {
		this.proteins = proteins;
	}
}
