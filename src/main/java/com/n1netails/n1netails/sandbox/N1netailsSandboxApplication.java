package com.n1netails.n1netails.sandbox;

import com.n1netails.n1netails.sandbox.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;


@Profile("!test")
@RequiredArgsConstructor
@SpringBootApplication
public class N1netailsSandboxApplication implements CommandLineRunner {

	public final KudaService kudaService;
	public final DiscordService discordService;
	public final SlackService slackService;
	public final TeamsService teamsService;
	public final TelegramService telegramService;

    public static void main(String[] args) {
		SpringApplication.run(N1netailsSandboxApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


		// ===================================================
		// Kuda
		// ===================================================
		// run n1netails kuda info notifications example
		this.kudaService.runKudaInfoNotifications();
		// run n1netails kuda success notifications example
		this.kudaService.runKudaSuccessNotifications();
		// run n1netails kuda warn notifications example
		this.kudaService.runKudaWarnNotifications();
		// run n1netails kuda error notifications example
		this.kudaService.runKudaErrorNotifications();
		// run n1netails kuda critical notifications example
		this.kudaService.runKudaCriticalNotifications();
		// run n1netails kuda custom notifications example
		this.kudaService.runKudaNotifications();

		// exception handler example
		this.kudaService.runKudaExceptionHandler();

		// ===================================================
		// DISCORD WEBHOOK
		// ===================================================
		this.discordService.sendNotification();

		// ===================================================
		// TELEGRAM
		// ===================================================
		this.telegramService.sendNotification();

		// ===================================================
		// SLACK
		// ===================================================
		this.slackService.sendNotification();

		// ===================================================
		// TEAMS
		// ===================================================
		this.teamsService.sendNotification();
	}
}
