package org.company.order.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
public final class LogUtil {

    private LogUtil() {
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
    private static final AtomicInteger counter = new AtomicInteger(100_000);

    public static String logId() {
        LocalDateTime localDateTime = LocalDateTime.now();
        String logId = localDateTime.format(formatter) + "C" + counter.getAndIncrement();
        return logId;
    }

    public static String getParams(final String[] paramNames, final Object[] paramValues) {
        return IntStream.range(0, paramNames.length)
                .mapToObj(i -> paramNames[i] + "=" + paramValues[i])
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static Map<String, Object> getParamsAsMap(final String[] paramNames, final Object[] paramValues) {
        Map<String, Object> params = new HashMap<>();
        for (int i = 0; i < paramNames.length; i++)
            params.put(paramNames[i], paramValues[i]);
        return params;
    }

    public static void logApplicationStartup(Environment env) {
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        String serverPort = env.getProperty("server.port");
        String contextPath = env.getProperty("server.servlet.context-path");
        if (StringUtils.isBlank(contextPath)) {
            contextPath = "/";
        }
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}{}\n\t" +
                        "External: \t{}://{}:{}{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                serverPort,
                contextPath,
                protocol,
                hostAddress,
                serverPort,
                contextPath,
                env.getActiveProfiles());
    }
}
