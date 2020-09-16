package frame.study.Bean;

public class Student {

    private long Id;
    private String Name;
    private String Card;

    public Student () {};

    public Student (long id, String name, String Card) {
        super();
        this.Id = id;
        this.Name = name;
        this.Card = Card;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String card) {
        Card = card;
    }

    @Override
    public String toString () {
        return "Student [Id=" + Id + ", Name=" + Name + ", Card=" + Card + "]";
    }
}