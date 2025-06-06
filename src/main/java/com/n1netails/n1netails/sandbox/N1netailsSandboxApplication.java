package com.n1netails.n1netails.sandbox;

import com.n1netails.n1netails.discord.DiscordColor;
import com.n1netails.n1netails.discord.api.DiscordWebhookClient;
import com.n1netails.n1netails.discord.exception.DiscordWebhookException;
import com.n1netails.n1netails.discord.model.Embed;
import com.n1netails.n1netails.discord.model.WebhookMessage;
import com.n1netails.n1netails.kuda.api.Tail;
import com.n1netails.n1netails.kuda.internal.TailConfig;
import com.n1netails.n1netails.telegram.api.TelegramClient;
import com.n1netails.n1netails.telegram.exception.TelegramClientException;
import com.n1netails.n1netails.telegram.model.TelegramMessage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.n1netails.n1netails.sandbox.constant.ExampleConstant.LARGE_JAVA_EXCEPTION_STACK_TRACE;

@SpringBootApplication
public class N1netailsSandboxApplication implements CommandLineRunner {

	private final DiscordWebhookClient webhookClient;
	private final TelegramClient telegramClient;

    public N1netailsSandboxApplication(DiscordWebhookClient webhookClient, TelegramClient telegramClient) {
        this.webhookClient = webhookClient;
		this.telegramClient = telegramClient;
    }

    public static void main(String[] args) {
		SpringApplication.run(N1netailsSandboxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// ===================================================
		// Kuda
		// ===================================================

		// Set the n1netails-api url here.
		TailConfig.setApiUrl("http://localhost:9901");

		// (Optional set api path)
		// TailConfig.setApiPath("/ninetails/alert");

		// Generate n1ne token from n1netails-api
		TailConfig.setN1neToken("6e32618c-b496-41cb-a683-063fc6ae86cd");

		// Enable default uncaught exception handler
		TailConfig.enableExceptionHandler();

		// run n1netails kuda alerts example
		this.runKuda();

		// exception handler example
		this.runKudaExceptionHandler();

		// ===================================================
		// DISCORD WEBHOOK
		// ===================================================
		runDiscordWebhookClient();

		// ===================================================
		// TELEGRAM
		// ===================================================
		runTelegramClient();
	}

	private void runTelegramClient() throws TelegramClientException {
		TelegramMessage telegramMessage = new TelegramMessage("N1netails Telegram Works!", false);
		String chatid = "<replace-with-your-telegram-chat-id>";
		String botToken = "<replace-with-your-telegram-bot-token>";

		telegramClient.sendMessage(chatid, botToken, telegramMessage);
	}

	private void runDiscordWebhookClient() throws DiscordWebhookException {
		Embed embed = new Embed();
		embed.setTitle("Build Notification");
		embed.setDescription("The build has succeeded ✅");
		embed.setColor(DiscordColor.BLUE.getValue());

		WebhookMessage msg = new WebhookMessage();
		msg.setUsername("CI Bot");
		msg.setContent("Deployment update");
		msg.setEmbeds(List.of(embed));

		WebhookMessage og = new WebhookMessage("Staring up n1netails sandbox");

		String webhookUrl = "https://discord.com/api/webhooks/<replace-with-your-discord-webhook-url>";
		webhookClient.sendMessage(webhookUrl, msg);
	}

	private void runKuda() {
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


		// send one of each
		Tail.info("Testing kuda info5")
				.description("Extra description on the tail if needed")
				.details("extra log stack details")
				.type("SYSTEM_ALERT")
				.withTags(infotags).send();

		Tail.success("Testing kuda success5")
				.description("Extra description on the tail if needed")
				.details("extra log stack details")
				.type("SYSTEM_ALERT")
				.withTags(successtags).send();

		Tail.warn("Testing kuda warn5")
				.description("Extra description on the tail if needed")
				.details("extra log stack details")
				.type("SYSTEM_ALERT")
				.withTags(warntags).send();

		Tail.error("Testing kuda error5")
				.description("Extra description on the tail if needed")
				.details("extra log stack details")
				.type("SYSTEM_ALERT")
				.withTags(errortags).send();

		Tail.critical("Testing kuda critical5")
				.description("Extra description on the tail if needed")
				.details("extra log stack details")
				.type("SYSTEM_ALERT")
				.withTags(criticaltags).send();

		Tail.kuda("MY_KUDA_LEVEL", "Testing kuda5")
				.description("Extra description on the tail if needed")
				.details(LARGE_JAVA_EXCEPTION_STACK_TRACE)
				.type("SYSTEM_ALERT")
				.withTags(kudatags).send();
	}

	private void runKudaExceptionHandler() {
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
