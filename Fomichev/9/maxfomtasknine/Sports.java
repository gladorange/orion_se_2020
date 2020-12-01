package maxfomtasknine;

import maxfomtasknine.annotations.XmlIgnore;
import maxfomtasknine.annotations.XmlName;
import maxfomtasknine.annotations.XmlTypeName;

@XmlTypeName(className = "Хоккейный турнир")
public class Sports {
    @XmlName(fieldName = "Фамилия игрока")
    String name;
    @XmlIgnore
    String position;
    @XmlName(fieldName = "Количество голов")
    int goal;

    public Sports() {
    }

    public Sports(String name, String position, int goal) {
        this.name = name;
        this.position = position;
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "Sports{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", goal=" + goal +
                '}';
    }
}
