# Zigpoll Android SDK — Example App

A minimal Android app showing [Zigpoll](https://www.zigpoll.com) surveys presented natively with the [Zigpoll Android SDK](https://github.com/zigpoll/zigpoll-android).

## Run it

1. In the [Zigpoll dashboard](https://app.zigpoll.com), create a survey and set its delivery type to **API** (Delivery Settings → API).
2. Open this project in Android Studio (the SDK resolves via JitPack).
3. In `app/src/main/java/com/zigpoll/example/MainActivity.kt`, replace:
   - `YOUR_ACCOUNT_ID` — your account id (Dashboard → Installation)
   - `YOUR_SURVEY_ID` — the survey's id
4. Run on an emulator or device and tap **Trigger survey**.

The example uses `preview = true`, so test responses are not billed or counted in analytics.

## What it demonstrates

- `Zigpoll.configure` / `identify` / `setMetadata` / `logout`
- `Zigpoll.trigger(pollId, activity)` presenting a survey in a bottom sheet
- Lifecycle callbacks: `onLoad`, `onComplete`, `onClose`, `onError`

## Docs

Full guide: https://docs.zigpoll.com/installation/android-sdk
