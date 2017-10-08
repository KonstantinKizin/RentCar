package ru.konstantin.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.*;

import static org.junit.Assert.assertTrue;

import ru.konstantin.Models.*;


public class OrderDaoTest {

    private static Order order;

    private static OrderDao orderDao;

    private static Client client;

    private static OrderItem orderItem;

    private static Brand brand;

    private static Car car;


    @BeforeClass
    public static void setUpClass(){
        orderDao = new OrderDao();

        client = new Client();
        client.setEmail("SomeEmail");
        client.setName("Name");
        client.setSureName("SureName");
        client.setPasNumber("PassNumber");

        brand = new Brand();
        brand.setBrand_name("Brand_Name");
        brand.setProducer("SomeProducer");

        car = new Car();
        car.setBrand(brand);
        car.setCarModel("Car_Model");
        car.setCountOf(5);
        car.setPricePerHoure(100);
        orderItem = new OrderItem();
        orderItem.setHour(5);
        orderItem.getCars().add(car);
        order = new Order();
        order.setClient(client);
        order.setOrderItems(orderItem);
    }

    @Before
    public void setUp(){
        orderDao.add(order);
    }

    @After
    public void after(){
        try(Session session =  orderDao.getSessionFactory().openSession()){
            session.beginTransaction();
            Query query =  session.createQuery("delete from Order");
            query.executeUpdate();
            session.getTransaction().commit();
        }
        assertTrue(orderDao.getAll().size() == 0);
    }


    @Test
    public void when_add_new_Order_getAll_method_should_return_incressed_size_by_one(){
        int size = orderDao.getAll().size();
        orderDao.add(new Order());
        assertTrue(orderDao.getAll().size() == (size + 1));

    }




}




