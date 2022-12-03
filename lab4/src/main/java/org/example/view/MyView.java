package org.example.view;

import org.example.controller.*;
import org.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {

    @Autowired
    private ShopController shopController;
    @Autowired
    private ProductController productController;
    @Autowired
    private CustomerController customerController;
    @Autowired
    private DeliveryController deliveryController;
    @Autowired
    private DeliveryProductsController deliveryProductsController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);
    private final Shop nullShop = new Shop(null, null, null, null);
    private final Product nullProduct = new Product(null, null, null, null, null, null, null, null, null);
    private final Customer nullCustomer = new Customer(null, null, null, null, null);
    private final Delivery nullDelivery = new Delivery(null, null, null, null, null);
    private final DeliveryProducts nullDeliveryProducts= new DeliveryProducts(null, null, null, null, null);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("1", "   1 - Table: Shop");
        menu.put("11", "  11 - Create Shop");
        menu.put("12", "  12 - Update Shop");
        menu.put("13", "  13 - Delete from Shop");
        menu.put("14", "  14 - Find all Shops");
        menu.put("15", "  15 - Find Shop by ID");
        menu.put("16", "  16 - Find Shop by adress");
        menu.put("17", "  17 - Find Shop by city");

        menu.put("2", "   2 - Table: Product");
        menu.put("21", "  21 - Create Product");
        menu.put("22", "  22 - Update Product");
        menu.put("23", "  23 - Delete from Product");
        menu.put("24", "  24 - Find all Products");
        menu.put("25", "  25 - Find Product by ID");
        menu.put("26", "  26 - Find Product by name");
        menu.put("27", "  27 - Find available Product");

        menu.put("3", "   3 - Table: Customer");
        menu.put("31", "  31 - Create Customer");
        menu.put("32", "  32 - Update Customer");
        menu.put("33", "  33 - Delete from Customer");
        menu.put("34", "  34 - Find all Customers");
        menu.put("35", "  35 - Find Customer by ID");
        menu.put("36", "  36 - Find Customer by phone");

        menu.put("4", "   4 - Table: Delivery");
        menu.put("41", "  41 - Create Delivery");
        menu.put("42", "  42 - Update Delivery");
        menu.put("43", "  43 - Delete from Delivery");
        menu.put("44", "  44 - Find all Deliveries");
        menu.put("45", "  45 - Find Delivery by ID");
        menu.put("46", "  46 - Find Delivery by ordered time");

        menu.put("5", "   5 - Table: DeliveryProducts");
        menu.put("51", "  51 - Create DeliveryProducts");
        menu.put("52", "  52 - Update DeliveryProducts");
        menu.put("53", "  53 - Delete from DeliveryProducts");
        menu.put("54", "  54 - Find all DeliveryProducts");
        menu.put("55", "  55 - Find DeliveryProducts by ID");
        menu.put("56", "  56 - Find DeliveryProducts by delivery id");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("11", this::createShop);
        methodsMenu.put("12", this::updateShop);
        methodsMenu.put("13", this::deleteFromShop);
        methodsMenu.put("14", this::findAllShops);
        methodsMenu.put("15", this::findShopById);
        methodsMenu.put("16", this::findShopByAdress);
        methodsMenu.put("17", this::findShopByCity);

        methodsMenu.put("21", this::createProduct);
        methodsMenu.put("22", this::updateProduct);
        methodsMenu.put("23", this::deleteFromProduct);
        methodsMenu.put("24", this::findAllProducts);
        methodsMenu.put("25", this::findProductById);
        methodsMenu.put("26", this::findProductByName);
        methodsMenu.put("27", this::findAvailableProduct);

        methodsMenu.put("31", this::createCustomer);
        methodsMenu.put("32", this::updateCustomer);
        methodsMenu.put("33", this::deleteFromCustomer);
        methodsMenu.put("34", this::findAllCustomers);
        methodsMenu.put("35", this::findCustomerById);
        methodsMenu.put("36", this::findCustomerByPhone);

        methodsMenu.put("41", this::createDelivery);
        methodsMenu.put("42", this::updateDelivery);
        methodsMenu.put("43", this::deleteFromDelivery);
        methodsMenu.put("44", this::findAllDeliveries);
        methodsMenu.put("45", this::findDeliveryById);
        methodsMenu.put("46", this::findDeliveryByOrderTime);

        methodsMenu.put("51", this::createDeliveryProducts);
        methodsMenu.put("52", this::updateDeliveryProducts);
        methodsMenu.put("53", this::deleteFromDeliveryProducts);
        methodsMenu.put("54", this::findAllDeliveryProducts);
        methodsMenu.put("55", this::findDeliveryProductsById);
        methodsMenu.put("56", this::findDeliveryProductsByDeliveryId);
    }

    private void selectAllTable() {
        findAllShops();
        findAllProducts();
        findAllCustomers();
        findAllDeliveries();
        findAllDeliveryProducts();
    }

    // region SHOP ---------------------------------------------------
    private void createShop() {
        System.out.println("Input 'country': ");
        String shopCountry = input.nextLine();
        System.out.println("Input 'city': ");
        String shopCity = input.nextLine();
        System.out.println("Input 'adress': ");
        String shopAdress = input.nextLine();
        Shop shop = new Shop(null, shopCountry, shopCity, shopAdress);

        int count = shopController.create(shop);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateShop() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'country': ");
        String shopCountry = input.nextLine();
        System.out.println("Input new 'city': ");
        String shopCity = input.nextLine();
        System.out.println("Input new 'adress': ");
        String shopAdress = input.nextLine();
        Shop shop = new Shop(null, shopCountry, shopCity, shopAdress);

        int count = shopController.update(id, shop);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromShop() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = shopController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllShops() {
        System.out.println("\nTable: SHOP");
        List<Shop> shops = shopController.findAll();
        for (Shop shop : shops) {
            System.out.println(shop);
        }
    }

    private void findShopById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Shop> shop = shopController.findById(id);
        System.out.println(shop.orElse(nullShop));
    }

    private void findShopByAdress() {
        System.out.println("Input 'adress': ");
        String shopAdress = input.nextLine();

        Optional<Shop> shop = shopController.findByAdress(shopAdress);
        System.out.println(shop.orElse(nullShop));
    }

    private void findShopByCity() {
        System.out.println("Input 'city': ");
        String city = input.nextLine();

        List<Shop> shops = shopController.findByCity(city);
        for (Shop shop : shops) {
            System.out.println(shop);
        }
    }

    //endregion
    // region PRODUCT ---------------------------------------------------
    private void createProduct() {
        System.out.println("Input 'shop_id': ");
        Integer productShopId = Integer.valueOf(input.nextLine());
        System.out.println("Input 'manufacturer': ");
        String productManufacturer = input.nextLine();
        System.out.println("Input 'name': ");
        String productName = input.nextLine();
        System.out.println("Input 'category': ");
        String productCategory = input.nextLine();
        System.out.println("Input 'price': ");
        Double productPrice = Double.valueOf(input.nextLine());
        System.out.println("Input 'arrived': ");
        String productArrived = input.nextLine();
        System.out.println("Input 'expired': ");
        String productExpired = input.nextLine();
        System.out.println("Input 'is_available': ");
        Boolean productAvailable = input.nextBoolean();
        Product product = new Product(null, productShopId, productManufacturer, productName,
                productCategory, productPrice, productArrived, productExpired, productAvailable);

        int count = productController.create(product);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateProduct() {
        System.out.println("Input 'id': ");
        Integer productId = Integer.valueOf(input.nextLine());

        System.out.println("Input new 'shop_id': ");
        Integer productShopId = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'manufacturer': ");
        String productManufacturer = input.nextLine();
        System.out.println("Input new 'name': ");
        String productName = input.nextLine();
        System.out.println("Input new 'category': ");
        String productCategory = input.nextLine();
        System.out.println("Input new 'price': ");
        Double productPrice = Double.valueOf(input.nextLine());
        System.out.println("Input new 'arrived': ");
        String productArrived = input.nextLine();
        System.out.println("Input new 'expired': ");
        String productExpired = input.nextLine();
        System.out.println("Input new 'is_available': ");
        Boolean productAvailable = input.nextBoolean();
        Product product = new Product(null, productShopId, productManufacturer, productName,
                productCategory, productPrice, productArrived, productExpired, productAvailable);

        int count = productController.update(productId, product);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromProduct() {
        System.out.println("Input 'id': ");
        Integer productId = Integer.valueOf(input.nextLine());

        int count = productController.delete(productId);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllProducts() {
        System.out.println("\nTable: PRODUCT");
        List<Product> products = productController.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private void findProductById() {
        System.out.println("Input 'id': ");
        Integer productId = Integer.valueOf(input.nextLine());

        Optional<Product> city = productController.findById(productId);
        System.out.println(city.orElse(nullProduct));
    }

    private void findProductByName() {
        System.out.println("Input 'name': ");
        String productName = input.nextLine();

        Optional<Product> product = productController.findByName(productName);
        System.out.println(product.orElse(nullProduct));
    }

    private void findAvailableProduct() {
        System.out.println("Input 'is_available': ");
        Boolean productIsAvailable = input.nextBoolean();

        List<Product> products = productController.findAvailable(productIsAvailable);
        for (Product product : products) {
            System.out.println(product);
        }
    }

    // endregion
    // region CUSTOMER -------------------------------------------------
    private void createCustomer() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();
        System.out.println("Input 'surname': ");
        String surname = input.nextLine();
        System.out.println("Input 'phone': ");
        String phone = input.nextLine();
        System.out.println("Input 'adress': ");
        String adress = input.nextLine();

        Customer customer = new Customer(null, name, surname, phone, adress);

        int count = customerController.create(customer);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCustomer() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'surname': ");
        String surname = input.nextLine();
        System.out.println("Input new 'phone': ");
        String phone = input.nextLine();
        System.out.println("Input new 'adress': ");
        String adress = input.nextLine();

        Customer customer = new Customer(null, name, surname, phone, adress);

        int count = customerController.update(id, customer);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCustomer() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = customerController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCustomers() {
        System.out.println("\nTable: CUSTOMER");
        List<Customer> customers = customerController.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void findCustomerById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Customer> customer = customerController.findById(id);
        System.out.println(customer.orElse(nullCustomer));
    }

    private void findCustomerByPhone() {
        System.out.println("Input 'phone': ");
        String phone = input.nextLine();

        Optional<Customer> customer = customerController.findByPhone(phone);
        System.out.println(customer.orElse(nullCustomer));
    }

    //endregion
    // region DELIVERY -------------------------------------------------
    private void createDelivery() {
        System.out.println("Input 'customer_id': ");
        Integer customer_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'ordered_time': ");
        String ordered_time = input.nextLine();
        System.out.println("Input 'time': ");
        String time = input.nextLine();
        System.out.println("Input 'urgency_price': ");
        Double urgency_price = Double.valueOf((input.nextLine()));

        Delivery delivery = new Delivery(null, customer_id, ordered_time, time, urgency_price);

        int count = deliveryController.create(delivery);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDelivery() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'customer_id': ");
        Integer customer_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'ordered_time': ");
        String ordered_time = input.nextLine();
        System.out.println("Input 'time': ");
        String time = input.nextLine();
        System.out.println("Input 'urgency_price': ");
        Double urgency_price = Double.valueOf((input.nextLine()));

        Delivery delivery = new Delivery(null, customer_id, ordered_time, time, urgency_price);

        int count = deliveryController.update(id, delivery);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromDelivery() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = deliveryController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllDeliveries() {
        System.out.println("\nTable: DELIVERY");
        List<Delivery> deliveries = deliveryController.findAll();
        for (Delivery delivery : deliveries) {
            System.out.println(delivery);
        }
    }

    private void findDeliveryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Delivery> delivery = deliveryController.findById(id);
        System.out.println(delivery.orElse(nullDelivery));
    }

    private void findDeliveryByOrderTime() {
        System.out.println("Input 'ordered_time': ");
        String ordered_time = input.nextLine();

        Optional<Delivery> delivery = deliveryController.findByOrderTime(ordered_time);
        System.out.println(delivery.orElse(nullDelivery));
    }

    //endregion
    // region DELIVERY_PRODUCTS -------------------------------------------------
    private void createDeliveryProducts() {
        System.out.println("Input 'product_id': ");
        Integer product_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'delivery_id': ");
        Integer delivery_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'quantity': ");
        Integer quantity = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'weight': ");
        Double weight = Double.valueOf((input.nextLine()));
        System.out.println("Input 'price': ");
        Double price = Double.valueOf((input.nextLine()));

        DeliveryProducts deliveryProducts = new DeliveryProducts(product_id, delivery_id, quantity, weight, price);

        int count = deliveryProductsController.create(deliveryProducts);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateDeliveryProducts() {
        System.out.println("Input 'id': ");
        Pair<Integer, Integer> id = Pair.of(Integer.valueOf((input.nextLine())), Integer.valueOf((input.nextLine())));

        System.out.println("Input new 'product_id': ");
        Integer product_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'delivery_id': ");
        Integer delivery_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'quantity': ");
        Integer quantity = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'weight': ");
        Double weight = Double.valueOf((input.nextLine()));
        System.out.println("Input new 'price': ");
        Double price = Double.valueOf((input.nextLine()));

        DeliveryProducts deliveryProducts = new DeliveryProducts(product_id, delivery_id, quantity, weight, price);

        int count = deliveryProductsController.update(id, deliveryProducts);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromDeliveryProducts() {
        System.out.println("Input 'id': ");
        Pair<Integer, Integer> id = Pair.of(Integer.valueOf((input.nextLine())), Integer.valueOf((input.nextLine())));

        int count = deliveryProductsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllDeliveryProducts() {
        System.out.println("\nTable: DELIVERY");
        List<DeliveryProducts> deliveriesProducts = deliveryProductsController.findAll();
        for (DeliveryProducts deliveryProducts : deliveriesProducts) {
            System.out.println(deliveryProducts);
        }
    }

    private void findDeliveryProductsById() {
        System.out.println("Input 'id': ");
        Pair<Integer, Integer> id = Pair.of(Integer.valueOf((input.nextLine())), Integer.valueOf((input.nextLine())));;

        Optional<DeliveryProducts> deliveryProducts = deliveryProductsController.findById(id);
        System.out.println(deliveryProducts.orElse(nullDeliveryProducts));
    }

    private void findDeliveryProductsByDeliveryId() {
        System.out.println("Input 'delivery_id': ");
        Integer delivery_id = Integer.valueOf(input.nextLine());

        List<Integer> deliveriesProducts = deliveryProductsController.findByDelivery(delivery_id);
        for (Integer deliveryProducts : deliveriesProducts) {
            System.out.println(deliveryProducts);
        }
    }
    //endregion

    //-------------------------------------------------------------------------
    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    //endregion
}

