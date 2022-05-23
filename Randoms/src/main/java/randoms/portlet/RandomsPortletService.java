package randoms.portlet;

import org.osgi.service.component.annotations.Component;

import java.util.Random;

@Component(immediate = true, service = RandomsPortletService.class)
public class RandomsPortletService {
    private final static int upperBound = 40;

    public void randomGenerator() {
        Random random = new Random();
        for (int i = 0; i < random.nextInt(upperBound); i++) {
            System.out.println("Random numbers"+random.nextInt(upperBound));
        }
    }
}
