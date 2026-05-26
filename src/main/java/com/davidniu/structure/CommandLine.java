package com.davidniu.structure;

public class CommandLine {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("no arguments");
            return;
        }


        System.out.println("args");
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println("args.length" + args.length);
        CommandLine commandLine = new CommandLine();
        commandLine.test(1, 2, 3, 4, 5,6);

    }

    public void test(int... i) {
        for (int arg : i) {
            System.out.println(arg);
        }
    }
}
