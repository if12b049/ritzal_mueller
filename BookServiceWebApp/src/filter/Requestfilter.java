package filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

/**
 * Created by Roman on 20.11.2014.
 */
public class Requestfilter implements ContainerRequestFilter{
    @Override
    public void filter(ContainerRequestContext request) throws IOException {
        request.getHeaders().forEach();
    }
}
