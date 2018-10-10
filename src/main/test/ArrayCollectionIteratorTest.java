import interfaces.task5.ArrayCollection;
import interfaces.task5.ArrayIterator;
import junit.framework.TestCase;
import main.com.nixsolutions.study.laba10.ArrayCollectionImpl;
import org.junit.Test;

import java.util.NoSuchElementException;

public class ArrayCollectionIteratorTest extends TestCase {
    private final ArrayCollection collection = new ArrayCollectionImpl();
    private final ArrayIterator iterator = (ArrayIterator) collection.iterator();

    @Test public void testNext(){
        try {
            iterator.next();
        } catch (Exception e) {
            assertEquals(NoSuchElementException.class, e.getClass());
        }

    }

}
