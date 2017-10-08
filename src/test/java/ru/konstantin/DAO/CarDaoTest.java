package ru.konstantin.DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.konstantin.Models.Brand;
import ru.konstantin.Models.Car;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertTrue;

public class CarDaoTest {

    private static Car car;

    private static Brand brand;

    private static CarDao carDao;

    @BeforeClass
    public static void  setUpClass(){

        brand = new Brand();
        brand.setProducer("Germany");
        brand.setBrand_name("BMW");

        car = new Car();
        car.setPricePerHoure(100);
        car.setCountOf(4);
        car.setCarModel("X6");
        car.setBrand(brand);

        carDao = new CarDao();

    }

    @Before
    public void setUp(){
        carDao.add(car);
    }


    @After
    public void after(){

        if(carDao.getAll().size() != 0) {

            try (Session session = carDao.getSessionFactory().openSession()) {
                session.beginTransaction();
                Query query = session.createQuery("delete from Car");
                query.executeUpdate();
                session.getTransaction().commit();
            }
        }
        assertTrue(carDao.getAll().size() == 0);
    }



    @Test
    public void init(){

    }

    @Test
    public void addTest(){

        int size = carDao.getAll().size();
        carDao.add(new Car());
        assertTrue(carDao.getAll().size() == (size + 1));

    }


    @Test
    public void getTest(){

        Car car1 = carDao.get(5L);
        assertTrue(car.equals(car1));

    }


    @Test
    public void updateTest(){


        Car car1 = carDao.get(4L);
        car1.setCarModel("X3");
        carDao.update(car1);
        assertTrue(carDao.get(4L).getCarModel().equals("X3"));
    }


    @Test
    public void deleteByObjectTest(){

        carDao.deleteByObject(car);
        assertTrue(carDao.getAll().size() == 0);
    }











}
