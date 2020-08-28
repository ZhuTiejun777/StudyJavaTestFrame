package JavaExercise.SetDemo;

public class Student {

    private String name;
    private int englishGrade;
    private int mathGrade;
    private int chineseGrade;
    private int totalGrade;

    public Student () {
        super();
    }

    public Student (String name, int englishGrade, int mathGrade, int chineseGrade) {
        super();
        this.name = name;
        this.englishGrade = englishGrade;
        this.mathGrade = mathGrade;
        this.chineseGrade = chineseGrade;
        this.totalGrade = englishGrade + mathGrade + chineseGrade;
    }

    public String getName() {
        return name;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEnglishGrade() {
        return englishGrade;
    }

    public void setEnglishGrade(int englishGrade) {
        this.englishGrade = englishGrade;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getChineseGrade() {
        return chineseGrade;
    }

    public void setChineseGrade(int chineseGrade) {
        this.chineseGrade = chineseGrade;
    }

    public String toString() {
        return name + "," + englishGrade + "," +mathGrade + "," +englishGrade + "," + totalGrade;
    }
}
