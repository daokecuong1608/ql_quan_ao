package data;

import java.util.ArrayList;

public interface DAOInterface<T> {
	public  ArrayList<T> selectAll();
	public T selectById(T t);
	public void insert(T t);
	public void delete(T t);
	public void update(T t);
}