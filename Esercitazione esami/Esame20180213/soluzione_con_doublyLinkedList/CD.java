public interface CD
{ int size();
  boolean isEmpty();
  void addFirst (Object x);
  void addLast (Object x);
  Object removeFirst () throws EmptyCDException;
  Object removeLast () throws EmptyCDException;
  Object getFirst () throws EmptyCDException;
  Object getLast ()  throws EmptyCDException;
}

