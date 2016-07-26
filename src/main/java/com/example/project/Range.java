package com.example.project;

public class Range<T extends Comparable<T>> {

	protected T lowerBound;
	protected T upperBound;
	protected Type type;

	protected Range(T lower, T upper, Type type) {
		if(lower.compareTo(upper) > 0){
			throw new RuntimeException("are you retarded?");
		}
		this.lowerBound = lower;
		this.upperBound = upper;
		this.type = type;
	}

	public boolean contains(T i) {
		return isInBoundary(i) || isOnBoundary(i);
	}

	public static <T extends Comparable<T>> Range<T> open(T i, T j) {
		return new Range<T>(i, j, Type.OPEN);
	}

	public static <T extends Comparable<T>> Range<T> closed(T i, T j) {
		return new Range<T>(i, j, Type.CLOSED);
	}

	public static <T extends Comparable<T>> Range<T> openClosed(T i, T j) {
		return new Range<T>(i, j, Type.OPENCLOSED);
	}

	public static <T extends Comparable<T>> Range<T> closedOpen(T i, T j) {
		return new Range<T>(i, j, Type.CLOSEDOPEN);
	}

	private boolean isOnBoundary(T i) {
		switch (this.type) {
		case OPEN:
			return false;
		case CLOSED:
			return i.compareTo(lowerBound) == 0 || i.compareTo(upperBound) == 0;
		case OPENCLOSED:
			return i.compareTo(upperBound) == 0;
		case CLOSEDOPEN:
			return i.compareTo(lowerBound) == 0 ;
		default:
			return false;
		}
	}

	private boolean isInBoundary(T i) {
		return i.compareTo(lowerBound)> 0 && i.compareTo(upperBound) < 0;

	}

	enum Type {
		OPEN, CLOSED, OPENCLOSED, CLOSEDOPEN;
	}

}
