package Database.LoadItems;

import java.util.List;

public class DataLoader extends CustomerLoader {

    public <T> List<T> loadData(Loadable<T> loader){
        return loader.load();
    }

}
