import controllers.SuperHeroController;
import dto.Superhero;
import io.restassured.response.Response;
import net.datafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuperHeroTests extends SuperHeroController {
    static Faker faker = new Faker();
    public static Superhero positiveHero(){
        return Superhero.builder()
                .fullName(faker.superhero().name())
                .birthDate(faker.timeAndDate().birthday("YYYY-MM-dd"))
                .phone(faker.phoneNumber().phoneNumber())
                .mainSkill(faker.superhero().power())
                .city(faker.address().city())
                .gender("M")
                .build();
    }

    public String createSuperHeroReturnId(){
        Superhero superhero = positiveHero();
        Response response = createSuperHero(superhero);
        Superhero superhero1 = response.getBody().as(Superhero.class);
        String id = Integer.toString(superhero1.getId());
        return Integer.toString(superhero1.getId());
    }



    @Test
    public void createSuperHeroPositiveTest(){
        Superhero superhero = positiveHero();
        System.out.println(superhero.toString());
        Response response = createSuperHero(superhero);
        Superhero superhero1 = response.getBody().as(Superhero.class);
        System.out.println(superhero1.toString());
        System.out.println(response.getBody().asString());
        Assert.assertEquals(response.getStatusCode(), 200);
    }


    @Test
    public void getAllSuperHeroesPositiveTest(){
        Assert.assertEquals(getAllSuperHeroes().getStatusCode(), 200);
    }

    @Test
    public void getSuperHeroByIdPositiveTest(){
        Assert.assertEquals(getSuperHeroById(createSuperHeroReturnId())
                .getStatusCode(), 200);
    }

    @Test
    public void deleteSuperHeroByIdPositiveTest(){
        Assert.assertEquals(deleteSuperHeroById(createSuperHeroReturnId())
                .getStatusCode(), 200);
    }
}
