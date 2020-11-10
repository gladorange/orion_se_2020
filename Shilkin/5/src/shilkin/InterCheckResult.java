package shilkin;

public class InterCheckResult {
    private boolean isIntersect = false;
    private String element = "";

    public boolean isIntersect() {
        return isIntersect;
    }

    public void setIntersect(boolean intersect) {
        isIntersect = intersect;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
