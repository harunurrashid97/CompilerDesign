package assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Assignment1 {
    
    

    public static void main(String[] args) {

        ArrayList<String> strLi = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File("C:\\Users\\harun\\Desktop\\test.txt"));
            while (sc.hasNextLine()) {
                String st = sc.nextLine();
                String[] temp = st.split(" ");
                for (String item : temp) {
                    strLi.add(item);
                }
            }
        } catch (Exception ex) {
            System.out.println("File not found!");;
        }

        ArrayList<String> Keywords = new ArrayList<>();
        ArrayList<String> Arithmetic_Operator = new ArrayList<>();
        ArrayList<String> Inc_Dec = new ArrayList<>();
        ArrayList<String> Assignment_Operator = new ArrayList<>();
        ArrayList<String> Relational_Operator = new ArrayList<>();
        ArrayList<String> Logical_Operator = new ArrayList<>();
        ArrayList<String> Bitwise_Operator = new ArrayList<>();
        ArrayList<String> Others = new ArrayList<>();

        //keyword
        Keywords.add("auto");
        Keywords.add("break");
        Keywords.add("case");
        Keywords.add("char");
        Keywords.add("const");
        Keywords.add("continue");
        Keywords.add("default");
        Keywords.add("do");
        Keywords.add("double");
        Keywords.add("else");
        Keywords.add("enum");
        Keywords.add("extern");
        Keywords.add("float");
        Keywords.add("for");
        Keywords.add("goto");
        Keywords.add("if");
        Keywords.add("int");
        Keywords.add("long");
        Keywords.add("register");
        Keywords.add("return");
        Keywords.add("short");
        Keywords.add("signed");
        Keywords.add("sizeof");
        Keywords.add("static");
        Keywords.add("struct");
        Keywords.add("switch");
        Keywords.add("typedef");
        Keywords.add("union");
        Keywords.add("unsigned");
        Keywords.add("void");
        Keywords.add("volatile");
        Keywords.add("while");

        //Arithmetic
        Arithmetic_Operator.add("+");
        Arithmetic_Operator.add("-");
        Arithmetic_Operator.add("*");
        Arithmetic_Operator.add("/");
        Arithmetic_Operator.add("%");

        //Increment_Decrement
        Inc_Dec.add("++");
        Inc_Dec.add("--");

        //others...
        Others.add("(");
        Others.add(")");
        Others.add("{");
        Others.add("}");
        Others.add("[");
        Others.add("]");
        Others.add(",");
        Others.add("'");
        Others.add("@");
        Others.add("#");
        Others.add("$");
        Others.add("^");
        Others.add("_");
        Others.add("-");
        Others.add("/");
        Others.add("?");
        Others.add(":");
        Others.add(";");
        Others.add("\"");
        Others.add(".");

        //Assignment
        Assignment_Operator.add("=");
        Assignment_Operator.add("+=");
        Assignment_Operator.add("-=");
        Assignment_Operator.add("*=");
        Assignment_Operator.add("/=");
        Assignment_Operator.add("%=");

        //Relational Operator
        Relational_Operator.add("==");
        Relational_Operator.add("<=");
        Relational_Operator.add(">=");
        Relational_Operator.add(">");
        Relational_Operator.add("<");
        Relational_Operator.add("!=");

        //Logical_Operator
        Logical_Operator.add("&&");
        Logical_Operator.add("||");
        Logical_Operator.add("!");

        //Bitwise_Operator
        Bitwise_Operator.add("&");
        Bitwise_Operator.add("|");
        Bitwise_Operator.add("^");
        Bitwise_Operator.add("-");
        Bitwise_Operator.add(">>");
        Bitwise_Operator.add("<<");

        HashSet<String> key = new HashSet<>();
        HashSet<String> id = new HashSet<>();
        HashSet<String> arithmetic = new HashSet<>();
        HashSet<String> increment = new HashSet<>();
        HashSet<String> assignment = new HashSet<>();
        HashSet<String> relational = new HashSet<>();
        HashSet<String> logical = new HashSet<>();
        HashSet<String> bitwise = new HashSet<>();
        HashSet<String> number = new HashSet<>();
        HashSet<String> other = new HashSet<>();

        for (String i : strLi) {

            if (Keywords.contains(i)) {
                key.add(i);
            } else if (Arithmetic_Operator.contains(i)) {
                arithmetic.add(i);
            } else if (Inc_Dec.contains(i)) {
                increment.add(i);
            } else if (Assignment_Operator.contains(i)) {
                assignment.add(i);
            } else if (Relational_Operator.contains(i)) {
                relational.add(i);
            } else if (Logical_Operator.contains(i)) {
                logical.add(i);
            } else if (Bitwise_Operator.contains(i)) {
                bitwise.add(i);
            } else if (isNumber(i)) {
                number.add(i);
            } else if (Others.contains(i)) {
                other.add(i);
            } else {
                id.add(i);
            }

        }

        System.out.println("Keyword: \n" + key);

        System.out.println("Identifiers: \n" + id);

        System.out.println("Arithmetic Operators:" + arithmetic);
        System.out.println("Assignment Operators:" + assignment);
        System.out.println("Bit Wise Operators:" + bitwise);
        System.out.println("Increment Decrement Operators:" + increment);
        System.out.println("Logical Operator:" + logical);
        System.out.println("Relational Operator:" + relational);
        System.out.println("Numarical Value:" + number);
        System.out.println("Others:" + other);
    }

    static boolean isNumber(String s) {
        try {
            int x = Integer.parseInt(s);

        } catch (Exception e) {

            return false;
        }

        return true;

    }

}
