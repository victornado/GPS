package Prototipo;

public class Pair<E, T> {

	private E Elem1;
	private T Elem2;
	
	public Pair(E elem1, T elem2) {
		Elem1 = elem1;
		Elem2 = elem2;
	}
	
	public E getFirst() {
		return Elem1;
	}
	public T getSecond() {
		return Elem2;
	}
	public void setFirst(E e)
	{
		Elem1=e;
	}
	public void setSecond(T e)
	{
		Elem2=e;
	}
	
}
