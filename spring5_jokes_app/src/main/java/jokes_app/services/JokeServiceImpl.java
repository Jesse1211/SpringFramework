package jokes_app.services;

//import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import jokes_app.data.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

/**
 * Created by jt on 1/22/21.
 */
@Service // a spring component which will be picked up by spring boot
public class JokeServiceImpl implements JokeService {

    private final ChuckNorrisQuotes chuckNorrisQuotes;

    public JokeServiceImpl() { // wiring up using java constructor (not DI)
        this.chuckNorrisQuotes = new ChuckNorrisQuotes();
    }

    @Override
    public String getJoke() {
        return chuckNorrisQuotes.getRandomQuote();
    }
}
