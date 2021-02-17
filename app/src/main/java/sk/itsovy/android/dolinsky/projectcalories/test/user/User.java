package sk.itsovy.android.dolinsky.projectcalories.test.user;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class User {

	@PrimaryKey(autoGenerate = true)
	@ColumnInfo(name = "id")
	private int id;

	@ColumnInfo(name = "height")
	private int height;

	@ColumnInfo(name = "weight")
	private int weight;

	@ColumnInfo(name = "todayTotal")
	private int todayTotal;

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getTodayTotal() {
		return todayTotal;
	}

	public void setTodayTotal(int todayTotal) {
		this.todayTotal = todayTotal;
	}

	@Override
	public String toString() {
		return height + "";
	}
}
