public class MiaCD implements CD
{ 
	private static final int INIT_ARRAY_SIZE = 2;
	private Object[] array = new Object[INIT_ARRAY_SIZE];
	private int front = 0;
	private int back = 0;

	public void makeEmpty() {
		front = back = 0;
	}

	public boolean isEmpty() {
		return front == back;
	}

	public int size() {
		if (back >= front) {
			return back - front;
		} else {
			return back + (array.length - front);
		}
	}
	
	public void addFirst (Object x) {
		if (size() + 1 == array.length) resize();
		front = getModuleIndex(front - 1);
		array[getModuleIndex(front)] = x;
	}

	public void addLast (Object x) {
		if (size() +1  == array.length) resize();
		back = getModuleIndex(back + 1);
		array[getModuleIndex(back - 1)] = x;
	}

	public Object removeFirst () throws EmptyCDException {
		if (isEmpty()) throw new EmptyCDException();
		Object first = getFirst();
		front = getModuleIndex(front + 1);
		return first;
	}

	public Object removeLast () throws EmptyCDException {
		if (isEmpty()) throw new EmptyCDException();
		Object last = getLast();
		back = getModuleIndex(back - 1);
		return last;
	}

	public Object getFirst () throws EmptyCDException {
		if (isEmpty()) throw new EmptyCDException();
		return array[getModuleIndex(front)];
	}

	public Object getLast ()  throws EmptyCDException {
		if (isEmpty()) throw new EmptyCDException();
		return array[getModuleIndex(back - 1)];
	}

	private int getModuleIndex(int index) {
		int moduleIndex = index % array.length;
		if (moduleIndex < 0) moduleIndex = array.length + index;
		return moduleIndex;
	}

	private void resize() {
		Object[] resizedArray = new Object[array.length * 2];
		System.arraycopy(array, 0, resizedArray, 0, array.length);
		array = resizedArray;

		if (front > back) {
			System.arraycopy(array, 0, array, array.length / 2, front);
			back = back + array.length / 2;
		}

	}

	public String toString() {
		String output = getClass().getName() + "[";

		if (front <= back) {
			for (int i = front; i<back; i++) {
				output += (array[i] + ",");
			}
		} else {
			for (int i = front; i<array.length; i++) {
				output += (array[i] + ",");
			}
			for (int i = 0; i<back; i++) {
				output += (array[i] + ",");
			}
		}

		output += "]";
		return output;
	}
}