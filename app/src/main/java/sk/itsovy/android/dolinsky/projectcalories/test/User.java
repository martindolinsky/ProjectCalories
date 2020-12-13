package sk.itsovy.android.dolinsky.projectcalories.test;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private int id;

	@ColumnInfo(name = "text")
	private String text;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}
