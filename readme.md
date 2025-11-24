# N1netails

<div align="center">
  <img src="https://raw.githubusercontent.com/n1netails/n1netails/refs/heads/main/n1netails_icon_transparent.png" alt="N1ne Tails" width="500" style="display: block; margin: auto;"/>
</div>

# Sandbox
Sandbox that provides examples on how to use the n1netails libraries.

## Featured Libraries
- n1netails-kuda
- n1netails-discord-webhook-client
- n1netails-telegram-client
- n1netails-slack-client
- n1netails-teams-webhook-client

## Run the project with environment variables.

### Kuda
- N1NETAILS_SANDBOX_KUDA_N1NE_TOKEN (n1ne token value)
- N1NETAILS_SANDBOX_KUDA_API_URL (api url)
- N1NETAILS_SANDBOX_KUDA_API_PATH (api path)

### Microsoft Teams
- N1NETAILS_SANDBOX_TEAMS_WEBHOOK_URL (teams webhook url)

### Slack
- N1NETAILS_SANDBOX_SLACK_BOT_TOKEN (slack bot token value)
- N1NETAILS_SANDBOX_SLACK_CHANNEL (slack channel (eg. `#prototype`))

### Discord
- N1NETAILS_SANDBOX_DISCORD_WEBHOOK_URL (discord webhook url)

### Telegram
- N1NETAILS_SANDBOX_TELEGRAM_BOT_TOKEN (telegram bot token value)
- N1NETAILS_SANDBOX_TELEGRAM_CHAT_ID (telegram chat id)

Example:
```bash
mvn spring-boot:run -DN1NETAILS_SANDBOX_KUDA_N1NE_TOKEN=n1_your_n1ne_token_value -DN1NETAILS_SANDBOX_KUDA_API_URL=http://localhost:9901 -DN1NETAILS_SANDBOX_KUDA_API_PATH=/ninetails/alert
```