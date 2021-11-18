package org.company.order;

import lombok.extern.slf4j.Slf4j;
import org.company.order.adapter.out.repository.MongoOrderRepository;
import org.company.order.config.properties.ApplicationProperties;
import org.company.order.domain.ContactInfo;
import org.company.order.domain.Order;
import org.company.order.domain.OrderStatus;
import org.company.order.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;
import java.util.UUID;


@Slf4j
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class MsOrderApplication implements CommandLineRunner {

    @Autowired
    private MongoOrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MsOrderApplication.class);
        Environment env = app.run(args).getEnvironment();
        LogUtil.logApplicationStartup(env);
    }

    @Override
    public void run(String... args) throws Exception {
        var orderrr = new Order(
                UUID.randomUUID().toString(),
                "99999999",
                "laptop",
                "22222",
                OrderStatus.DELIVERY_COMPLETED,
                "  baku az    ",
                LocalDateTime.now().minusWeeks(2),
                LocalDateTime.now(),
                "QQQQQQQQQQ" + UUID.randomUUID().toString(),
                new ContactInfo("name", "9941212"),
                new ContactInfo("name", "9941212"),
                "order notes",
                null
        );
        orderRepository.save(orderrr);
        System.out.println(orderRepository
                .loadByUUID("1qaz2wsx-as").isPresent());
    }
}
