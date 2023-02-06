import Store.StatisticsStore;
import org.junit.Test;

public class StatisticsTest {


    @Test
    public void testNrOneStatistics() {

        StatisticsStore statisticsStore = new StatisticsStore(true);
        statisticsStore.runStatistics(1);


    }

    @Test
    public void testNrTwoStatistics() {
        StatisticsStore statisticsStore = new StatisticsStore(true);
        statisticsStore.runStatistics(2);
    }

    @Test
    public void testNrFiveStatistics() {
        StatisticsStore statisticsStore = new StatisticsStore(true);
        statisticsStore.runStatistics(5);
    }
}
