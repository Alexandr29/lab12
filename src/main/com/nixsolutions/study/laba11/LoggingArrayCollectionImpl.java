package main.com.nixsolutions.study.laba11;

import main.com.nixsolutions.study.laba10.ArrayCollectionImpl;
import interfaces.logging.LoggingArrayCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;

public class LoggingArrayCollectionImpl extends ArrayCollectionImpl

        implements LoggingArrayCollection {
    static org.slf4j.Logger logger = LoggerFactory
            .getLogger(LoggingArrayCollectionImpl.class.getSimpleName());

    public LoggingArrayCollectionImpl() {
    }

    @Override public Logger getLogger() {
        return logger;
    }

    @Override public boolean add(Object o) {
        logger.trace("Add method is running");
        try {
            return super.add(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;

    }

    @Override public boolean remove(Object o) {
        logger.trace("remove method is running");
        try {
            return super.remove(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;

    }

    @Override public int size() {
        logger.trace("size method is running");
        return super.size();
    }

    @Override public boolean isEmpty() {
        try {
            logger.trace("isEmpty method is running");
            return super.isEmpty();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override public boolean contains(Object o) {
        try {
            logger.trace("contains method is running");
            return super.contains(o);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }

    @Override public Iterator iterator() {
        logger.trace("iterator method is running");
        return super.iterator();
    }

    @Override public Object[] toArray() {
        logger.trace("toArray method is running");
        return super.toArray();
    }

    @Override public boolean addAll(Collection c) {
        try {
            logger.trace("addAll method is running");
            return super.addAll(c);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return false;
    }

    @Override public void clear() {
        try {
            logger.trace("clear method is running");
            super.clear();
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    @Override public boolean retainAll(Collection c) {
        try {
            logger.trace("retainAll method is running");
            return super.retainAll(c);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return false;
    }

    @Override public boolean removeAll(Collection c) {
        try {
            logger.trace("removeAll method is running");
            return super.removeAll(c);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return false;
    }

    @Override public boolean containsAll(Collection c) {
        try {
            logger.trace("containsAll method is running");
            return super.containsAll(c);
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return false;
    }

    @Override public Object[] getArray() {
        logger.trace("getArray method is running");
        return super.getArray();
    }

    @Override public void setArray(Object[] objects) {
        try {
            logger.trace("setArray method is running");
            super.setArray(objects);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    @Override public Object[] toArray(Object[] e) {
        logger.trace("toArray method is running");
        return super.toArray(e);
    }
}
