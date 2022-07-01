package dograre.entity;

public class Card {

    String id;
    String name;
    String rareRank;
    String team;
    String description;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTeam() {
        return team;
    }

    public String getRareRank() {
        return rareRank;
    }

    public String getDescription() {
        return description;
    }

    public void setRareRank(String rareRank) {
        this.rareRank = rareRank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
