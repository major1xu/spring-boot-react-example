import java.io.*;
import java.util.*;
/*
H1 something
H2 something
H3 something
H3 something
H2 something
H3 something

on Mac use Command D to indicate end of file (IntelliJ terminal)
 */
class navigateHeadings
{
    public static class Heading {
        protected int weight;
        protected String text;

        public Heading(int weight, String text) {
            this.weight = weight;
            this.text = text;
        }
    }
    public static class Node {
        protected Heading heading;
        protected List<Node> children;

        public Node(Heading heading) {
            this.heading = heading;
            this.children = new ArrayList<>();
        }
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Heading> headings = new ArrayList<>();
        int number_of_lines = 0;
        for (String line = br.readLine(); line != null; line = br.readLine()) {
            headings.add(parse(line));
            System.out.println("number_of_lines= "+number_of_lines);

            number_of_lines++;
        }
        System.out.println("number_of_lines= "+number_of_lines);

        Node outline = toOutline(headings);
        String html = toHtml(outline);
        System.out.println(html);
    }

    private static Node toOutline(List<Heading> headings) {
        // Implement this function. Sample code below builds an
        // outline of only the first heading.

        Node root = new Node(new Heading(0, ""));
        Node allAboutBirds = new Node(headings.get(0));

        int headings_length= headings.size();

        int previous_weight = headings.get(0).weight;
        Node previousGrandParent = allAboutBirds;
        Node previousParent = allAboutBirds;
        Node parentNode = allAboutBirds;

        for(int ii=1; ii<headings_length; ii++)
        {
            int weight = headings.get(ii).weight;
            //System.out.println("weight=" + weight);
            String text = headings.get(ii).text;
            //System.out.println("text=" + text);
            // going down one level
            if(weight == previous_weight+1)
            {
                Node childNode = new Node(headings.get(ii));
                parentNode.children.add(childNode);
                previousGrandParent = previousParent;
                previousParent = parentNode;
                parentNode = childNode;
                previous_weight = weight;
            }
            // siberling case
            else if (weight == previous_weight)
            {
                Node childNode = new Node(headings.get(ii));
                previousParent.children.add(childNode);
                parentNode = childNode;
            }
            // potentially going back up, from H3 The Swan to H2 Habitats for example, grand parent???
            else if (weight == previous_weight - 1)
            {
                // still some issues for two test cases.... because below is hard coded... for test 1...
                parentNode = previousGrandParent;
                Node childNode = new Node(headings.get(ii));
                parentNode.children.add(childNode);

                previousGrandParent = previousParent;
                previousParent = parentNode;
                parentNode = childNode;
                previous_weight = weight;
            }
        }

        root.children.add(allAboutBirds);
        return root;
    }

    /** Parses a line of input.
     This implementation is correct for all predefined test cases. */
    private static Heading parse(String record) {
        String[] parts = record.split(" ", 2);
        int weight = Integer.parseInt(parts[0].substring(1));
        Heading heading = new Heading(weight, parts[1].trim());
        return heading;
    }

    /** Converts a node to HTML.
     This implementation is correct for all predefined test cases. */
    private static String toHtml(Node node) {
        StringBuilder buf = new StringBuilder();
        if (!node.heading.text.isEmpty()) {
            buf.append(node.heading.text);
            buf.append("\n");
        }
        Iterator<Node> iter = node.children.iterator();
        if (iter.hasNext()) {
            buf.append("<ol>");

            while (iter.hasNext()) {
                Node child = iter.next();
                buf.append("<li>");
                buf.append(toHtml(child));
                buf.append("</li>");
                if (iter.hasNext()) {
                    buf.append("\n");
                }
            }
            buf.append("</ol>");
        }
        return buf.toString();
    }
}