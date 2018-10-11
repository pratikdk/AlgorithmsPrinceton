import java.io.*;

public class ReadBinaryInput {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "C:/MyFiles/Code/Algorithms/Princeton/Part1/CustomGrid/src/customGrid4.txt"));
            String line = reader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
            String convergedBits = builder.toString();
            System.out.println(convergedBits.length());

            int[][] binaryGrid = new int[90][90];
            int p = 0, k = 0;
            for (int i = 0; i < convergedBits.length(); i++){
                //Process char
//                System.out.println("p = " + p + ", k = " + k + ", i = " + i);
                binaryGrid[p][k] = Character.getNumericValue(convergedBits.charAt(i));
                if (((i+1) % 90) == 0) {
                    p += 1;
                    k = 0;
//                    System.out.println("p = " + p + ", k = " + k);
                } else {  k++; }
            }

            // Print Binary Grid
            for (int i = 0; i < binaryGrid.length; i++) {
                for (int j = 0; j < binaryGrid[0].length; j++) {
                    System.out.print(binaryGrid[i][j]);
                }
                System.out.print("\n");
            }
            System.out.print("\n");

            // Print matrix co-ordinates
            StringBuilder outputDataBuilder = new StringBuilder();
            outputDataBuilder.append("" + binaryGrid.length + "\n");
            for (int i = 0; i < binaryGrid.length; i++) {
                for (int j = 0; j < binaryGrid[0].length; j++) {
                    if (binaryGrid[i][j] == 0) {
                        System.out.println((i+1) + " " + (j+1));
                        outputDataBuilder.append("" + (i+1) + " " + (j+1)+"\n");
                    }
                }
            }

            try (PrintWriter out = new PrintWriter("customGridFace3.txt")) {
                out.println(outputDataBuilder.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
