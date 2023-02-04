package Databas;

import java.util.List;

@FunctionalInterface
public interface Loadable<T> {
    List<T> load();
}