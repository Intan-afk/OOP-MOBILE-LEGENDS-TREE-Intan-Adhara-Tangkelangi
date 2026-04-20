package tree.mobile.legends.TREEMLBB;
import java.util.List;

import tree.mobile.legends.ItemMLBB.ItemNode;
public class TreeMlBB {
    public static void printTree(ItemNode node, int level) {
        if (node == null) return;
        System.out.println("  ".repeat(level) + "- " + node.getName());
        for (ItemNode child : node.getChildren()) {
            printTree(child, level + 1);
        }
    }
    public static void printAllBuildPaths(ItemNode node, List<String> path) {
        if (node == null) return;
        path.add(node.getName());
        if (node.getChildren().isEmpty()) {
            System.out.println(String.join(" -> ", path));
        } 
        for (ItemNode child : node.getChildren()) {
            printAllBuildPaths(child, path);
        }
        
        path.remove(path.size() - 1);
    }
    // total nodes
    public static int countNodes(ItemNode node) {
        if (node == null) return 0;
        int count = 1; // Count current node
        for (ItemNode child : node.getChildren()) {
            count += countNodes(child);
        }
        return count;
    }
    // total leaves
    public static int countLeaves(ItemNode node) {
        if (node.getChildren().isEmpty()) return 1; // Leaf node
        int count = 0;
        for (ItemNode child : node.getChildren()) {
            count += countLeaves(child);
        }
        return count;
    }

    public static int height(ItemNode node) {
        if (node.getChildren().isEmpty()) return 1;

        int maxHeight = 0;
        for (ItemNode child : node.getChildren()) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return maxHeight + 1; // Add current node
    }
    // find path to a specific item
    public static boolean findPath(ItemNode node, String target, List<String> path) {
        if (node == null) return false;
        path.add(node.getName());
        if (node.getName().equalsIgnoreCase(target)) {
            return true;
        }
        for (ItemNode child : node.getChildren()) {
            if (findPath(child, target, path)) {
                return true;
            }
        }
        path.remove(path.size() - 1); // Backtrack
        return false;
    }

    public static int countItemOccurrences(ItemNode node, String itemTarget) {
        if (node == null) return 0;
        int count = 0;
        if (node.getName().equalsIgnoreCase(itemTarget)) {
            count++;
        }
        for (ItemNode child : node.getChildren()) {
            count += countItemOccurrences(child, itemTarget);
        }
        return count;
    }
    public static void printPathToTarget(ItemNode node, String target, List<String> path) {
        path.add(node.getName());

        if (node.getName().equalsIgnoreCase(target)) {
            System.out.println(String.join(" -> ", path));
        }

        for (ItemNode child : node.getChildren()) {
            printPathToTarget(child, target, path);
        }

        path.remove(path.size() - 1);
    }
}