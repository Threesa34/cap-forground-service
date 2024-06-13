export interface ForegroundServicePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
