package examples;

import com.intuit.karate.KarateOptions;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@KarateOptions(tags = "@users")
class RunKarateIT {

    // this will run all *.feature files that exist in sub-directories
    // see https://github.com/intuit/karate#naming-conventions   
    @Test
    public void testParallel() {
        Results results = Runner.parallel(getClass(), 5);
        assertTrue(results.getFailCount() == 0, results.getErrorMessages());
    }

}
