package zjc.entity;
/**
 * 菜类信息实体类
 * @author Administrator
 *
 */
public class Classify {
	private String classname;
	private int classid;
	private int stutu;
	public int getStutu() {
		return stutu;
	}

	public void setStutu(int stutu) {
		this.stutu = stutu;
	}
	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}
}
