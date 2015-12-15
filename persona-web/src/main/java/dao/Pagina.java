package dao;

import java.util.List;

public class Pagina<T> {
	private List<T> data;
	private long count;

	public Pagina(List<T> data, Long count) {
		this.data = data;
		this.count = count;
	}

	public List<T> getData() {
		return data;
	}
	
	public void setData(List<T> data) {
		this.data = data;
	}
	
	public long getCount() {
		return count;
	}
	
	public void setCount(long count) {
		this.count = count;
	}
}
