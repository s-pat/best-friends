
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class NetworkAnalysis {

    private void writeData(String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        //write information begin
        for (int i = 0; i < 10; i++) {
            bw.write(i + "\n");
        }
        //write information end
        bw.close();
    }

    private void readData(String filename) throws FileNotFoundException, IOException {
        ArrayList information = new ArrayList();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        //read information begin
        while ((line = br.readLine()) != null) {
            information.add(line);
            System.out.println(information.get(information.size() - 1));
        }
        //read information end
    }

    private void loadInformation(String filename) throws FileNotFoundException, IOException {
        ArrayList nodeName = new ArrayList();
        int[][] relationship = new int[1][1];

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        Boolean getNodeInformation = false;
        Boolean getRelationshipInformation = false;

        //begin read information
        while ((line = br.readLine()) != null) {
            if (line.startsWith("*")) {// change the control parameter
                if (line.startsWith("*Vertices")) {
                    getNodeInformation = true;
                    getRelationshipInformation = false;
                }
                if (line.startsWith("*Edges")) {
                    getNodeInformation = false;
                    getRelationshipInformation = true;
                    relationship
                            = new int[nodeName.size()][nodeName.size()];
                }
            } else {//update the related parameter
                if (getNodeInformation) {
                    String name
                            = line.substring(line.indexOf(" ") + 1);
                    nodeName.add(name);
                }
                if (getRelationshipInformation) {
                    String[] index = line.split(" ");
                    relationship[Integer.parseInt(index[0]) - 1][Integer.parseInt(index[1]) - 1] = 1;
                    relationship[Integer.parseInt(index[1]) - 1][Integer.parseInt(index[0]) - 1] = 1;
                }
            }
        }
        //end read information

        for (int i = 0; i < nodeName.size(); i++) {
            System.out.print("," + nodeName.get(i));
        }
        System.out.print("\n");

        for (int i = 0; i < nodeName.size(); i++) {
            System.out.print(nodeName.get(i).toString());
            for (int j = 0; j < nodeName.size(); j++) {
                System.out.print("," + relationship[i][j]);
            }
            System.out.print("\n");
        }
    }

    private void getVertices(String filename) throws FileNotFoundException, IOException {
        //Initial Vars for reading files and storing data
        ArrayList vertNames = new ArrayList();
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        int vertCounter = 0;
        int edgeCounter = 0;
        String line;
        String[] test = null;
        String[] edge = null;
        ArrayList testing = new ArrayList();
        String quoteMark = "\"";
        //Reading first line names and vertices
        ArrayList stringTest = new ArrayList();
        while ((line = br.readLine()) != null) {
            if (line.startsWith(",")) {
                test = line.split(",");

            }
        }
        //Printing Verticies
        System.out.print("*Vertices " + test.length);
        System.out.print("\n");
        for (int i = 1; i < test.length; i++) {
            System.out.println(i + " " + test[i]);

            // System.out.print("\n");
        }//end of adjacencyToEd
    }

    private void getEdges(String filename, String outFile) throws FileNotFoundException, IOException {
        //ArrayList vertNames = new ArrayList();
        Vector<Vector<Integer>> testing = new Vector<Vector<Integer>>();
        ArrayList list = new ArrayList();
        FileReader fr = new FileReader(filename);
        FileWriter fr2 = new FileWriter(outFile);
        BufferedReader br = new BufferedReader(fr);
        BufferedWriter wr = new BufferedWriter(fr2);
        int[][] points = null;
        int edgeCounter = 0;
        String line;
        String[] test = null;
        String[] edge = null;
        //Reading first line names and vertices
        //System.out.println("\n");
        System.out.print("*Edges" + "\n");
        while ((line = br.readLine()) != null) {
            if (line.startsWith(",")) {
                test = line.split(",");

            }//end of 1st if
            //System.out.print("\n");
            if (line.startsWith("\"")) {
                edge = line.split(",");
                edgeCounter++;
                for (int i = 1; i < test.length; i++) {
                    //System.out.print(edge[i]);
                    for (int k = 0; k < edge[i].length(); k++) {
                        if (edge[i].substring(k).equals("0")) {
                            continue;
                        }
                        if (edge[i].substring(k).equals("1")) {
                            //System.out.println(edge[i].substring(k)); 
                            //testing.add();

                            wr.write(edgeCounter + " " + i + "\n");
                            System.out.println(edgeCounter + " " + i);

                            // System.out.println(edgeCounter +" " + i);
                        }

                    }//end of inner for

                    // System.out.print("\n");
                }//end of outer for
                //testing how fast i can ty
            }
        }// end of while
        wr.close();
    }

    private void removeDuplicates(String filename) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] part = null;
        System.out.println("Testing Remove Dupilicates");
        Map<String, String> holder = new HashMap<String, String>();
        while ((line = br.readLine()) != null) {
            int hold = 0;
            part = line.split(" ");
            
            //System.out.println(part[0] + " + "+ part[1] +" = " + (Integer.parseInt(part[0]) + Integer.parseInt(part[1])));
            //
        }

        //holder.forEach((key, value) -> System.out.println( "\n" + key + ":" + value));
    }

    public static void main(String[] args) throws IOException {
        NetworkAnalysis test = new NetworkAnalysis();
        //test.loadInformation();

        // test.writeData("test.txt");
        //test.readData("adj_matrix.txt");
        test.getVertices("adj_matrix.txt");
        test.getEdges("adj_matrix.txt", "test.txt");
        test.removeDuplicates("test.txt");
    }
}// end of Class
//
