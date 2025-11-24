package com.n1netails.n1netails.sandbox.service;

import com.n1netails.n1netails.kuda.api.Tail;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.n1netails.n1netails.sandbox.constant.ExampleConstant.LARGE_JAVA_EXCEPTION_STACK_TRACE;
import static com.n1netails.n1netails.sandbox.constant.ExampleConstant.LARGE_JAVA_NULL_EXCEPTION_STACK_TRACE;

@Service
public class KudaService {

    public void runKudaInfoNotifications() {
        /////////////////
        // INFO
        ////////////////
        Tail.info("Testing kuda info").send();
        Tail.info("Testing kuda info1").withTag("env", "prod").send();
        Tail.info("Testing kuda info2").description("Extra description on the tail if needed").send();
        Tail.info("Testing kuda info3").details("extra log stack details").send();
        Tail.info("Testing kuda info4").type("SYSTEM_ALERT").send();

        // utilizing all methods
        Map<String, String> infotags = new HashMap<>();
        infotags.put("env", "prod");
        infotags.put("test", "info");
        infotags.put("n1ne", "tails-info");
        Tail.info("Testing kuda info5")
                .description("Extra description on the tail if needed")
                .details("extra log stack details")
                .type("SYSTEM_ALERT")
                .withTags(infotags).send();
    }

    public void runKudaSuccessNotifications() {
        /////////////////
        // SUCCESS
        /////////////////
        Tail.success("Testing kuda success").send();
        Tail.success("Testing kuda success1").withTag("env", "prod").send();
        Tail.success("Testing kuda success2").description("Extra description on the tail if needed").send();
        Tail.success("Testing kuda success3").details("extra log stack details").send();
        Tail.success("Testing kuda success4").type("SYSTEM_ALERT").send();

        // utilizing all methods
        Map<String, String> successtags = new HashMap<>();
        successtags.put("env", "prod");
        successtags.put("test", "success");
        successtags.put("n1ne", "tails-success");
        Tail.success("Testing kuda success5")
                .description("Extra description on the tail if needed")
                .details("extra log stack details")
                .type("SYSTEM_ALERT")
                .withTags(successtags).send();
    }

    public void runKudaWarnNotifications() {
        /////////////////
        // WARN
        /////////////////
        Tail.warn("Testing kuda warn").send();
        Tail.warn("Testing kuda warn1").withTag("env", "prod").send();
        Tail.warn("Testing kuda warn2").description("Extra description on the tail if needed").send();
        Tail.warn("Testing kuda warn3").details("extra log stack details").send();
        Tail.warn("Testing kuda warn4").type("SYSTEM_ALERT").send();

        // utilizing all methods
        Map<String, String> warntags = new HashMap<>();
        warntags.put("env", "prod");
        warntags.put("test", "warn");
        warntags.put("n1ne", "tails-warn");
        Tail.warn("Testing kuda warn5")
                .description("Extra description on the tail if needed")
                .details("extra log stack details")
                .type("SYSTEM_ALERT")
                .withTags(warntags).send();

    }

    public void runKudaErrorNotifications() {
        /////////////////
        // ERROR
        /////////////////
        Tail.error("Testing kuda error").send();
        Tail.error("Testing kuda error1").withTag("env", "prod").send();
        Tail.error("Testing kuda error2").description("Extra description on the tail if needed").send();
        Tail.error("Testing kuda error3").details("extra log stack details").send();
        Tail.error("Testing kuda error4").type("SYSTEM_ALERT").send();

        Map<String, String> errortags = new HashMap<>();
        errortags.put("env", "prod");
        errortags.put("test", "error");
        errortags.put("n1ne", "tails-error");
        Tail.error("Testing kuda error5")
                .description("Extra description on the tail if needed")
                .details("extra log stack details")
                .type("SYSTEM_ALERT")
                .withTags(errortags).send();
    }

    public void runKudaCriticalNotifications() {
        /////////////////
        // CRITICAL
        /////////////////
        Tail.critical("Testing kuda critical").send();
        Tail.critical("Testing kuda critical1").withTag("env", "prod").send();
        Tail.critical("Testing kuda critical2").description("Extra description on the tail if needed").send();
        Tail.critical("Testing kuda critical3").details("extra log stack details").send();
        Tail.critical("Testing kuda critical4").type("SYSTEM_ALERT").send();

        Map<String, String> criticaltags = new HashMap<>();
        criticaltags.put("env", "prod");
        criticaltags.put("test", "critical");
        criticaltags.put("n1ne", "tails-critical");
        Tail.critical("Testing kuda critical5")
                .description("Extra description on the tail if needed")
                .details("extra log stack details")
                .type("SYSTEM_ALERT")
                .withTags(criticaltags).send();
    }

    public void runKudaNotifications() {
        /////////////////
        // KUDA
        // Send message with your own custom level (replace "MY_KUDA_LEVEL" with the level you want to create)
        /////////////////
        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda").send();
        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda1").withTag("env", "prod").send();
        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda2").description("Extra description on the tail if needed").send();
        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda3").details("extra log stack details").send();
        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda4").type("SYSTEM_ALERT").send();

        Map<String, String> kudatags = new HashMap<>();
        kudatags.put("env", "prod");
        kudatags.put("test", "kuda");
        kudatags.put("n1ne", "tails-kuda");
        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda5")
                .description("Extra description on the tail if needed")
                .details("extra log stack details")
                .type("SYSTEM_ALERT")
                .withTags(kudatags).send();

        Tail.kuda("MY_KUDA_LEVEL", "Testing kuda5")
                .description("Extra description on the tail if needed")
                .details(LARGE_JAVA_EXCEPTION_STACK_TRACE)
                .type("SYSTEM_ALERT")
                .withTags(kudatags).send();

        Map<String, String> kudaExceptiontags = new HashMap<>();
        kudaExceptiontags.put("env", "prod");
        kudaExceptiontags.put("application", "inari-service");
        Tail.error("Null Exception")
                .description("java.lang.NullPointerException: Cannot invoke \"String.length()\" because \"input\" is null")
                .details(LARGE_JAVA_NULL_EXCEPTION_STACK_TRACE)
                .type("SYSTEM_ALERT")
                .withTags(kudaExceptiontags).send();
    }

    public void runKudaExceptionHandler() {
        // exception handler
        try {
            throw new IllegalArgumentException("User ID was null");
        } catch (Exception e) {
            Tail.report(e); // manually report caught exception
        }

        // exception handler with custom tail level
        try {
            throw new IllegalArgumentException("CRITICAL - User ID was null");
        } catch (Exception e) {
            Tail.report("CRITICAL", e); // manually report caught exception with custom tail level
        }

        new Thread(() -> {
            throw new RuntimeException("This will trigger the handler");
        }).start();
    }
}
