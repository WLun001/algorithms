package practice.containerStorage;

public class ContainerStorageTester {

    public static void main(String[] args) {

        try {
            ContainerStorage containerStorage = new ContainerStorage();
            Container container = new Container("Container 1");
            Container container2 = new Container("Container 2");

            containerStorage.load(container, 0, 0);
            containerStorage.load(container2, 0, 0);

            System.out.print(containerStorage.unload(container2.getId(), 0, 0).getDescription());
        } catch (Error e) {
            System.out.print(e);
        }

    }
}
