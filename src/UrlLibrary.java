import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {
    private LinkedList<String> urls = new LinkedList<>();

    private class UrlIterator implements Iterator<String>{

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < urls.size();
        }

        @Override
        public String next() {
            index++;
            return urls[]
        }

        @Override
        public void remove() {
            urls.remove(index);
        }
    }

    public UrlLibrary(){
        urls.add("www.facebook.com");
        urls.add("www.google.com");
        urls.add("www.grubhub.com");
    }

    /* Simple iterator
    @Override
    public Iterator<String> iterator(){
        return urls.iterator();
    }*/

    @Override
    public Iterator<String> iterator(){

    }

}
