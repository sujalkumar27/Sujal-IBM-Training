# Task 20.6 — Feature Toggles (Spring Boot)

Enable or disable a new checkout flow with a feature flag. Flip it in
`application.yml` (or via env variable) — no redeploy of new code needed.

```yaml
features:
  new-checkout: true   # false -> old flow, true -> new flow
```

## Files
- `CheckoutApplication.java`  — Spring Boot entry point
- `FeatureFlags.java`         — `@ConfigurationProperties` bean
- `CheckoutService.java`      — chooses old or new path via the flag
- `CheckoutController.java`   — `POST /checkout`
- `application.yml`           — where you flip the flag

## Try it
```
POST http://localhost:8080/checkout
{ "cartId": "abc-123", "amount": 250.00 }
```
Change `features.new-checkout` and restart to see the other path run.
