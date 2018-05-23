import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //-XX:-HeapDumpOnOutOfMemoryError  当抛出OOM时进行HeapDump
        //-Xms20m  -Xmx20m
        List<User> list = new ArrayList<>();

        while(true){
            list.add( new User());
        }

    }
}
