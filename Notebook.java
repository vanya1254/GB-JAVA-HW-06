import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Notebook {
    private String[] rams = new String[]{"8", "16", "32", "64"};
    private String[] hdds = new String[]{"250", "500", "1000", "2000"};
    private String[] oss = new String[]{"MacOS", "Windows", "Linux"};
    private String[] colors = new String[]{"Black", "White", "Grey", "Red"};
    private Random rnd = new Random();
    private Map<Integer, String> notebook = new HashMap<>();
    private Integer[] keys = new Integer[]{1, 2, 3, 4};
    private String value;

    public Notebook(){
        this.value = "null";
        
        for (int i = 0; i < keys.length; i++) {
            this.notebook.put(keys[i], value);
        }
    }

    void createRndNotebook(){
        this.notebook.put(keys[0], rams[rnd.nextInt(0, 4)]);
        this.notebook.put(keys[1], hdds[rnd.nextInt(0, 4)]);
        this.notebook.put(keys[2], oss[rnd.nextInt(0, 3)]);
        this.notebook.put(keys[3], colors[rnd.nextInt(0, 4)]);
    }

    Map<Integer, String> getNotebook(){
        return notebook;
    }

    @Override
    public String toString() {
        return notebook.toString();
    }
}
