package cn.jbit.entity;

/**
 * @author 任锯东
 * @date 2016-3-24 下午2:58:56
 */
public class Bookk {
	private int id;//图书编号
	private String name;//图书名称
	private String author;//作者
	private String type;//类型
	private String intro;//简介
	private int price;//价格
	private String publishdate;//出版时间	
	public Bookk() {
	}
	public Bookk(int id, String name, String author, String type, String intro,
			int price, String publishdate) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.type = type;
		this.intro = intro;
		this.price = price;
		this.publishdate = publishdate;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}


}
