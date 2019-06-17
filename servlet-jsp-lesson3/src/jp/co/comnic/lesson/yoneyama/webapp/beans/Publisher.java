package jp.co.comnic.lesson.yoneyama.webapp.beans;

public class Publisher {

	private Integer id;
	private String name;

	public Publisher() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Publisher [id=" + id + ", name=" + name + "]";
	}
}
