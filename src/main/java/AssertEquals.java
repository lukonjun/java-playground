public class AssertEquals {

    // https://www.baeldung.com/java-assert
    public static void main(String[] args) {
        // to enable assertions in intellij Run > Edit Configurations... > Configuration > VM options > -ea
        String[] fruits = new String[]{"banana","apple"};
        assert fruits[0] == fruits[1] : "Not the same fruit";
    }

}
