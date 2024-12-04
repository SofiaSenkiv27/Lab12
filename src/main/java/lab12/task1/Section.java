package lab12.task1;

public abstract class Section {
    private int denomination;
    private Section next;

    public Section(int denomination) {
        this.denomination = denomination;
    }

    public void setNext(Section nextSection) { 
        this.next = nextSection;
    }

    private boolean hasNext() {
        return next != null;
    }

    public void process(int amount) {
        int left = amount % denomination;
        if (left != 0) {
            if (hasNext()) {
                next.process(left);
            } else {
                throw new IllegalArgumentException("Invalid exception");
            }
        }
        System.out.println("Denomination: "
                + denomination
                + " Quantity: "
                + amount / denomination);
    }
}
