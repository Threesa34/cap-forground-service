import { WebPlugin } from '@capacitor/core';

import type { ForegroundServicePlugin } from './definitions';

export class ForegroundServiceWeb extends WebPlugin implements ForegroundServicePlugin {
  startForegroundService(): Promise<{ result: string; }> {
    throw new Error('Method not implemented.');
  }
  stopForegroundService(): Promise<{ result: string; }> {
    throw new Error('Method not implemented.');
  }
}
