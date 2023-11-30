package Facade;

import java.util.ArrayList;
import java.util.List;

public class ColorFacade {
    private List<String> color = new ArrayList<>();
    public String getColor(int i) {
        return color.get(i);
    }
    public List<String> getColors() {
        return color;
    }
    public void setColor(String color) {
        this.color.add(color);
    }
}
