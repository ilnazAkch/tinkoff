package container;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContainerTest extends IntegrationEnvironment {

    @Test
    public void test() {
        Assertions.assertTrue(POSTGRE_SQL_CONTAINER.isCreated());
    }
}
