package dummy;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class App {
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        try {
            context.addRoutes(new RouteBuilder() {
                @Override
                public void configure() {
                    from("file://data?noop=true")
                            .filter(exchange -> {
                                System.out.println(exchange);
                                return exchange.getIn() != null;
                            })
                            .to("stream:out");
                }
            });
            context.start();
            Thread.sleep(2000);
        } finally {
            context.stop();
        }
    }
}
