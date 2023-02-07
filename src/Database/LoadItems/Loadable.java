package Database.LoadItems;

import java.util.List;

@FunctionalInterface
public interface Loadable<T> {
    List<T> load();
}