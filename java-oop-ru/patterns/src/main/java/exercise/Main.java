package exercise;

public class Main {
    public static void main (String[] args) {

        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", inputTag);
        labelTag.render();

        System.out.println(inputTag.render());
        System.out.println(labelTag.render());

    }
}
