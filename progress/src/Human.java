class Annoyance extends Exception {
}

class Sneeze extends Annoyance {
}

class Human {
    public static void main(String[] args) throws Exception{
        //里氏代换原则,能使用父类型的地方一定能使用子类型
        try {
            try {
                throw new Sneeze();
            } catch (Annoyance a) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        } catch (Sneeze sneeze) {
            System.out.println("Caught Sneeze");
            return;
        }finally {
            System.out.println("Hello world!");
        }
    }
}
