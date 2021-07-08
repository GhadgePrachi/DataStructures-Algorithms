package datastructures.stacks.tough;

import java.util.LinkedList;
import java.util.Stack;

public class ShortestPath {
    public static String DIRECTORY_SEPARATOR = "/";
    public static String shortenPath(String path) {
        boolean isAbsolutePath = false;
        Stack<String> subPathNames = new Stack<>();

        if (path.charAt(0) == '/') {
            isAbsolutePath = true;
        }

        //Process subpaths
        String[] subPaths = path.split("/");
        for (String subPath : subPaths) {
            if (subPath.equals("") || subPath.equals(".")){
                continue;
            } else if (subPath.equals("..")) {
                if (isAbsolutePath) {
                    if (!subPathNames.isEmpty())
                        subPathNames.pop();
                } else {
                    if (subPathNames.isEmpty() || subPathNames.peek().equals("..")) {
                        subPathNames.push("..");
                    } else if (!subPathNames.isEmpty()){
                        subPathNames.pop();
                    }
                }
            } else {
                subPathNames.push(subPath);
            }
        }

        //Process stack
        LinkedList<String> result = new LinkedList<>();
        while (!subPathNames.isEmpty()) {
            String subPathName = subPathNames.pop();
            result.add(0, subPathName);
            if (!subPathNames.isEmpty() || isAbsolutePath) {
                result.add(0, DIRECTORY_SEPARATOR);
            }
        }
        String stringResult = String.join("", result);
        return stringResult.equals("") ? "/" : stringResult;
    }
}
