package lab12.task1;

public class ATM {
    private Section first;
    public ATM() {
        this.first=new Section_500();
        Section_200 section_200 = new Section_200();
        first.setNext(section_200);
    }
    public void getMeMoney(int amount) {
        first.process(amount);
    }
}
