package org.example.list;

import org.example.MyCollection;

public interface MyList<T> extends MyCollection<T> {

  T get(int index);

}
