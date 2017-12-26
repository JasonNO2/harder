public class ChildOfOverloadOverride extends OverloadOverride {
    @Override
    String test2() {
        return "No please dont, my father";
    }

    public static void main(String[] args) {
        ChildOfOverloadOverride o = new ChildOfOverloadOverride();
        System.out.println(o.test2());
    }
}
