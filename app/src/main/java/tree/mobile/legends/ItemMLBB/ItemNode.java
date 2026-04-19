package tree.mobile.legends.ItemMLBB;
import java.util.ArrayList;
import java.util.List;

public class ItemNode {
    public String name;
    public List<ItemNode> children;

    public ItemNode(String name, String note) {
        this.name = name;
        this.children = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public List<ItemNode> getChildren() {
        return children;
    }
    public void addChild(ItemNode child) {
        children.add(child);
    }
}
