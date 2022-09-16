
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private String filePath = "src/danske-postnumre-byer.csv";
    HashMap<String, String> cities = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
    private void run() {
        try {

            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while (line != null) {
                List<String> lineData = Arrays.asList(line.split(","));
                cities.put(lineData.get(0), lineData.get(1));
                line = br.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        input();

    }

    private void input() {
        String input = "";
        Scanner sc = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            while (input.length() != 4 && !tryParseInt(input)) {
                System.out.print("Indtast postnummer: ");
                input = sc.nextLine();
                System.out.println(getCity(input));
            }
            System.out.print("Continue? (y/n): ");
            String continueInput = sc.nextLine();;
            if (continueInput.equals("n")) {
                isRunning = false;
            } else if (continueInput.equals("y")) {
                input = "";
            }
        }

    }

    private String getCity(String zipCode) {
        return cities.get(zipCode);
    }


    public boolean tryParseInt(String str) {
        try {
            Integer.parseInt(str);
        } catch (Exception E) {
            return false;
        }
        return true;
    }
}