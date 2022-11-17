import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Editor editor = Editor.getEditor();
        while (true) {
            String file = scan.nextLine();
            String[] s = file.split("\\.");
            editor.show(s[1]);
        }

    }
}