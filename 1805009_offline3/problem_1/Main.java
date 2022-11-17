import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


class sum_space_sep_file {
    public int calculate_sum(File file) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = br.readLine();
        String[] arr = str.split(" ");
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += Integer.parseInt(arr[i]);
        br.close();
        return sum;

    }
}

interface calculate_sum {
    public int calculate_sum(File file) throws Exception;
}


class FileAdapter implements calculate_sum {

    public int calculate_sum(File file) throws Exception {
        FileWriter temp = new FileWriter("temp.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = br.readLine();
        String[] arr = str.split("~");
        for (int i = 0; i < arr.length; i++)
            temp.write(arr[i] + " ");

        temp.close();
        br.close();
        File f = new File("temp.txt");
        f.deleteOnExit();

        sum_space_sep_file obj = new sum_space_sep_file();

        return obj.calculate_sum(f);

    }

}

class calculate_sum_any_file {
    FileAdapter adapter;

    public int calculate_sum(File file) throws Exception {
        adapter = new FileAdapter();
        return adapter.calculate_sum(file);

    }

}

public class Main {
    public static void main(String[] args) {
        calculate_sum_any_file obj = new calculate_sum_any_file();
        File file = new File("input.txt");
        try {
            System.out.println(obj.calculate_sum(file));
        } catch (Exception e) {

        }
    }
}