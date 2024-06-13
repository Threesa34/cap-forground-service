export interface ForegroundServicePlugin {
  startForegroundService(): Promise<{ result: string }>;
  stopForegroundService(): Promise<{ result: string }>;
}
