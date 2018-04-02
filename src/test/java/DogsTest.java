import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.junit.MatcherAssert.assertThat;

public final class DogsTest {
    @Test
    public void ShouldBeAbleToGetABreedName() {
        Dogs dogs = new Dogs("Bugle", 10, 29.99);
        dogs.setBreedname("Bugle");
        assertThat(dogs.getBreedname(), Is.is("Bugle"));
    }

    @Test
    public void ShouldBeAbleToGetTheAgeOfTheDog() {
        Dogs dogs = new Dogs("Bugle", 10, 29.99);
        dogs.setAge(10);
        assertThat(dogs.getAge(), Is.is(10));
    }

    @Test
    public void ShouldBeAbleToGetThePriceOfTheDog() {
        Dogs dogs = new Dogs("Bugle", 10, 29.99);
        dogs.setPrice(29.99);
        assertThat(dogs.getPrice(), Is.is(29.99));
    }
}
